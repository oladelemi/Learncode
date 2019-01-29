package com.example.learncode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText textUsername;
    EditText textPassword;
    EditText textCnfPassword;
    Button buttonRegister;
    TextView textViewLogin;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        textUsername = (EditText) findViewById(R.id.text_username);
        textPassword = (EditText) findViewById(R.id.text_password);
        textCnfPassword = (EditText) findViewById(R.id.text_cnf_password);
        buttonRegister = (Button) findViewById(R.id.button_register);
        textViewLogin = (TextView) findViewById(R.id.text_login);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(LoginIntent);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = textUsername.getText().toString().trim();
                String pwd = textPassword.getText().toString().trim();
                String cnf_pwd = textCnfPassword.getText().toString().trim();

                if (pwd.equals(cnf_pwd)) {
                   long val =  db.addUser(user,pwd);
                   if (val > 0 ){

                       Toast.makeText(RegisterActivity.this, "Account Registered ", Toast.LENGTH_SHORT).show();
                       Intent moveToLogin = new Intent(RegisterActivity.this,MainActivity.class);
                       startActivity(moveToLogin);
                   }else{

                       Toast.makeText(RegisterActivity.this, "Registration error", Toast.LENGTH_SHORT).show();

                   }

                }
                else {
                    Toast.makeText(RegisterActivity.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
