package com.maryam.tasviri.myplate;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button btn_next = findViewById(R.id.btn_next);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameSaved = PreferenceManager.getDefaultSharedPreferences(SignIn.this).getString("username", "Null");
                String passSaved = PreferenceManager.getDefaultSharedPreferences(SignIn.this).getString("pass", "");

                if(username.getText().toString().equals(usernameSaved) && pass.getText().toString().equals(passSaved)){
                    Intent goFirstPage = new Intent(SignIn.this,FirstPage.class);
                    startActivity(goFirstPage);
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(SignIn.this).create();
                    alertDialog.setTitle("Login Error");
                    alertDialog.setMessage("The credentials you entered did not match our records. Please double-check and try again.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
            }
        });
    }
}
