package com.example.todo1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class level3 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        TextView score1= (TextView)findViewById(R.id.s1);
        TextView score2= (TextView)findViewById(R.id.s2);
        TextView total= (TextView)findViewById(R.id.t);
        int s1 = getIntent().getIntExtra("score1", 0);
        int s2 = getIntent().getIntExtra("score2", 0);
        int t=s1+s2;
        score1.setText(String.valueOf(s1));
        score2.setText(String.valueOf(s2));
        total.setText(String.valueOf(t));
    }
}
