package com.example.root.gmailexample.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.gmailexample.R;


public class MainActivity extends AppCompatActivity {

    EditText name,password;
    Button login,signup;
    TextView forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= (EditText) findViewById(R.id.etName);
        password= (EditText) findViewById(R.id.etPassword);
        login= (Button) findViewById(R.id.btnLogin);
        signup= (Button) findViewById(R.id.btnSignUp);
        forgotPassword= (TextView) findViewById(R.id.tvForgotPassword);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr=name.getText().toString();
                String passStr=password.getText().toString();
                if (!(nameStr.matches("")||(passStr.matches(""))))
                {
                    startActivity(new Intent(MainActivity.this,LogIn.class).putExtra("name",nameStr).putExtra("password",passStr));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Somethings mising...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ForgotPassword.class));
            }
        });




    }
}
