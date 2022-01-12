package com.hadoop.practice;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class FriendPair implements WritableComparable {
    Friend first;
    Friend second;

    public FriendPair() {
        this.first = new Friend();
        this.second = new Friend();
    }

    public FriendPair(Friend first, Friend second) {
        this.first = first;
        this.second = second;
    }

    public Friend getFirst() {
        return first;
    }

    public void setFirst(Friend first) {
        this.first = first;
    }

    public Friend getSecond() {
        return second;
    }

    public void setSecond(Friend second) {
        this.second = second;
    }

    @Override
    public int compareTo(Object o) {
        FriendPair pair2= (FriendPair) o;
        int cmp=-1;
        if(getFirst().compareTo(pair2.getFirst()) == 0 || getFirst().compareTo(pair2.getSecond())==0){
            cmp=0;
        }
        if(cmp!=0){
            return cmp;
        }
        cmp=-1;
        if(getSecond().compareTo(pair2.getSecond()) == 0 || getFirst().compareTo(pair2.getFirst())==0){
            cmp=0;
        }

        return cmp;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        first.write(dataOutput);
        second.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        first.readFields(dataInput);
        second.readFields(dataInput);
    }

    @Override
    public boolean equals(Object o) {
        FriendPair pair2 = (FriendPair) o;
        boolean eq= getFirst().equals(pair2.getFirst()) || getFirst().equals(pair2.getSecond());
        if(!eq)
            return eq;

        return getSecond().equals(pair2.getFirst()) ||
                getSecond().equals(pair2.getSecond());
    }

    @Override
    public String toString() {
        return "FriendPair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public int hashCode() {
        return first.getId().hashCode()+second.getId().hashCode();
    }

}
