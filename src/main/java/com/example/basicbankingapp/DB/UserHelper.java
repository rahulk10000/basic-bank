package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Rahul Kushwaha', 'rk123@gmail.com','ABC123','7895644548', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Neha Verma', 'neha67@gmail.com','BCC1258','8079641238', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Rashika Gupta', 'rashi0@gmail.com','DEF8896','7595645896', 19000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Ritika Bharadwaj', 'ritika0@gmail.com','DDC7752','9995640038', 18000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Pranjal Singh', 'pp123@gmail.com','AQW3669','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Ankur Rai', 'ak8@gmail.com','9985','POP8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Saumaya Kashyap', 'saumya76@gmail.com','BVV1207','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Ritik Singh', 'ritik9@gmail.com','YUI4522','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Anshita Maurya', 'akk90@gmail.com','IOI6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Urvashi Verma', 'uv090@gmail.com','POI5450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Shalini Ahuja', 'ss33@gmail.com','BOI2656','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Ritesh Rai', 'ritesh9@gmail.com','BVB1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Hemant Yadav', 'hem56@gmail.com','BBT5566','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Prakash Singh', 'prak0@gmail.com','GGH2236','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Zeenat Firdoz', 'zf9@gmail.com','TGT6692','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}