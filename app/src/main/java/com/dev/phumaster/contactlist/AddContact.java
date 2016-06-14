package com.dev.phumaster.contactlist;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class AddContact extends AppCompatActivity implements View.OnClickListener{

    Button btnSaveContact, btnCancel;
    EditText edtName, edtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        btnSaveContact = (Button) findViewById(R.id.btnSaveContact);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);

        btnSaveContact.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSaveContact) {
            Intent intent = new Intent();
            Contact newContact = new Contact(edtName.getText().toString(), Integer.parseInt(edtNumber.getText().toString()));
            intent.putExtra("newContact", (Serializable) newContact);
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}
