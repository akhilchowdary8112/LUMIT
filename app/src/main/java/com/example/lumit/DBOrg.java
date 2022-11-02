package com.example.lumit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOrg extends SQLiteOpenHelper {
    private static final String DB_NAME = "org_db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "org";

    private static final String ON_COL = "orgn";

    private static final String OR_COL = "orgr";

    private static final String CITY_COL = "city";

    private static final String CONTACT_COL = "cn";

    private static final String PASSWORD_COL = "pwd";

    public DBOrg(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ON_COL + " TEXT, "
                + OR_COL + " TEXT,"
                + CITY_COL + " TEXT,"
                + CONTACT_COL + " INTEGER,"
                + PASSWORD_COL + " INTEGER)";

        db.execSQL(query);
    }
    public void addNewCourse(String ogname, String orname, String city,String num,String pswd) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ON_COL, ogname);
        values.put(OR_COL, orname);
        values.put(CITY_COL, city);
        values.put(CONTACT_COL, num);
        values.put(PASSWORD_COL,pswd);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Boolean checkuser(String contact, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from org where cn = ? and pwd = ?", new String[] {contact,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

