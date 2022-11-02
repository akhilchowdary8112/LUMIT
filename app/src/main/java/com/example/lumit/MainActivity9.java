package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity9 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String item;
    DatePicker dp;
    int day,month,Year;
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected:" + item, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        dp=(DatePicker)findViewById(R.id.dp1);
        Spinner spin = (Spinner) findViewById(R.id.spinner3);
        spin.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Morning");
        categories.add("After Noon");
        categories.add("Evening");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);
        dp.init(
                dp.getYear(), dp.getMonth(), dp.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        Year = year;
                        month = monthOfYear+1;
                        day = dayOfMonth;
                    }
                });
        findViewById(R.id.btn11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date=day+"/"+month+"/"+Year+" on "+item+" session." ;
                Intent intent15=new Intent(MainActivity9.this,MainActivity13.class);
                intent15.putExtra("message_key", date);
                startActivity(intent15);
            }
        });
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

