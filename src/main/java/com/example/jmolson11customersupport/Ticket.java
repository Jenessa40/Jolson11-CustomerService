package com.example.jmolson11customersupport;

import jakarta.servlet.http.Part;

import java.util.ArrayList;

public class Ticket {
   private int number;
   private String customerName;
   private String subject;
   private String ticketBody;
   private ArrayList<String> attachments; //to store file paths

   public Ticket(int number, String customerName, String subject, Part ticketBody){
       this.number = number;
       this.customerName = customerName;
       this.subject = subject;
       this.ticketBody = ticketBody;
       this.attachments = new ArrayList<>(); //start attachment list
   }

   public String toString() {
       return "Ticket #" + this.number +
               "\nCustomer: " + this.customerName +
               "\nSubject: " + this.subject +
               "\nBody: " + this.ticketBody +
               "\nAttachments: " + this.attachments;
    }
   }

