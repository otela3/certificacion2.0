package com.example.certificacion20.model;

import java.util.ArrayList;

public class NovaResponse {
    private Integer count;
    private String next,previus;
    private ArrayList<Nova> result;

    public NovaResponse(Integer count, String next, String previus, ArrayList<Nova> result) {
        this.count = count;
        this.next = next;
        this.previus = previus;
        this.result = result;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevius() {
        return previus;
    }

    public void setPrevius(String previus) {
        this.previus = previus;
    }

    public ArrayList<Nova> getResult() {
        return result;
    }

    public void setResult(ArrayList<Nova> result) {
        this.result = result;
    }
}
