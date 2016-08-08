package xyz.johntsai.one.ui;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import xyz.johntsai.one.R;
import xyz.johntsai.one.ui.MainActivity;
import xyz.johntsai.one.utils.SharedPrefsUtils;

/**
 * Created by JohnTsai(mailto:johntsai.work@gmail.com) on 16/7/27.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        delay();
    }

    private void delay() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handleDelayTo();
            }
        },3*1000);
    }

    private void handleDelayTo() {
        Intent intent = new Intent();
        if(SharedPrefsUtils.get(this,getString(R.string.pref_first_open))==null){
            intent.setClass(this,MainActivity.class);
        }else{
            intent.setClass(this,MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
