package com.example.glondhe.actionbar_intent_toolbar_sample_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 20;
    ArrayList<Contacts> contact;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffe0e0e0")));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("First-Activity");
        setSupportActionBar(toolbar);

        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contact = Contacts.createContactsList();

        contactAdapter = new ContactAdapter(this, contact);

        recyclerView.setAdapter(contactAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        if (id == R.id.searchIcon) {
//            Toast.makeText(MainActivity.this, "Thanks for Searching!!", Toast.LENGTH_SHORT).show();
//        }

        return super.onOptionsItemSelected(item);
    }

    public void searchList(MenuItem item) {

//        Toast.makeText(MainActivity.this, "Thanks for Searching!!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, AddContactList.class);
        intent.putExtra("phone1", "5301241232");
        intent.putExtra("phone2", "4088131682");
        intent.putExtra("phone3", "6508663272");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // Extract name value from result extras
            Bundle bundle = intent.getExtras();
            Contacts c = bundle.getParcelable("dataToSend");
            //String name = data.getExtras().getString("name");
            //String number = data.getExtras().getString("number");
            // Toast the name to display temporarily on screen

            Toast.makeText(this, c.getName() + c.getNumber(), Toast.LENGTH_LONG).show();

            View parentLayout = findViewById(R.id.rvContacts);
            Snackbar.make(parentLayout, c.getName() + c.getNumber(), Snackbar.LENGTH_LONG).show();

            contact.add(0, new Contacts(c.getName(), c.getNumber()));
            // Notify the adapter that an item was inserted at position 0
            contactAdapter.notifyItemInserted(0);
        }
    }
}
