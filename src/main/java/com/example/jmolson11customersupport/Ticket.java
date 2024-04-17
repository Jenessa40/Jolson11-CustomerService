package com.example.jmolson11customersupport;
import java.io.InputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ticket {
    private String customerName;
    private String subject;
    private String body;
    private Attachment attachment;

    //getter and setter methods
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String title) {
        this.customerName = customerName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //Helper method
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment Attachment() {
        return attachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }
}

