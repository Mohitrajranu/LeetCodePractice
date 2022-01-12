package com.hadoop.practice;

import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacebookFriendsReducer extends Reducer<FriendPair,FriendArray,FriendPair,FriendArray> {
    @Override
    protected void reduce(FriendPair key, Iterable<FriendArray> values, Context context) throws IOException, InterruptedException {
        List<Friend[]> fList = new ArrayList<>();
        List<Friend> commonFriendsList = new ArrayList<>();
        int count=0;
        for (FriendArray friendArray:values){
            Friend[] f= Arrays.copyOf(friendArray.get(),friendArray.get().length,Friend[].class);
            fList.add(f);
            count++;
        }
        if(count!=2){
            return;
        }
        for (Friend outerf:fList.get(0)){
            for (Friend innwerf: fList.get(1)){
                if(outerf.equals(innwerf)){
                    commonFriendsList.add(innwerf);
                }
            }
        }
        Friend[] commonFriendArray=Arrays.copyOf(commonFriendsList.toArray(),commonFriendsList.toArray().length,Friend[].class);
        context.write(key,new FriendArray(Friend.class,commonFriendArray));
    }
}
