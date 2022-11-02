package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity10 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        Spinner spin1= (Spinner) findViewById(R.id.spinner4);
        spin1.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Desire Society(Kukatpally)");
        categories.add("Aadarana(Hyderabad)");
        categories.add("Aarthi(RAJAHMUNDRY )");
        categories.add("Aasha Jyothi Welfare Association For Disabled");
        categories.add("Aasritham(MAHABUBNAGAR)");
        categories.add("Abhaya Foundation(KHAIRATHABAD)");
        categories.add("Abhivrudhi Mahila Sangam(MACHILIPATNAM)");
        categories.add("Actionfor Child(Hyderabad)");
        categories.add("Acts Ngo(Hyderabad)");
        categories.add("Agnus Ganja Bojexio Social Service Society(Narasaraopet )");
        categories.add("A G R A(ANANTAPUR )");
        categories.add("Akshara Educational And Welfare Society(Gopalapatnam)");
        categories.add("Amar Society(Kurnool)");
        ArrayAdapter<String> dataAdapter2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(dataAdapter2);
        Spinner spin = (Spinner) findViewById(R.id.spinner5);
        spin.setOnItemSelectedListener(this);
        List<String> categories1= new ArrayList<String>();
        categories1.add("Contact Management");
        categories1.add("Visit Orphanage");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);
        findViewById(R.id.btn42).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:6301021636"));

                if (ActivityCompat.checkSelfPermission(MainActivity10.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected:" + item, Toast.LENGTH_SHORT).show();
        if(item=="Visit Orphanage"){
            finish();
            Toast.makeText(parent.getContext(), "Please visit the orphanage", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

