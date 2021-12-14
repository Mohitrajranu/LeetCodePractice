package com.hadoop.practice;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class MaximumClosePrice {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length !=2){
            System.out.println("Usage MaximumClosePrice <input path> <output path>");
            System.exit(-1);
        }
        //Define MapReduce Job
        Job job = new Job();
        job.setJarByClass(MaximumClosePrice.class);
        job.setJobName("MaximumClosePrice");
        //Set input and output locations
        FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        //set Input and output formats
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        //set mapper and reduce classes
        //job.setMapperClass();
        //job.setReducerClass();
        //output types
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);
        //submit job
        System.exit(job.waitForCompletion(true) ? 0:1);


    }
}
