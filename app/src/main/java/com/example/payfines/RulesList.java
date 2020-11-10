package com.example.payfines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class RulesList extends AppCompatActivity {

    Button btnNext;
    String userName;
    ArrayList ruleArray = new ArrayList();
    Integer r1=0, r2=0, r3=0, r4=0, r5=0, r6=0, r7=0, r8=0, r9=0, r10=0, r11=0, r12=0, r13=0, r14=0, r15=0, r16=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnNext = findViewById(R.id.btnNext);

        Intent uName = getIntent();
        userName = uName.getStringExtra("userName");

    }

    protected void onResume() {
        super.onResume();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setArray();
                Intent intent = new Intent(RulesList.this, Offender.class);
                intent.putExtra("userName", userName);
                intent.putExtra("ruleArray", ruleArray);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Rules Selected", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.CheckRule_01:
                if (checked) { r1 = 1; } else { r1 = 0; }
                    break;

            case R.id.CheckRule_02:
                if (checked) { r2 = 1; } else { r2 = 0; }
                    break;

            case R.id.CheckRule_03:
                if (checked) { r3 = 1; } else { r3 = 0; }
                    break;

            case R.id.CheckRule_04:
                if (checked) { r4 = 1; } else { r4 = 0; }
                    break;

            case R.id.CheckRule_05:
                if (checked) { r5 = 1; } else { r5 = 0; }
                    break;

            case R.id.CheckRule_06:
                if (checked) { r6 = 1; } else { r6 = 0; }
                    break;

            case R.id.CheckRule_07:
                if (checked) { r7 = 1; } else { r7 = 0; }
                    break;

            case R.id.CheckRule_08:
                if (checked) { r8 = 1; } else { r8 = 0; }
                break;

            case R.id.CheckRule_09:
                if (checked) { r9 = 1; } else { r9 = 0; }
                break;

            case R.id.CheckRule_10:
                if (checked) { r10 = 1; } else { r10 = 0; }
                break;

            case R.id.CheckRule_11:
                if (checked) { r11 = 1; } else { r11 = 0; }
                break;

            case R.id.CheckRule_12:
                if (checked) { r12 = 1; } else { r12 = 0; }
                break;

            case R.id.CheckRule_13:
                if (checked) { r13 = 1; } else { r13 = 0; }
                break;

            case R.id.CheckRule_14:
                if (checked) { r14 = 1; } else { r14 = 0; }
                break;

            case R.id.CheckRule_15:
                if (checked) { r15 = 1; } else { r15 = 0; }
                break;

            case R.id.CheckRule_16:
                if (checked) { r16 = 1; } else { r16 = 0; }
                break;
        }

    }

    public void setArray(){
        if (r1 == 1) { ruleArray.add(1); } else { r1 = 0; }
        if (r2 == 1) { ruleArray.add(2); } else { r2 = 0; }
        if (r3 == 1) { ruleArray.add(3); } else { r3 = 0; }
        if (r4 == 1) { ruleArray.add(4); } else { r4 = 0; }
        if (r5 == 1) { ruleArray.add(5); } else { r5 = 0; }
        if (r6 == 1) { ruleArray.add(6); } else { r6 = 0; }
        if (r7 == 1) { ruleArray.add(7); } else { r7 = 0; }
        if (r8 == 1) { ruleArray.add(8); } else { r8 = 0; }
        if (r9 == 1) { ruleArray.add(9); } else { r9 = 0; }
        if (r10 == 1) { ruleArray.add(10); } else { r10 = 0; }
        if (r11 == 1) { ruleArray.add(11); } else { r11 = 0; }
        if (r12 == 1) { ruleArray.add(12); } else { r12 = 0; }
        if (r13 == 1) { ruleArray.add(13); } else { r13 = 0; }
        if (r14 == 1) { ruleArray.add(14); } else { r14 = 0; }
        if (r15 == 1) { ruleArray.add(15); } else { r15 = 0; }
        if (r16 == 1) { ruleArray.add(16); } else { r16 = 0; }
    }

}
