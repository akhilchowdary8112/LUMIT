package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity22 extends AppCompatActivity {
EditText et101,et102;
RadioGroup rg101;
RadioButton select;
String parent,location;
    private DBChild dbChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        et101=findViewById(R.id.et20);
        et102=findViewById(R.id.et21);
        rg101=findViewById(R.id.rgroup);
        dbChild=new DBChild(this);
        findViewById(R.id.btn73).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et101.getText().toString();
                String age=et102.getText().toString();
                int selectedId = rg101.getCheckedRadioButtonId();
                select = (RadioButton) findViewById(selectedId);
                String gender=select.getText().toString();
                location="org";
                parent="noo";
                if (name.isEmpty() || age.isEmpty() ) {
                    Toast.makeText(MainActivity22.this, "some fields are empty..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    dbChild.addNewCourse(name,age,gender,location,parent);
                    Toast.makeText(MainActivity22.this, "details added..", Toast.LENGTH_SHORT).show();
                    et101.setText("");
                    et102.setText("");
                }
            }
        });
        findViewById(R.id.btn74).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}
