package com.example.yanbowen.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.yanbowen.googlestudyjams.R;

public class TwoActivity extends Activity {

    private static final String TAG = "TwoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.d(TAG,"TAG---onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"TAG---onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"TAG---onResume");
    }
}
