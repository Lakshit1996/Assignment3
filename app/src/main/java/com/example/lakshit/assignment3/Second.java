package com.example.lakshit.assignment3;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Second extends AppCompatActivity {

    EditText review;
    private static Button button,button_int,button_pvtext,button_pubtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        review=(EditText)findViewById(R.id.comment);

        button=(Button)findViewById(R.id.button);
        button_pvtext=(Button)findViewById(R.id.button_pvtext);
        button_pubtext=(Button)findViewById(R.id.button_pubext);
        button_int=(Button)findViewById(R.id.button_int);

        button_int.setEnabled(false);
        button.setEnabled(true);
        button_pvtext.setEnabled(false);
        button_pubtext.setEnabled(false);

    }

    public void int_file(View view) {

        String input=review.getText().toString();
        FileOutputStream file=null;

        try {
            File f=getFilesDir();
            file=openFileOutput("Assgn3.txt",MODE_PRIVATE);
            file.write(input.getBytes());
            button_int.setEnabled(false);
            Toast.makeText(Second.this,"Text saved in internal file." + f,Toast.LENGTH_SHORT).show();
            review.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(file!=null)
                {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        button_int.setEnabled(true);
        button_pvtext.setEnabled(false);
        button_pubtext.setEnabled(false);

    }

    public void pvtext_file(View view) {
        String input=review.getText().toString();
        File folder=getExternalFilesDir("Tyagi");
        File file=new File(folder,"Assgn3_2.txt");

        FileOutputStream fileOutputStream=null;

        try {
            fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(input.getBytes());
            button_pvtext.setEnabled(false);
            Toast.makeText(Second.this,"Text saved in private external file." + file.getAbsolutePath(),Toast.LENGTH_SHORT).show();
            review.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(fileOutputStream!=null)
                {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        button_int.setEnabled(false);
        button_pvtext.setEnabled(true);
        button_pubtext.setEnabled(false);


    }

    public void pubext_file(View view) {
        String input=review.getText().toString();
        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file=new File(folder,"Assgn3_3.txt");

        FileOutputStream fileOutputStream=null;

        try {
            fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(input.getBytes());
            button_pubtext.setEnabled(false);
            Toast.makeText(Second.this,"Text saved in public external file." + file.getAbsolutePath(),Toast.LENGTH_SHORT).show();
            review.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(fileOutputStream!=null)
                {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        button_int.setEnabled(false);
        button_pvtext.setEnabled(false);
        button_pubtext.setEnabled(true);
    }

    public void announcement(View v)
    {
        FileInputStream file=null;

        try {
            file=openFileInput("Assgn3.txt");
            InputStreamReader ipstream=new InputStreamReader(file);
            BufferedReader bf=new BufferedReader(ipstream);
            StringBuffer string=new StringBuffer();
            String lines;
            while((lines=bf.readLine())!=null)
            {
                string.append(lines+"\n");
            }

            AlertDialog.Builder dialog=new AlertDialog.Builder(this);
            dialog.setMessage(string.toString());
            dialog.setTitle("Announcements");
            dialog.setCancelable(true);
            dialog.show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(file!=null)
                {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void rb_ann(View V)
    {
        button_int.setEnabled(true);
        button_pvtext.setEnabled(false);
        button_pubtext.setEnabled(false);
    }
    public void rb_dis(View V)
    {
        button_pvtext.setEnabled(true);
        button_int.setEnabled(false);
        button_pubtext.setEnabled(false);
    }
    public void rb_des(View V)
    {
        button_pubtext.setEnabled(true);
        button_int.setEnabled(false);
        button_pvtext.setEnabled(false);
    }


}
