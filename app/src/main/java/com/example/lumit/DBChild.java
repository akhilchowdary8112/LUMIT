package com.example.lumit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBChild extends SQLiteOpenHelper {
    private static final String DB_NAME = "new_db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "child";

    // below variable is for our id column.
    private static final String NAME_COL = "name";

    // below variable is for our course name column
    private static final String AGE_COL = "age";

    // below variable id for our course duration column.
    private static final String GENDER_COL = "gender";

    // below variable for our course description column.
    private static final String LOC_COL = "location";

    // below variable is for our course tracks column.
    private static final String PARENT_COL = "parents";

    // creating a constructor for our database handler.
    public DBChild(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + NAME_COL + " TEXT, "
                + AGE_COL + " INTEGER,"
                + GENDER_COL + " TEXT,"
                + LOC_COL + " TEXT,"
                + PARENT_COL + " TEXT)";

        db.execSQL(query);
    }
    public int total(String age){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from child where age=? and parents=?",new String[]{age,"noo"});
        int count = c.getCount();
        db.close();
        return count;
    }
    public void addNewCourse(String cname, String cage, String cgender, String cloc,String pstatus) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, cname);
        values.put(AGE_COL, cage);
        values.put(GENDER_COL, cgender);
        values.put(LOC_COL, cloc);
        values.put(PARENT_COL,pstatus);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Cursor getChild(String age){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select name,age,gender from child where age=? and parents=?",new String[]{age,"noo"});
        if (cursor!=null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

