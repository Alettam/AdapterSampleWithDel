package com.example.adaptersample;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        int numberRnd = (int) (Math.random()*100);
        TextView textView = findViewById(R.id.textView);
        textView.setText("http://myfile.org/" + String.valueOf(numberRnd));

    }

    public void onClick(View view) {
        Intent intent = new Intent(FotoActivity.this, FotoActivity.class);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        finish();
    }
}

