package com.maryam.tasviri.myplate;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    EditText Name, Email, Phone, Pass;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        Phone = findViewById(R.id.phone);
        Pass = findViewById(R.id.pass);

        btnSave = findViewById(R.id.btn);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Name.getText().toString().isEmpty() || Email.getText().toString().isEmpty() || Phone.getText().toString().isEmpty() || Pass.getText().toString().isEmpty()){


                    AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
                    alertDialog.setTitle("Oops!");
                    alertDialog.setMessage("Please check all data in the login form is correct and try again");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
                else{

                    Intent signUpIntent = new Intent();

                    signUpIntent.putExtra("name", Name.getText().toString());
                    signUpIntent.putExtra("email", Email.getText().toString());
                    signUpIntent.putExtra("phone", Phone.getText().toString());
                    signUpIntent.putExtra("pass",Pass.getText().toString());

                    PreferenceManager.getDefaultSharedPreferences(SignUpActivity.this).edit().putString("username",Name.getText().toString()).apply();
                    PreferenceManager.getDefaultSharedPreferences(SignUpActivity.this).edit().putString("pass",Pass.getText().toString()).apply();

                    setResult(Activity.RESULT_OK, signUpIntent);
                    finish();
                }

            }
        });

    }
}
