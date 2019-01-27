package com.example.learncode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText textUsername;
    EditText textPassword;
    Button buttonLogin;
    TextView textViewRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
