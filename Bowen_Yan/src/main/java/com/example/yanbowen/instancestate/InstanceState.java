package com.example.yanbowen.instancestate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.yanbowen.googlestudyjams.R;

public class InstanceState extends AppCompatActivity {

    public static final String TAG = "InstanceState";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instance_state);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"onSaveInstanceState--------");
        outState.putString("extra_test","test");
    }

    /**
     * 推荐接收位置在onRestoreInstanceState，以为onRestoreInstanceState一旦被调用说明
     * @param savedInstanceState 一定非空！
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String test = (String) savedInstanceState.get("extra_test");
        Log.d(TAG,"[onRestoreInstanceState]restore extra_test:" + test);
    }
}
