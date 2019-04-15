package com.example.sam.tugasintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.sam.tugasintent.extra.MESSAGE";
    private EditText mMessageEditTextNama, mMessageEditTextAlamat, mMessageEditTextNoTlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditTextNama = (EditText) findViewById(R.id.editText_Nama);
        mMessageEditTextAlamat = (EditText) findViewById(R.id.editText_Alamat);
        mMessageEditTextNoTlp = (EditText) findViewById(R.id.editText_NoTlp);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);

        String message1 = mMessageEditTextNama.getText().toString();
        String message2 = mMessageEditTextAlamat.getText().toString();
        String message3 = mMessageEditTextNoTlp.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, "Nama   : "+message1+"\nAlamat : "+message2+"\nNoTlp  : "+message3);
        startActivity(intent);
    }
}
