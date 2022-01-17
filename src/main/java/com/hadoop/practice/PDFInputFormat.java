package com.hadoop.practice;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class PDFInputFormat extends FileInputFormat<Text, PDFWritable> {
    @Override
    public boolean isSplitable(JobContext context, Path filename){
        return false;
    }

    @Override
    public RecordReader<Text, PDFWritable> createRecordReader
            (InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        PDFRecordReader reader= new PDFRecordReader();
        reader.initialize(inputSplit,taskAttemptContext);
        return reader;
    }
    public class PDFRecordReader extends RecordReader<Text,PDFWritable>{

        private FileSplit split;
        private Configuration conf;
        private Text currKey= null;
        private PDFWritable currValue=null;
        private boolean fileProcessed=false;
        @Override
        public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
            this.split= (FileSplit) inputSplit;
            this.conf=taskAttemptContext.getConfiguration();
        }

        @Override
        public boolean nextKeyValue() throws IOException, InterruptedException {
            if(fileProcessed){
                return  false;
            }
            int fileLength= (int) split.getLength();
            byte[] result= new byte[fileLength];
            FileSystem fs = FileSystem.get(conf);
            FSDataInputStream in = null;
            try{
                in = fs.open(split.getPath());
                IOUtils.readFully(in,result,0,fileLength);
            }catch (Exception e){

            }finally {
                IOUtils.closeStream(in);
            }
               this.fileProcessed=true;
            Path file=split.getPath();
            this.currKey=new Text(file.getName());
            this.currValue=new PDFWritable(result);
            return false;
        }

        @Override
        public Text getCurrentKey() throws IOException, InterruptedException {
            return null;
        }

        @Override
        public PDFWritable getCurrentValue() throws IOException, InterruptedException {
            return null;
        }

        @Override
        public float getProgress() throws IOException, InterruptedException {
            return 0;
        }

        @Override
        public void close() throws IOException {

        }
    }
}
