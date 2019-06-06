package com.example.finalwork;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvResult=(TextView) findViewById(R.id.textView3);
        showResults();
    }
    private void showResults(){
        NumberFormat nf=NumberFormat.getInstance();
        Bundle bundle=getIntent().getExtras();
        int programming=bundle.getInt("programming");
        int dataStructure=bundle.getInt("dataStructure");
        int algorithm=bundle.getInt("algorithm");
        int sum=programming+dataStructure+algorithm;
        double average=sum/3.0;
        String text="programming="+programming+
                "\ndataStructure="+dataStructure+
                "\nalgorithm="+algorithm+
                "\nsum="+sum+
                "\naverage="+nf.format(average);
        tvResult.setText(text);
        alert(average);
    }
    private void alert(double average){
    String message=new String();
    String title=new String();
    int pic=0;
    if(average==100){
        message="Perfect!!";
        title="pass";
        pic=R.drawable.pass;
    }
    else if(average>=60){
    message="Congragulations!";
    title="Pass";
    pic=R.drawable.pass;
    }
    else if(average<60){
        message="You are too weak!";
        title="Failed";
        pic=R.drawable.fail;
    }


    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setPositiveButton("Ok",null);
    builder.setNegativeButton("Cancel",null);
    builder.setNeutralButton("Nothing",null);
    builder.setMessage(message);
    builder.setTitle(title);
    builder.setIcon(pic);
    builder.show();

    }







    public void onBackClick(View view){
        finish();
    }

}
