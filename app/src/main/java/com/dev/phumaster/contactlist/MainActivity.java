package com.dev.phumaster.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAddContact, btnExit;
    ListView lvListContact;
    ArrayList<Contact> listContact = new ArrayList<Contact>();
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddContact = (Button) findViewById(R.id.btnAddContact);
        btnExit = (Button) findViewById(R.id.btnExit);
        lvListContact = (ListView) findViewById(R.id.lvListContact);

        adapter = new ContactAdapter(MainActivity.this, R.layout.single_layout, listContact);
        lvListContact.setAdapter(adapter);

        btnAddContact.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 14 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            Contact newContact = new Contact(bundle.get("name").toString(), Integer.parseInt(bundle.get("number").toString()));
            listContact.add(newContact);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExit:
                finish();
                break;
            case R.id.btnAddContact:
                Intent intent = new Intent(MainActivity.this, AddContact.class);
                startActivityForResult(intent, 14);
                break;
        }
    }
}
