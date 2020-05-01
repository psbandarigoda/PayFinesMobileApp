package com.example.payfines;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PayFines extends AppCompatActivity {

    Button confPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_fines);

        confPay = findViewById(R.id.btnConfPayment);

    }

    protected void onResume() {
        super.onResume();
//        confPay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(PayFines.this, Offender.class);
//                startActivity(intent);
//                Toast.makeText(getApplicationContext(), "Rules Selected", Toast.LENGTH_LONG).show();
//            }
//        });

    }
}
