package com.example.apurva.apr6assignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    CheckBox remember;
    Button login;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Intent intent;
    boolean check_or_not;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);
        remember=findViewById(R.id.cb_remember_user_pass);
        login=findViewById(R.id.btn_login);


        //used to get sharedprefrence file
        pref=getSharedPreferences("file", Context.MODE_PRIVATE);


        if (pref.getString("username_key",null)!=null && pref.getString("password_key",null)!=null){

            username.setText(pref.getString("username_key",null));
            password.setText(pref.getString("password_key",null));
        }

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                check_or_not=isChecked;
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){

                    if (username.getText().toString().isEmpty()){
                        username.setError("Enter username");
                    }
                    if (password.getText().toString().isEmpty()){
                        password.setError("Enter password");
                    }

                }
                else {


                    //used to allow in your file
                    editor=pref.edit();

                    String user=username.getText().toString();
                    String pass=password.getText().toString();

                    if (check_or_not){
                        editor.putString("username_key",user);
                        editor.putString("password_key",pass);
                        editor.commit();
                    }


                    intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("username_key",user);

                    startActivity(intent);

                }
            }
        });


    }
}
