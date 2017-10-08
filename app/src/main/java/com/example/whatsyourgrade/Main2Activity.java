package com.example.whatsyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    private TextView sName, sGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sName = (TextView)findViewById(R.id.textView6);
        sGrade = (TextView)findViewById(R.id.textView3);

        Intent intent = getIntent();
        String showName = intent.getStringExtra("your_name");
        String showGrade = intent.getStringExtra("your_grade");
        sName.setText(showName);
        sGrade.setText(showGrade);
    }
}
