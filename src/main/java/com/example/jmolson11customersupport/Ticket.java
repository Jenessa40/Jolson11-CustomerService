package com.example.jmolson11customersupport;
import com.example.jmolson11customersupport.entities.Attachment;

import java.time.LocalDate;

public class Ticket {
    private String customerName;
    private String subject;
    private String body;
    private Attachment attachment;
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return null;
    }

    public void setTitle(String title) {
    }

    public Object setDate(LocalDate localDate) {
        return null;
    }
}

