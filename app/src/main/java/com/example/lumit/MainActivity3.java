package com.example.lumit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private EditText detailsNameEdt, detailsUnameEdt,detailsPhoneEdt, detailsAgeEdt, detailsPinEdt,detailsAadharEdt,detailsPwdEdt,detailsMailEdt,detailsCityEdt;
    private Button addCourseBtn;
    private DBHandler dbHandler;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        detailsNameEdt = findViewById(R.id.et1);
        detailsUnameEdt= findViewById(R.id.et7);
        detailsAgeEdt= findViewById(R.id.et2);
        detailsMailEdt= findViewById(R.id.et3);
        detailsCityEdt= findViewById(R.id.et4);
        detailsPhoneEdt=findViewById(R.id.et10);
        detailsPinEdt= findViewById(R.id.et5);
        detailsAadharEdt= findViewById(R.id.et6);
        detailsPwdEdt= findViewById(R.id.et8);
        addCourseBtn = findViewById(R.id.btn4);
        dbHandler=new DBHandler(MainActivity3.this);
        Intent intent = getIntent();
        String str = intent.getStringExtra("num");
        detailsPhoneEdt.setText(str);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String detailsName = detailsNameEdt.getText().toString();
                String detailsAge = detailsAgeEdt.getText().toString();
                String detailsMail = detailsMailEdt.getText().toString();
                String detailsPhone = detailsPhoneEdt.getText().toString();
                String detailsCity = detailsCityEdt.getText().toString();
                String detailsPin = detailsPinEdt.getText().toString();
                String detailsAadhar = detailsAadharEdt.getText().toString();
                String detailsUname = detailsUnameEdt.getText().toString();
                String detailsPwd = detailsPwdEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (detailsName.isEmpty() || detailsPhone.isEmpty() || detailsUname.isEmpty() || detailsAge.isEmpty() || detailsMail.isEmpty() || detailsCity.isEmpty() || detailsPin.isEmpty() || detailsAadhar.isEmpty() || detailsPwd.isEmpty()) {
                    Toast.makeText(MainActivity3.this, "some fields are empty..", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean b = dbHandler.checkDataExistOrNot(detailsUname);
                if (b == true) {
                    Toast.makeText(MainActivity3.this, "username alredy exists", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    dbHandler.addNewCourse(detailsUname, detailsName, detailsAge, detailsPhone, detailsPin, detailsAadhar, detailsPwd, detailsMail, detailsCity);
                    // after adding the data we are displaying a toast message.
                    Toast.makeText(MainActivity3.this, "Details added", Toast.LENGTH_SHORT).show();
                    detailsUnameEdt.setText("");
                    detailsNameEdt.setText("");
                    detailsAgeEdt.setText("");
                    detailsPhoneEdt.setText("");
                    detailsPinEdt.setText("");
                    detailsAadharEdt.setText("");
                    detailsPwdEdt.setText("");
                    detailsMailEdt.setText("");
                    detailsCityEdt.setText("");
                    Intent intent25 = new Intent(MainActivity3.this, MainActivity4.class);
                    startActivity(intent25);
                }
            }
        });
    }
}


