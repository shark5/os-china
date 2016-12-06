package com.cjp.os_china.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.cjp.os_china.R;
import com.cjp.os_china.ui.main.MainActivity;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.app_start_view).postDelayed(new Runnable() {
            @Override
            public void run() {
                redirectTo();
            }
        }, 800);
    }

    private void redirectTo() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
