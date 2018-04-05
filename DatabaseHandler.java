package com.example.nandhu.sqldata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.ViewAnimationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 07/02/2018.
 * Class for handling database operations
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static String DATABASE_NAME     = "database_manager";
    private static int DATABASE_VERSION     = 1;
    private String TABLE_USER       = "user";

    /**
     * Constructor
     * @param context context
     */
    DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * onCreate method
     * creating table with necessary data
     * @param database instance of database
     */
    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_USER_TABLE = "CREATE TABLE "+TABLE_USER+"(name TEXT)";
        database.execSQL(CREATE_USER_TABLE);
    }

    /**
     *
     * @param database database
     * @param oldVersion old version number
     * @param newVersion new version number
     */
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXIST "+TABLE_USER);
        onCreate(database);
    }
    List<String> selectall(){
            List<String> contactList = new ArrayList<String>();
            // Select All Query
            String selectQuery = "SELECT * FROM "+TABLE_USER;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    contactList.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }

            // return contact list
            return contactList;
    }
    void insertnamedata(String name){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values    = new ContentValues();
        values.put("name", name);
        database.insert(TABLE_USER, null, values);
        database.close();
    }

    void deletenamedata(String name){
       SQLiteDatabase db=this.getReadableDatabase();
        db.delete(TABLE_USER,"name='"+name+"'",null);
        db.close();
    }

    void updatenamedata(String name,String updatename){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",updatename);
        db.update(TABLE_USER,values,"name='"+name+"'",null);
        //db.update(TABLE_USER, values, "name = ?",new String[] { name });
        db.close();
    }

}
