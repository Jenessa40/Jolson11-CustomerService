package com.example.jmolson11customersupport;

public class Attachment {
    private String name;
    private byte[] contents;

    //getter, setter
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter/setter
    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }
}

