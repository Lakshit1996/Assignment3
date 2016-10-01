package com.example.lakshit.assignment3;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class First extends AppCompatActivity {

    Database mydb;
    EditText roll,name,assgn,mid,proj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mydb=new Database(this);

        roll=(EditText)findViewById(R.id.text_roll);
        name=(EditText)findViewById(R.id.text_name);
        assgn=(EditText)findViewById(R.id.text_assgn);
        mid=(EditText)findViewById(R.id.text_mid);
        proj=(EditText)findViewById(R.id.text_proj);


    }

    public void update(View v)
    {
        Integer result=mydb.update(roll.getText().toString(),name.getText().toString(),assgn.getText().toString(),mid.getText().toString(),proj.getText().toString());
        if(result!=1)
        {
            roll.setText("");
            name.setText("");
            mid.setText("");
            assgn.setText("");
            proj.setText("");
            Toast.makeText(First.this," Data Updation failed!!",Toast.LENGTH_SHORT).show();
        }
        else {
            roll.setText("");
            name.setText("");
            mid.setText("");
            assgn.setText("");
            proj.setText("");
            Toast.makeText(First.this, " Data has been updated.", Toast.LENGTH_SHORT).show();
        }
    }

    public void add(View v)
    {
        Integer result=mydb.insert(roll.getText().toString(),name.getText().toString(),assgn.getText().toString(),mid.getText().toString(),proj.getText().toString());
        if(result==0)
        {
            roll.setText("");
            name.setText("");
            mid.setText("");
            assgn.setText("");
            proj.setText("");
            Toast.makeText(First.this," Data Insertion failed!!",Toast.LENGTH_SHORT).show();
        }
        else {
            roll.setText("");
            name.setText("");
            mid.setText("");
            assgn.setText("");
            proj.setText("");
            Toast.makeText(First.this, " Data has been inserted.", Toast.LENGTH_SHORT).show();
        }

    }

    public void show(View v)
    {
        Cursor result=mydb.view();
        if(result.getCount()>0)
        {
            StringBuffer buf=new StringBuffer();
            while(result.moveToNext())
            {
                buf.append("\nRoll No: "+result.getString(0));
                buf.append("\nName: "+result.getString(1));
                buf.append("\nAssgn Marks: "+result.getString(2));
                buf.append("\nMidsem Marks: "+result.getString(3));
                buf.append("\nProject Title: "+result.getString(4)+"\n");
            }
            AlertDialog.Builder dialog=new AlertDialog.Builder(this);
            dialog.setMessage(buf.toString());
            dialog.setTitle("Students in MC");
            dialog.setCancelable(true);
            dialog.show();
        }
        else
        {
            Toast.makeText(First.this, "Table is empty.", Toast.LENGTH_SHORT).show();
        }
    }

    public void del(View v)
    {
        Integer result=mydb.del(roll.getText().toString());
        if(result>0)
        {
            Toast.makeText(First.this, "Deleted Data", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(First.this, "Can't delete data.", Toast.LENGTH_SHORT).show();

        roll.setText("");
        name.setText("");
        mid.setText("");
        assgn.setText("");
        proj.setText("");
    }

}
