package com.example.glondhe.actionbar_intent_toolbar_sample_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddContactList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Second-Activity");
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_message_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void onSubmit(View v) {
        EditText etName = (EditText) findViewById(R.id.edTxName);
        EditText etNumber = (EditText) findViewById(R.id.edTxNumber);


        Contacts dataToSend = new Contacts(etName.toString(),etNumber.toString());
        dataToSend.setName(etName.getText().toString());
        dataToSend.setNumber(etNumber.getText().toString());
        Intent data = new Intent();

        //data.putExtra("name", etName.getText().toString());
        //data.putExtra("number", etNumber.getText().toString());
        data.putExtra("dataToSend",dataToSend);
        setResult(RESULT_OK, data);
        finish();
    }
}
