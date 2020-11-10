package com.example.payfines;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class PayFines extends AppCompatActivity {

    public static final String ACCOUNT_SID =
            "AC4be62a0cef44e943564b3b68be0a3aa1";
    public static final String AUTH_TOKEN =
            "your_auth_token";

    Button confPay;
    String userName, officerName, fineID, FineTotPrice, contact;
    String message = "payment success";
    TextView setUserName, setFineID, setFineTotPrice, setOffenderName, setOffenderContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_fines);

        confPay = findViewById(R.id.btnConfPayment);

        setUserName = findViewById(R.id.userName);
        setFineID = findViewById(R.id.fineID);
        setFineTotPrice = findViewById(R.id.totalPrice);
        setOffenderName = findViewById(R.id.offenderName);
        setOffenderContact = findViewById(R.id.offenderContact);

        Intent oDetails = getIntent();
        officerName = oDetails.getStringExtra("userName");
        fineID = oDetails.getStringExtra("fineID");
        FineTotPrice = oDetails.getStringExtra("fineTotPrice");
        contact = oDetails.getStringExtra("contact");
        userName = oDetails.getStringExtra("name");

        setUserName.setText("Officer Reg.No : " + officerName);
        setFineID.setText("Fine Number : " + fineID);
        setOffenderName.setText("Offender Name : " + userName);
        setOffenderContact.setText("Offender Mobile : " + contact);
        setFineTotPrice.setText("Total Amount : " + "LKR. " + FineTotPrice);

    }

    protected void onResume() {
        super.onResume();
        confPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://textit.biz/sendmsg/index.php?id=94773638063&pw=5584&to="+contact+"&text=PAYMENT+SUCCESSFUL+\n+OfficerRegNo"+officerName+"+\n+FineID"+fineID+"+\n+Paid+Amount+LKR:"+FineTotPrice+" ";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.setPackage("com.android.chrome");
                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    i.setPackage(null);
                    startActivity(i);
                }

//                Intent intent = new Intent(PayFines.this, RulesList.class);
//                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Paid Success", Toast.LENGTH_LONG).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i=new Intent(PayFines.this,RulesList.class);
                        startActivity(i);
                    }
                }, 4000);

            }
        });

    }

}
