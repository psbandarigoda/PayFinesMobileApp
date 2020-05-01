package com.example.payfines;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Offender extends AppCompatActivity {

    Button next;
    String userName;
    DatabaseReference dbRef;
    ArrayList ruleArray1 = new ArrayList();
    EditText dlNo, oName, oEmail, oAddress, oContact, oLocation;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offender);

        next = findViewById(R.id.btnOffenDtl);
        dlNo = findViewById(R.id.drivingLicenseNoE);
        oName = findViewById(R.id.offenderNameE);
        oEmail = findViewById(R.id.offenderEmailE);
        oAddress = findViewById(R.id.offenderAddressE);
        oContact = findViewById(R.id.offenderContactE);
        oLocation = findViewById(R.id.locationE);

        Intent uName = getIntent();
        userName = uName.getStringExtra("userName");

        Intent ruleArray = getIntent();
        ruleArray1 = ruleArray.getIntegerArrayListExtra("ruleArray");


        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Low weight vehicle", "High weight vehicle", "Land vehicle"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

    }

    protected void onResume() {
        super.onResume();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (TextUtils.isEmpty(dlNo.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter D.L.No", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(oName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(oEmail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter E-Mail", Toast.LENGTH_LONG).show();
                    else if (!(oEmail.getText().toString()).matches(emailPattern))
                        Toast.makeText(getApplicationContext(), "Invalid E-Mail", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(oAddress.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Address", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(oContact.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Phone No", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(oLocation.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Location", Toast.LENGTH_LONG).show();
                    else {
                        Intent intent = new Intent(Offender.this, FinesLeaflet.class);
                        intent.putExtra("userName", userName);
                        intent.putExtra("ruleArray", ruleArray1);
                        intent.putExtra("dlNo", dlNo.getText().toString());
                        intent.putExtra("oName", oName.getText().toString());
                        intent.putExtra("oEmail", oEmail.getText().toString());
                        intent.putExtra("oAddress", oAddress.getText().toString());
                        intent.putExtra("oContact", oContact.getText().toString());
                        intent.putExtra("oLocation", oLocation.getText().toString());
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Offender Details Added", Toast.LENGTH_LONG).show();
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Offender Details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
