package com.example.glondhe.actionbar_intent_toolbar_sample_app;

import java.util.ArrayList;

/**
 * Created by glondhe on 10/10/16.
 */
public class Contact {

    private String mName;
    private String mNumber;

    public Contact(String Name, String Number){
        mName = Name;
        mNumber = Number;
    }

    public String getName(){
        return mName;
    }

    public String getNumber(){
        return mNumber;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList() {
        ArrayList<Contact> contact = new ArrayList<Contact>();

        contact.add(new Contact("Person " + ++lastContactId, "3255551234"));
        contact.add(new Contact("Person " + ++lastContactId, "2374823499"));
        contact.add(new Contact("Person " + ++lastContactId, "2237987493"));
        contact.add(new Contact("Person " + ++lastContactId, "3255551234"));
        contact.add(new Contact("Person " + ++lastContactId, "7648732686"));
        contact.add(new Contact("Person " + ++lastContactId, "3255551234"));
        contact.add(new Contact("Person " + ++lastContactId, "3762784638"));
        contact.add(new Contact("Person " + ++lastContactId, "3255551234"));
        contact.add(new Contact("Person " + ++lastContactId, "9829479124"));
        contact.add(new Contact("Person " + ++lastContactId, "7498594835"));
        contact.add(new Contact("Person " + ++lastContactId, "3255551234"));
        contact.add(new Contact("Person " + ++lastContactId, "8596895803"));
        contact.add(new Contact("Person " + ++lastContactId, "3284823749"));
        contact.add(new Contact("Person " + ++lastContactId, "9859684500"));
        contact.add(new Contact("Person " + ++lastContactId, "3255551234"));
        contact.add(new Contact("Person " + ++lastContactId, "4586905008"));
        contact.add(new Contact("Person " + ++lastContactId, "3255551234"));
        contact.add(new Contact("Person " + ++lastContactId, "5946956083"));



        return contact;
    }
}
