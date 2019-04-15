package com.example.sam.tugasintent;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {


    private TextView mShareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView =(TextView) findViewById(R.id.text_message);
        textView.setText(message);
        
        mShareEditText = (TextView) findViewById(R.id.text_message);

    }

    public void shareText(View view) {
        String message = mShareEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(message)
                .startChooser();
    }
}