package com.example.mentalawareness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final String databaseName = "MentalAwarenessDatabase.db";
    public static final String TABLENAME = "USERINFO";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";
    public static final String PHONE = "PHONE";
    public static final String PASSWORD = "PASSWORD";
    public static final String GENDER = "GENDER";
    public static final String AGE = "AGE";

    public DbHelper(Context context) {
        super(context, databaseName, null, 1);
    }

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + TABLENAME + "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME +
                " TEXT, " + EMAIL + " TEXT, " + PHONE + " TEXT, " + PASSWORD + " TEXT, " + AGE + " TEXT, " + GENDER + " TEXT)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(UserModel usermodel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, usermodel.getName());
        contentValues.put(EMAIL, usermodel.getEmail());
        contentValues.put(PHONE, usermodel.getPhone());
        contentValues.put(PASSWORD, usermodel.getPassword());
        contentValues.put(AGE, usermodel.getAge());
        contentValues.put(GENDER, usermodel.getGender());

        long insert = db.insert(TABLENAME, null, contentValues);
        if (insert == -1) {
            return false;
        } else {
            return true;

        }

    }
//    public List<UserModel> getAllUsers()
//    {
//        List<UserModel> allUsers = new ArrayList<UserModel>();
//
//        String queryString = "SELECT * FROM " + TABLENAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(queryString, null);
//        if(cursor.moveToFirst()){
//            do{
//                int id = cursor.getInt(0);
//                String name = cursor.getString(1);
//                String email = cursor.getString(2);
//                String phone = cursor.getString(3);
//                String password = cursor.getString(4);
//                String age = cursor.getString(5);
//                String gender = cursor.getString(6);
//                UserModel usermodel = new UserModel(id,name,email,age,password,gender,phone);
//                allUsers.add(usermodel);
//            }while(cursor.moveToFirst());
//        }
//        else{
//
//        }
//        cursor.close();
//        db.close();
//        return allUsers;
//    }
    public boolean authenticateUser(String username, String password)
    {
        String queryString = "SELECT * FROM " + TABLENAME + " WHERE EMAIL = '" + username + "' AND  PASSWORD = '" + password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(queryString, null);
        boolean flag;
        if(c.moveToFirst())
        {
            flag = true;
        }
        else
        {
            flag = false;
        }
        c.close();
        db.close();
        return flag;
    }
}
