package com.example.apurva.apr6assignment;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        msg=findViewById(R.id.textView);

        Bundle b=getIntent().getExtras();

        String info=b.getString("username_key");

        msg.setText("Welcome to Ducat \n"+info);
    }



    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog=new AlertDialog.Builder(SecondActivity.this);
        alertDialog.setTitle("Do You want to Exit");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                //Finish all the activity including all parent API 16+
//               finishAffinity();


                //Finish all the activity including all parent API 15 or lower

                ActivityCompat.finishAffinity(SecondActivity.this);

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();


    }
}
