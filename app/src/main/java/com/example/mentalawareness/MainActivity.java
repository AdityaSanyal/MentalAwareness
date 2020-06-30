package com.example.mentalawareness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button LoginButton;
    private Button RegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialValues();


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(Username.getText().toString(), Password.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, ViewAllUsers.class);
                    intent.putExtra("Username", Username.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setInitialValues()
    {
        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etPassword);
        LoginButton = (Button)findViewById(R.id.btnLogin);
        RegisterButton = (Button)findViewById(R.id.btnRegister);
    }
    private boolean validate(String username, String password)
    {
        DbHelper dbHelper = new DbHelper(MainActivity.this);

        if(dbHelper.authenticateUser(username,password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}