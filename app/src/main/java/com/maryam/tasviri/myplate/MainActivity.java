package com.maryam.tasviri.myplate;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSignUp, btnSignIn;
    String Name, Pass, Email,Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = findViewById(R.id.btn_signUp);
        btnSignIn = findViewById(R.id.btn_LogIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUp = new Intent(MainActivity.this, SignUpActivity.class);
                startActivityForResult(intentSignUp,3000);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogIn = new Intent(MainActivity.this,SignIn.class);
                startActivity(intentLogIn);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==3000){
            if(resultCode==Activity.RESULT_OK){
                Name = data.getStringExtra("name");
                Pass = data.getStringExtra("pass");
                Email = data.getStringExtra("email");
                Phone = data.getStringExtra("phone");

                Toast.makeText(MainActivity.this, "Information saved, now you can log in... ",
                        Toast.LENGTH_SHORT).show();

            }
        }
    }
}
