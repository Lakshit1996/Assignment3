package com.example.lakshit.assignment3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    EditText user,pass;
    private static Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user=(EditText)findViewById(R.id.user_login);
        pass=(EditText)findViewById(R.id.pass_login);

    }

    public void logging(View view)
    {
        SharedPreferences sp=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name=sp.getString("name","");
        String password=sp.getString("password","");

        String input_user=user.getText().toString();
        String input_pass=pass.getText().toString();

        if(input_user.equals(name)&& input_pass.equals(password))
        {
            Toast.makeText(Login.this," You have logged in successfully",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,Home.class);
            startActivity(intent);
        }
        else
        {
            user.setText("");
            pass.setText("");
            Toast.makeText(Login.this,"Incorrect Credentials",Toast.LENGTH_SHORT).show();
        }


    }

}
