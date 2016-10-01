package com.example.lakshit.assignment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String dbname="Mc.db";
    public static final String tablename="Student";
    public static final String col1="Roll_no";
    public static final String col2="Name";
    public static final String col3="Assgn_marks";
    public static final String col4="Midsem_marks";
    public static final String col5="Project_name";


    public Database(Context context) {
        super(context,dbname,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        try {
          db.execSQL("create table " +tablename+" (Roll_no INTEGER PRIMARY KEY,Name TEXT,Assgn_marks INTEGER,Midsem_marks INTEGER,Project_name TEXT)");
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS"+tablename);
        onCreate(db);
    }

    public Cursor view()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from "+tablename,null);
        return result;
    }

    public Integer insert(String roll,String name,String assgn,String mid,String proj)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,roll);
        contentValues.put(col2,name);
        contentValues.put(col3,assgn);
        contentValues.put(col4,mid);
        contentValues.put(col5,proj);
        long result=db.insert(tablename,null,contentValues);
        if(result==1)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public Integer del(String roll)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(tablename,"Roll_no=?",new String[]{roll});
    }



    public Integer update(String roll,String name,String assgn,String mid,String proj)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,roll);
        contentValues.put(col2,name);
        contentValues.put(col3,assgn);
        contentValues.put(col4,mid);
        contentValues.put(col5,proj);
        db.update(tablename,contentValues,"Roll_no=?",new String[]{roll});
        return 1;
    }
}
