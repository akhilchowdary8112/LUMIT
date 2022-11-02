package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity20 extends AppCompatActivity {
private DBOrg dbOrg;
EditText et00,et01,et02,et03,et04,et05;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);
        et00=findViewById(R.id.et51);
        et01=findViewById(R.id.et52);
        et02=findViewById(R.id.et53);
        et03=findViewById(R.id.et54);
        et04=findViewById(R.id.et55);
        et05=findViewById(R.id.et56);
        dbOrg=new DBOrg(this);
        findViewById(R.id.btn65).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ogname=et00.getText().toString();
                String orname=et01.getText().toString();
                String city=et02.getText().toString();
                String ctc=et03.getText().toString();
                String pwd=et04.getText().toString();
                String cpwd=et05.getText().toString();
                if (ogname.isEmpty() || orname.isEmpty() || city.isEmpty() || ctc.isEmpty() || pwd.isEmpty() || cpwd.isEmpty()) {
                    Toast.makeText(MainActivity20.this, "some fields are empty..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                        dbOrg.addNewCourse(ogname, orname, city, ctc, pwd);
                    Toast.makeText(MainActivity20.this, "registered successfully", Toast.LENGTH_SHORT).show();
                    Intent intent01 = new Intent(MainActivity20.this, MainActivity19.class);
                        startActivity(intent01);
                }
            }
        });
    }
}
