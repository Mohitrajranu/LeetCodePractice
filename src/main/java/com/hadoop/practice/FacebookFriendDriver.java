package com.hadoop.practice;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class FacebookFriendDriver extends Configured implements Tool {

    public static void main(String[] args) throws Exception {
        int exitcode = ToolRunner.run(new FacebookFriendDriver(),args);
        System.exit(exitcode);
    }

    @Override
    public int run(String[] args) throws Exception {
        if (args.length !=2){
            System.out.println("Usage MaximumClosePrice <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance(getConf(),"facebook-friends");
        job.setJarByClass(FacebookFriendDriver.class);
        //Set input and output locations
        FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        //set Input and output formats
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);

        job.setMapperClass(FacebookFriendsMapper.class);
        job.setReducerClass(FacebookFriendsReducer.class);

        job.setMapOutputKeyClass(FriendPair.class);
        job.setMapOutputValueClass(FriendArray.class);
        job.setOutputKeyClass(FriendPair.class);
        job.setOutputValueClass(FriendArray.class);


        return job.waitForCompletion(true) ? 0:1;
    }
}
