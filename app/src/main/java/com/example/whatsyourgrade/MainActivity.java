package com.example.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nName, nScore;
    private Button findGradeBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nName = (EditText) findViewById(R.id.editText);
        nScore = (EditText) findViewById(R.id.editText2);
        findGradeBtn = (Button) findViewById(R.id.button1);
        exitBtn = (Button) findViewById(R.id.button2);

        findGradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = nName.getText().toString();
                String nameUser = String.valueOf(nameText);
                String pointText = nScore.getText().toString();
                int pointUser = Integer.valueOf(pointText);
                String gradeText = getGrade(pointUser);

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("your_name", nameUser);
                intent.putExtra("your_grade", gradeText);

            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("Confirm Exit/n/nแน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.setPositiveButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
            }
        });

    }

    private String getGrade(int pointUser){
        String gradeText = "";
        if(pointUser>=80){
            gradeText = "A";
        }
        else if(pointUser>=70 && pointUser<=79){
            gradeText = "B";
        }
        else if(pointUser>=60 && pointUser<=69){
            gradeText = "C";
        }
        else if(pointUser>=50 && pointUser<=59){
            gradeText = "D";
        }
        else{
            gradeText = "F";
        }
        return gradeText;
    }
}
