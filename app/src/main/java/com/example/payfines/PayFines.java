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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.payfines.model.FinesDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class PayFines extends AppCompatActivity {

    public static final String ACCOUNT_SID =
            "AC4be62a0cef44e943564b3b68be0a3aa1";
    public static final String AUTH_TOKEN =
            "your_auth_token";

    Button confPay;
    String userName, officerName, fineID, FineTotPrice, contact;
    String message = "payment success";
    TextView setUserName, setFineID, setFineTotPrice, setOffenderName, setOffenderContact;
    DatabaseReference dbRef;
    FinesDetails fineObj = new FinesDetails();
    ArrayList<String> ruleArray_list = new ArrayList<String>();
    Date dateTime;


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

                updatePaymentStatus();

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

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i=new Intent(PayFines.this,RulesList.class);
                        startActivity(i);
                    }
                }, 3000);

                Toast.makeText(getApplicationContext(), "Paid Success", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void updatePaymentStatus(){

//        FirebaseDatabase.getInstance().getReference().child("Fines").child(fineID).child("status").setValue(status);


        String status = "paid";

        dbRef = FirebaseDatabase.getInstance().getReference().child("Fines");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Map<String,Object> fineDetails = (Map<String, Object>) dataSnapshot.getValue();
                Map<String,Object>  fine = (Map<String, Object>) fineDetails.get(fineID);
                if(fine != null){
//                    String officerPass = fine.get("status").toString();
                    ruleArray_list = (ArrayList<String>) fine.get("rule");

                    fineObj.setDl(fine.get("status").toString());
                    fineObj.setName(fine.get("status").toString());
                    fineObj.setEmail(fine.get("status").toString());
                    fineObj.setContact(fine.get("status").toString());
                    fineObj.setAddress(fine.get("status").toString());
                    fineObj.setLocation(fine.get("status").toString());
                    fineObj.setOfficerId(fine.get("status").toString());
                    fineObj.setTotal(Integer.parseInt(fine.get("status").toString()));
                    fineObj.setStatus(fine.get("status").toString());
                    fineObj.setRule(ruleArray_list);
                    fineObj.setStatus("paid");

                    dbRef.child(fineID).setValue(fineObj);


                }else{
                    Toast.makeText(getApplicationContext(), "Fine status Error", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

      });


    }


}
