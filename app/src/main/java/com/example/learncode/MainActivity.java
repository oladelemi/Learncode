package com.example.learncode;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    EditText textUsername;
    EditText textPassword;
    Button buttonLogin;
    TextView textViewRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        textUsername = (EditText)findViewById(R.id.text_username);
        textPassword = (EditText)findViewById(R.id.text_password);
        buttonLogin = (Button)findViewById(R.id.button_login);
        textViewRegister = (TextView)findViewById(R.id.text_register);
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                public void onClick(View v) {
                    String user = textUsername.getText().toString().trim();
                    String pwd = textPassword.getText().toString().trim();
                    Boolean res = db.checkUser(user,pwd);
                    if (res == true)
                    {
                        Intent homeactivity = new Intent(MainActivity.this,Introduction.class);
                        startActivity(homeactivity);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "login Error", Toast. LENGTH_SHORT).show();
                        MediaPlayer login = MediaPlayer.create(null, R.raw.login);
                        login.start();

                    }
                }
            });



    }
}
