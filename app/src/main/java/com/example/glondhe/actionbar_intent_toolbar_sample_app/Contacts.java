package com.example.glondhe.actionbar_intent_toolbar_sample_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by glondhe on 10/12/16.
 */

public class Contacts implements Parcelable {
    // You can include parcel data types
    private String mNumber;
    private String mName;

    public Contacts(String Name, String Number){
        mName = Name;
        mNumber = Number;
    }

    // This is where you write the values you want to save to the `Parcel`.
    // The `Parcel` class has methods defined to help you save all of your values.
    // Note that there are only methods defined for simple values, lists, and other Parcelable objects.
    // You may need to make several classes Parcelable to send the data you want.
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mNumber);
        out.writeString(mName);
    }

    // Using the `in` variable, we can retrieve the values that
    // we originally wrote into the `Parcel`.  This constructor is usually
    // private so that only the `CREATOR` field can access.
    public Contacts(Parcel in) {
        mNumber = in.readString();
        mName = in.readString();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
            this.mName = name;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        this.mNumber = number;
    }
    // In the vast majority of cases you can simply return 0 for this.
    // There are cases where you need to use the constant `CONTENTS_FILE_DESCRIPTOR`
    // But this is out of scope of this tutorial
    @Override
    public int describeContents() {
        return 0;
    }

    // After implementing the `Parcelable` interface, we need to create the
    // `Parcelable.Creator<MyParcelable> CREATOR` constant for our class;
    // Notice how it has our class specified as its type.
    public static final Parcelable.Creator<Contacts> CREATOR
            = new Parcelable.Creator<Contacts>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Contacts createFromParcel(Parcel in) {
            return new Contacts(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Contacts[] newArray(int size) {
            return new Contacts[size];
        }
    };

    private static int lastContactId = 0;

    public static ArrayList<Contacts> createContactsList() {
        ArrayList<Contacts> contacts = new ArrayList<Contacts>();

        contacts.add(new Contacts("Jacob " + ++lastContactId, "3255551234"));
        contacts.add(new Contacts("Aiden " + ++lastContactId, "7498594835"));
        contacts.add(new Contacts("Ava " + ++lastContactId, "3255551234"));
        contacts.add(new Contacts("Anthony " + ++lastContactId, "8596895803"));
        contacts.add(new Contacts("Sophia " + ++lastContactId, "3284823749"));
        contacts.add(new Contacts("William " + ++lastContactId, "7648732686"));
        contacts.add(new Contacts("Liam " + ++lastContactId, "3255551234"));
        contacts.add(new Contacts("Olivia " + ++lastContactId, "9859684500"));
        contacts.add(new Contacts("Emily " + ++lastContactId, "3255551234"));
        contacts.add(new Contacts("Michael " + ++lastContactId, "3255551234"));
        contacts.add(new Contacts("Alexander " + ++lastContactId, "9829479124"));
        contacts.add(new Contacts("Chloe " + ++lastContactId, "4586905008"));
        contacts.add(new Contacts("Mason " + ++lastContactId, "2374823499"));
        contacts.add(new Contacts("Ethan " + ++lastContactId, "2237987493"));
        contacts.add(new Contacts("Mia " + ++lastContactId, "3255551234"));
        contacts.add(new Contacts("Madison " + ++lastContactId, "5946956083"));
        contacts.add(new Contacts("Noah " + ++lastContactId, "3255551234"));
        contacts.add(new Contacts("Jayden " + ++lastContactId, "3762784638"));
        contacts.add(new Contacts("Elizabeth " + ++lastContactId, "9859684500"));
        contacts.add(new Contacts("Charlotte " + ++lastContactId, "3255551234"));
        return contacts;
    }
}