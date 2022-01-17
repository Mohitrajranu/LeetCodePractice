package com.hadoop.practice;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Documented;

public class PDFOutputFormat extends FileOutputFormat<Text,PDFWritable> {
    TaskAttemptContext job;
    @Override
    public RecordWriter<Text, PDFWritable> getRecordWriter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
       this.job=taskAttemptContext;

        return new PDFRecordWriter(job);
    }
    public class PDFRecordWriter extends RecordWriter<Text,PDFWritable>{

        TaskAttemptContext job;
        Path file;
        FileSystem fs;
        int i=0;

        PDFRecordWriter(TaskAttemptContext job) {
             this.job = job;
        }

        @Override
        public synchronized void write(Text text, PDFWritable pdfWritable) throws IOException, InterruptedException {
            Configuration conf=job.getConfiguration();
            Path name = getDefaultWorkFile(job,null);
            String outfilePath = name.toString();
            String keyname = text.toString();
            Path file=new Path((outfilePath.substring(0,outfilePath.length()-16))+keyname+".pdf");
            FileSystem fs = file.getFileSystem(conf);
            FSDataOutputStream fileOut = fs.create(file,false);
            try{
                Document doc = new Document();
                PdfCopy copy = new PdfCopy(doc,(OutputStream) fileOut);
                int i=0;

                doc.open();
                while(i<pdfWritable.reader.getNumberOfPages()){
                    i++;
                    copy.addPage(copy.getImportedPage(pdfWritable.reader,i));
                }
                doc.close();
            }catch(Exception ex){

            }

        }

        @Override
        public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {

        }
    }
}
