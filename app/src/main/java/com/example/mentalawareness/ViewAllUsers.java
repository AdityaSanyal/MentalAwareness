package com.example.mentalawareness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewAllUsers extends AppCompatActivity {
    private TextView textView;
    private Button logoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_users);

        String username = getIntent().getStringExtra("Username");
        textView = (TextView)findViewById(R.id.tvShowText);
        logoutButton = (Button)findViewById(R.id.btnLogout);
        textView.setText("Welcome to the app,"+ username);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewAllUsers.this, MainActivity.class));
            }
        });
    }
}