package com.dev.phumaster.contactlist;

import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        Intent intent = new Intent();
        if(v.getId() == R.id.btnSaveContact) {
            String name = edtName.getText().toString();
            String number = edtNumber.getText().toString();
            intent.putExtra("name", name);
            intent.putExtra("number", number);
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
