package com.example.lumit;

import static android.content.Intent.ACTION_PICK;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class MainActivity7 extends AppCompatActivity {
    EditText edtName,edtAge,edtLoc;
    RadioGroup rgroup;
    Button y,n;
    RadioButton selected;
    String cparent;
    AlertDialog.Builder builder;
    private DBChild dbChild;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        y = (Button) findViewById(R.id.btn14);
        edtName=findViewById(R.id.et20);
        edtAge=findViewById(R.id.et21);
        edtLoc=findViewById(R.id.et29);
        rgroup=findViewById(R.id.rg);
        dbChild=new DBChild(this);
        builder = new AlertDialog.Builder(this);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtName.getText().toString();
                String age=edtAge.getText().toString();
                String loc=edtLoc.getText().toString();
                int selectedId = rgroup.getCheckedRadioButtonId();
                selected = (RadioButton) findViewById(selectedId);
                String gender=selected.getText().toString();
                cparent="yes";
                edtName.setText("");
                edtAge.setText("");
                edtLoc.setText("");
                if (name.isEmpty() || age.isEmpty() || loc.isEmpty()) {
                    Toast.makeText(MainActivity7.this, "some fields are empty..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbChild.addNewCourse(name,age,gender,loc,cparent);

                    //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
                    builder.setMessage("Thank You for feeling responsible.\nWe will take care.")
                            .setCancelable(false)
                            .setTitle("LUMIT says")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Selected:OK",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("LUMIT says");
                    alert.show();
                }
        });
        n= (Button) findViewById(R.id.btn15);
        builder = new AlertDialog.Builder(this);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtName.getText().toString();
                String age=edtAge.getText().toString();
                String loc=edtLoc.getText().toString();
                int selectedId = rgroup.getCheckedRadioButtonId();
                selected = (RadioButton) findViewById(selectedId);
                String gender=selected.getText().toString();
                cparent="noo";
                edtName.setText("");
                edtAge.setText("");
                edtLoc.setText("");
                if (name.isEmpty() || age.isEmpty() || loc.isEmpty()) {
                    Toast.makeText(MainActivity7.this, "some fields are empty..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbChild.addNewCourse(name,age,gender,loc,cparent);
                    //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);
                    builder.setMessage("Thank You for feeling responsible.\nWe will take care.")
                            .setCancelable(false)
                            .setTitle("LUMIT says")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Selected:OK",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("LUMIT says");
                    alert.show();
                }
        });
    }
}

