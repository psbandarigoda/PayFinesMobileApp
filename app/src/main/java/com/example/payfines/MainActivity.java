package com.example.payfines;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    private static final String TAG = "MyActivity";
    EditText Username, Password;
    Button Login;
    DatabaseReference dbRef2;
//    String dbUserName, dbPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.btnLogin);
        Username = findViewById(R.id.TextUsername);
        Password = findViewById(R.id.TextPassword);

//        dbRef = FirebaseDatabase.getInstance().getReference().child("Officers").child("24948");
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.hasChildren()) {
//                    System.out.println("has Children");
//                    dbUserName = dataSnapshot.child("regNo").getValue().toString();
//                    dbPassword = dataSnapshot.child("password").getValue().toString();
//                    Password.setText(dataSnapshot.child("password").getValue().toString());
//                    if(Username.equals(dbUserName)   && Password.equals(dbPassword)){
//                        login = true;
//                    }else{
//                        login = false;
//                    }

//                    Log.i(TAG, "get user" + dbUserName);
//                    Log.i(TAG, "get pw" + Password);
//                    System.out.println("has Children" + dbUserName);
//                    System.out.println("has Children" + dbPassword);
//
//                } else {
//                    System.out.println("no Children");
//                    Toast.makeText(getApplicationContext(), "invalide Error", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//        });
//
    }


    protected void onResume() {
        super.onResume();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef2 = FirebaseDatabase.getInstance().getReference().child("Officers");
                dbRef2.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            Map<String,Object>  officerDetails = (Map<String, Object>) dataSnapshot.getValue();
                            Map<String,Object>  officer = (Map<String, Object>) officerDetails.get(Username.getText().toString());
                            if(officer != null){
                                String officerPass = officer.get("password").toString();

                                if(officerPass.equals(Password.getText().toString())){
//                                    System.out.println("uuuuuuuuu"+Username);
//                                    System.out.println("uuuuuuuuu"+Password);
//                                    System.out.println("uuuuuuuuu"+officerPass);
                                    goToNextPage();
                                }else{
//                                    System.out.println("ffffffff"+Username);
//                                    System.out.println("ffffffff"+Password);
//                                    System.out.println("ffffffff"+officerPass);
                                    Toast.makeText(getApplicationContext(), "Login Password Error", Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Login User Error", Toast.LENGTH_LONG).show();
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }


    public void goToNextPage(){
            Intent intent = new Intent(MainActivity.this, RulesList.class);
            intent.putExtra("userName", Username.getText().toString());
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
    }
}
