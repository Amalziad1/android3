package com.example.todo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.os.Handler;


public class level2 extends AppCompatActivity {
    private int number1;
    private int number2;
    private int result;
    private int score=0;
    int flag=0;
    long delayMillis = 60 * 1000;//60 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        int s1 = getIntent().getIntExtra("score1", 0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //create an Intent to start the second activity
                Intent intent = new Intent(level2.this, level3.class);
                intent.putExtra("score1", s1);
                intent.putExtra("score2", score);
                startActivity(intent);
                finish();
            }
        }, delayMillis);

        TextView score1 = (TextView)findViewById(R.id.score2);
        Button num1 = (Button)findViewById(R.id.num12b);
        Button num2 = (Button)findViewById(R.id.num22b);
        Button result1 = (Button)findViewById(R.id.r12b);
        Button result2 = (Button)findViewById(R.id.r22b);
        Button result3 = (Button)findViewById(R.id.r32b);
        // initially
        result1.setText(String.valueOf("Result 1"));
        result2.setText(String.valueOf("Result 2"));
        result3.setText(String.valueOf("Result 3"));
        result1.setEnabled(false);
        result2.setEnabled(false);
        result3.setEnabled(false);
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "clicked...", Toast.LENGTH_LONG).show();
                number1 = generateRandomNumber(0,100);
                num1.setEnabled(false);
                num1.setText(String.valueOf(number1));
                flag++;
                if (flag == 2) {
                    enableResultButtons(result1,result2,result3,num1,num2,score1);
                }
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number2 = generateRandomNumber(0,100);
                System.out.println("number 2="+number2);
                num2.setEnabled(false);
                num2.setText(String.valueOf(number2));
                flag++;
                if (flag == 2) {
                    enableResultButtons(result1,result2,result3,num1,num2,score1);
                }
            }
        });
    }
    public void enableResultButtons(Button result1,Button result2, Button result3, Button num1,Button num2, TextView score1) {
        result1.setEnabled(true);
        result2.setEnabled(true);
        result3.setEnabled(true);
        result = number1-number2;// actual result
        int result2Value;//fake result2
        int result3Value;//fake result3
        do {
            result2Value = generateRandomNumber(0,40); // +/- 3
        } while (result2Value == result || result2Value == result+3 || result2Value==result-3);

        do {
            result3Value = generateRandomNumber(0,40);
        } while (result3Value == result || result3Value == result+2 || result3Value==result-2);

        int correctButton=generateRandomNumber(1,3);
        if(correctButton==1){
            result1.setText(String.valueOf(result));
            result2.setText(String.valueOf(result2Value));
            result3.setText(String.valueOf(result3Value));
        } else if (correctButton==2) {
            result2.setText(String.valueOf(result));
            result1.setText(String.valueOf(result2Value));
            result3.setText(String.valueOf(result3Value));
        } else if (correctButton==3) {
            result3.setText(String.valueOf(result));
            result2.setText(String.valueOf(result2Value));
            result1.setText(String.valueOf(result3Value));
        }

        int result1content=Integer.parseInt(result1.getText().toString());
        int result2content=Integer.parseInt(result2.getText().toString());
        int result3content=Integer.parseInt(result3.getText().toString());
        result1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result1content==result){
                    Toast.makeText(level2.this, "Correct!", Toast.LENGTH_SHORT).show();
                    score++;
                }else {
                    Toast.makeText(level2.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    score--;
                }
                num1.setEnabled(true);
                num2.setEnabled(true);
                result1.setEnabled(false);
                result2.setEnabled(false);
                result3.setEnabled(false);
                score1.setText(String.valueOf(score));
            }
        });
        result2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result2content==result){
                    Toast.makeText(level2.this, "Correct!", Toast.LENGTH_SHORT).show();
                    score++;
                }else {
                    Toast.makeText(level2.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    score--;
                }
                num1.setEnabled(true);
                num2.setEnabled(true);
                result1.setEnabled(false);
                result2.setEnabled(false);
                result3.setEnabled(false);
                score1.setText(String.valueOf(score));
            }
        });
        result3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result3content==result){
                    Toast.makeText(level2.this, "Correct!", Toast.LENGTH_SHORT).show();
                    score++;
                }else {
                    Toast.makeText(level2.this, "Incorrect...", Toast.LENGTH_SHORT).show();
                    score--;
                }
                num1.setEnabled(true);
                num2.setEnabled(true);
                result1.setEnabled(false);
                result2.setEnabled(false);
                result3.setEnabled(false);
                score1.setText(String.valueOf(score));
            }
        });
        flag=0;
    }
    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    public int getScore() {
        return score;
    }
}