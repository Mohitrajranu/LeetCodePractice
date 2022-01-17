package com.hadoop.practice;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class PDFMapper extends Mapper<Text,PDFWritable,Text,PDFWritable> {
    String dirName = null;
    String fileName = null;

    @Override
    protected void map(Text key, PDFWritable value, Context context) throws IOException, InterruptedException {
        try{
            context.write(key,value);
        }catch (Exception ex){

        }

    }
}
