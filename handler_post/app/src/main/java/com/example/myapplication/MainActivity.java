package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void myclick(View view){
        switch (view.getId()){
            case R.id.btn_one:
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "你点击了按钮", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }.start();
                break;
            /**
             * postDelayed延迟操作
             * 这里延迟三秒后显示Toast
             */
            case R.id.btn_two:
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "你点击了按钮", Toast.LENGTH_SHORT).show();
                            }
                        },3000);
                    }
                }.start();
                break;
            /**
             *  handler.postAtTime按照系统本地的时间往后推
             *  这里是按本地时间推后2秒显示
             */
            case R.id.btn_three:
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        handler.postAtTime(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "你点击了按钮", Toast.LENGTH_SHORT).show();
                            }
                        }, SystemClock.uptimeMillis()+2000);//系统时间推后两秒
                    }
                }.start();
        }
    }
}
