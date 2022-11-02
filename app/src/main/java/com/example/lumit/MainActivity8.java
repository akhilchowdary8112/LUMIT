package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity8 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("1");
        categories.add("2");
        categories.add("3");
        categories.add("4");
        categories.add("5");
        categories.add("6");
        categories.add("7");
        categories.add("8");
        categories.add("9");
        categories.add("10");
        categories.add("11");
        categories.add("12");
        categories.add("13");
        categories.add("14");
        categories.add("15");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);
        Spinner spin2= (Spinner) findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(this);
        List<String> categories2= new ArrayList<String>();
        categories2.add("Andhra Pradesh");
        categories2.add("Arunachal Pradesh");
        categories2.add("Assam");
        categories2.add("Bihar");
        categories2.add("Chhattisgarh");
        categories2.add("Goa");
        categories2.add("Gujarat");
        categories2.add("Haryana");
        categories2.add("Himachal Pradesh");
        categories2.add("Jammu And Kashmir");
        categories2.add("Jharkhand");
        categories2.add("Karnataka");
        categories2.add("Kerala");
        categories2.add("Madhya Pradesh");
        categories2.add("Maharastra");
        categories2.add("Manipur");
        categories2.add("Meghalaya");
        categories2.add("Mizoram");
        categories2.add("Nagaland");
        categories2.add("Odisha");
        categories2.add("Punjab");
        categories2.add("Rajasthan");
        categories2.add("Sikkim");
        categories2.add("Tamil Nadu");
        categories2.add("Telangana");
        categories2.add("Tripura");
        categories2.add("Uttarakhand");
        categories2.add("Uttar Pradesh");
        categories2.add("West Bengal");
        ArrayAdapter<String> dataAdapter2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(dataAdapter2);
        findViewById(R.id.btn30).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = spin.getSelectedItem().toString();
                Intent intent30=new Intent(MainActivity8.this,MainActivity17.class);
                intent30.putExtra("key_age",text);
                startActivity(intent30);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        if(item=="Andhra Pradesh"){
            Spinner spin3= (Spinner) findViewById(R.id.spinner3);
            spin3.setOnItemSelectedListener(this);
            List<String> categories = new ArrayList<String>();
            categories.add("Anantpur");
            categories.add("Chittoor");
            categories.add("East Godavari");
            categories.add("Guntur");
            categories.add("Kadapa");
            categories.add("Krishna");
            categories.add("Kurnool");
            categories.add("Nellore");
            categories.add("Prakasam");
            categories.add("Srikakulam");
            categories.add("Visakhapatnam");
            categories.add("Vizianagaram");
            categories.add("West Godavari");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin3.setAdapter(dataAdapter);
        }
        if(item=="Arunachal Pradesh"){
            Spinner spin4= (Spinner) findViewById(R.id.spinner3);
            spin4.setOnItemSelectedListener(this);
            List<String> categories = new ArrayList<String>();
            categories.add("Anjaw");
            categories.add("Changlang");
            categories.add("East Siang");
            categories.add("East Kameng");
            categories.add("Kurung Kumey");
            categories.add("Papum Pare");
            categories.add("Lower Subansiri");
            categories.add("Lohit");
            categories.add("Lower Dibang");
            categories.add("Tirap");
            categories.add("Upper Dibang");
            categories.add("West Siang");
            categories.add("Upper Siang");
            categories.add("Tawang");
            categories.add("West Kameng");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin4.setAdapter(dataAdapter);
        }
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

