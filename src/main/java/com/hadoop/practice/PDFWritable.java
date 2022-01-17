package com.hadoop.practice;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;


import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PDFWritable implements Writable {
    private byte[] bytes;
    public PdfReader reader = null;
    public PDFWritable(){}
    public PDFWritable(byte[] result) {
        this.bytes = result;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        Document document =new Document(PageSize.LETTER,40,40,40,40);

        try{
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            PdfWriter.getInstance(document,output);
            document.open();
            Paragraph p = new Paragraph(new String(bytes));
            document.add(p);
            document.close();

            WritableUtils.writeVInt(dataOutput,output.size());
            dataOutput.write(output.toByteArray(),0,output.size());

        }catch (Exception ex){

        }
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

        int newLength= WritableUtils.readVInt(dataInput);
        bytes = new byte[newLength];
        dataInput.readFully(bytes,0,newLength);
        try{
            reader=new PdfReader(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
