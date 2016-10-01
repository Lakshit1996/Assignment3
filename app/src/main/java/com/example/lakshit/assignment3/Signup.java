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

public class Signup extends AppCompatActivity {


    EditText user,pass;
    private static Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user=(EditText)findViewById(R.id.user_signup);
        pass=(EditText)findViewById(R.id.pass_signup);


    }

    public void save(View view)
    {
        SharedPreferences sp=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("name",user.getText().toString());
        editor.putString("password",pass.getText().toString());
        editor.commit();

        Toast.makeText(Signup.this," You have registered",Toast.LENGTH_SHORT).show();
        user.setText("");
        pass.setText("");
//        Intent intent=new Intent(this,Signup.class);
//        startActivity(intent);
    }

}
