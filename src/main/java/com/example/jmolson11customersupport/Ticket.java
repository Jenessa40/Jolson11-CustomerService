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
   private Map<String, String> attachments; //to store file paths

    //constructor
   public Ticket(String customerName, String subject, String body){
       this.customerName = customerName;
       this.subject = subject;
       this.body = body;
       this.attachments = new HashMap<>();
    }
    //Default constructor
    public Ticket(){
       this.customerName = "";
       this.subject = "";
       this.body = "";
       this.attachments = new HashMap<>();
    }

    public static boolean getTicket() {
       return false;
    }

    public static InputStream getInputStream() {
       return null;
    }

    public static String getSubmittedFileName() {
       return null;
    }

    //getter and setter methods
    public String getCustomerName(){
       return customerName;
    }
    public void setCustomerName(String title){
       this.customerName = customerName;
    }
    public String getSubject(){
       return subject;
    }
    public void setSubject(String subject){
       this.subject = subject;
    }
    public String getBody(){
       return body;
    }
    public void setBody(String body){
       this.body = body;
    }
    //Helper method
    public void addAttachment(String attachmentName, String attachmentContent){
       attachments.put(attachmentName, attachmentContent);
    }
    public int getNumberOfAttachments(){
       return attachments.size();
    }
    public List<String>getAllAttachements(){
       return new ArrayList<>(attachments.values());
    }

   }

