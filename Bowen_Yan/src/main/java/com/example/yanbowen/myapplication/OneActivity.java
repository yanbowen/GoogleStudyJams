package com.example.yanbowen.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.yanbowen.googlestudyjams.R;

public class OneActivity extends Activity {

    private static final String TAG = "OneActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }


    public void MyButton(View view){

        Intent intent = new Intent(this,TwoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"TAG---onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"TAG---onStop");
    }
}
