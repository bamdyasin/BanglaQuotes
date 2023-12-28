package com.earningaide.banglaquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    public  static String quoteTitle = "";
    public  static String quoteAuthor = "";
    public  static String quoteBody = "";

    TextView tvContentTitle,tvContentBody,tvAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        tvContentTitle = findViewById(R.id.tvContentTitle);
        tvAuthor = findViewById(R.id.tvAuthor);
        tvContentBody = findViewById(R.id.tvContentBody);

        tvContentTitle.setText(quoteTitle);
        tvAuthor.setText(quoteAuthor);
        tvContentBody.setText(quoteBody);
    }
}