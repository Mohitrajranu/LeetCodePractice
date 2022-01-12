package com.hadoop.practice;




import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FacebookFriendsMapper extends Mapper<LongWritable, Text,FriendPair,FriendArray> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Logger log = Logger.getLogger(FacebookFriendsMapper.class);
        StringTokenizer st = new StringTokenizer(value.toString(),"\t");
        String person= st.nextToken();
        String friends = st.nextToken();
        Friend f1=populateFriend(person);
        List<Friend> friendList=populateFriendList(friends);
        Friend[] friendArray= Arrays.copyOf(friendList.toArray(),friendList.toArray().length,Friend[].class);
        FriendArray farray= new FriendArray(Friend.class,friendArray);
        for (Friend f2:friendList){
            FriendPair fpair=new FriendPair(f1,f2);
            context.write(fpair,farray);
            log.info(fpair+":::::"+farray);
        }

    }
    private  Friend populateFriend(String friendJson){
        JSONParser parser = new JSONParser();
        Friend friend = null;
        try{
            Object obj = (Object)parser.parse((friendJson));
            JsonObject jsonObject = (JsonObject) obj;
            JsonElement lid= jsonObject.get("id");
            JsonElement jname= jsonObject.get("name");
            JsonElement jhometown = jsonObject.get("hometown");
            IntWritable id=new IntWritable(lid.getAsInt());
            Text name = new Text(jname.getAsString());
            Text hometown = new Text(jhometown.getAsString());
            friend = new Friend(id,name,hometown);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return friend;
    }
    private List<Friend> populateFriendList(String friendsJson){
        List<Friend> friendList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = (Object)parser.parse((friendsJson.toString()));
            JsonArray jsonArray = (JsonArray) obj;
            for (Object jobj:jsonArray){
                JsonObject jsonObject = (JsonObject) jobj;
                JsonElement lid= jsonObject.get("id");
                JsonElement jname= jsonObject.get("name");
                JsonElement jhometown = jsonObject.get("hometown");
                IntWritable id=new IntWritable(lid.getAsInt());
                Text name = new Text(jname.getAsString());
                Text hometown = new Text(jhometown.getAsString());
                Friend  friend = new Friend(id,name,hometown);
                friendList.add(friend);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return friendList;
    }
}
