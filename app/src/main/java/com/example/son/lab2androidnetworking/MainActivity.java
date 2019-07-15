package com.example.son.lab2androidnetworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edUsername;
    private EditText edPassword;
    private EditText edMyName;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUsername = (EditText) findViewById(R.id.edUsername);
        edPassword = (EditText) findViewById(R.id.edPassword);
        edMyName = (EditText) findViewById(R.id.edMyName);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    public void Login(View view) {
        PostTask postTask=new PostTask(edUsername.getText().toString().trim(),edPassword.getText().toString().trim());
        postTask.execute("http://dotplays.com/android/login.php");
        startActivity(new Intent(MainActivity.this, Home.class));
    }
}
