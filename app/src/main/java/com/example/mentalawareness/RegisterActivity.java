package com.example.mentalawareness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Phone;
    private EditText Password;
    private EditText Age;
    private EditText Gender;
    private Button RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setInitialValues();

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel usermodel = null;
                if (validateInputs()) {
                    usermodel = new UserModel(1, Name.getText().toString(), Email.getText().toString(), Age.getText().toString(), Password.getText().toString(), Gender.getText().toString(), Phone.getText().toString());
                    //Toast.makeText(getApplicationContext(), usermodel.toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Some sort of an error", Toast.LENGTH_LONG).show();
                }
                DbHelper dbhelper = new DbHelper(RegisterActivity.this);

                Toast.makeText(RegisterActivity.this,"Success?? =" + dbhelper.addOne(usermodel), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setInitialValues() {
        Name = (EditText) findViewById(R.id.etName);
        Email = (EditText) findViewById(R.id.etEmailAddress);
        Phone = (EditText) findViewById(R.id.etPhone);
        Password = (EditText) findViewById(R.id.etPassword);
        Age = (EditText) findViewById(R.id.etAge);
        Gender = (EditText) findViewById(R.id.etGender);
        RegisterButton = (Button) findViewById(R.id.btnRegister);
    }

    private boolean validateInputs() {
        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String phone = Phone.getText().toString();
        String password = Password.getText().toString();
        String age = Password.getText().toString();
        String gender = Gender.getText().toString();
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || age.isEmpty() || gender.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}