package com.example.lumit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class DBHandler extends SQLiteOpenHelper {
        private static final String DB_NAME = "details";

        // below int is our database version
        private static final int DB_VERSION = 1;

        // below variable is for our table name.
        private static final String TABLE_NAME = "register";

        // below variable is for our id column.
        private static final String UNAME_COL = "user";

        // below variable is for our course name column
        private static final String NAME_COL = "name";

        // below variable id for our course duration column.
        private static final String AGE_COL = "age";

        private static final String PHONE_COL = "phone";

        // below variable for our course description column.
        private static final String MAIL_ID = "mail";

        private static final String PIN_CODE = "pin";

        private static final String AADHAR_COL = "aadhar";

        private static final String PASSWORD_COL = "pwd";

        // below variable is for our course tracks column.
        private static final String CITY_COL = "city";

        public DBHandler(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " ("
                    + UNAME_COL + " TEXT UNIQUE,"
                    + NAME_COL + " TEXT,"
                    + AGE_COL + " INTEGER,"
                    + PHONE_COL + " INTEGER,"
                    + PIN_CODE + " INTEGER,"
                    + AADHAR_COL + " INTEGER,"
                    + PASSWORD_COL + " INTEGER,"
                    + MAIL_ID + " TEXT,"
                    + CITY_COL + " TEXT)";
            db.execSQL(query);
        }
        public void addNewCourse(String detailsUname, String detailsName, String detailsAge,String detailsPhone, String detailsPin,String detailsAadhar,String detailsPwd,String detailsMail,String detailsCity) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(UNAME_COL, detailsUname);
            values.put(NAME_COL, detailsName);
            values.put(AGE_COL,detailsAge);
            values.put(PHONE_COL, detailsPhone);
            values.put(PIN_CODE, detailsPin);
            values.put(AADHAR_COL, detailsAadhar);
            values.put(PASSWORD_COL, detailsPwd);
            values.put(MAIL_ID, detailsMail);
            values.put(CITY_COL, detailsCity);
            db.insert(TABLE_NAME, null, values);
            db.close();
        }

        public boolean checkDataExistOrNot(String value){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("Select * from register where user = ?", new String[]{value});
            if (cursor.getCount() <= 0) {
                cursor.close();
                return false;  // return false if value not exists in database
            }
            cursor.close();
            return true;  // return true if value exists in database
        }
        public Boolean checkuser(String username, String password){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("Select * from register where user = ? and pwd = ?", new String[] {username,password});
            if(cursor.getCount()>0)
                return true;
            else
                return false;
        }
        public Boolean deleteuser(String username){
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete(TABLE_NAME, "user=?", new String[]{username}) > 0;
        }
        public Cursor getDetails(String uname){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("Select name,age,phone,pin,aadhar,mail,city from register where user = ?", new String[] {uname});
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
