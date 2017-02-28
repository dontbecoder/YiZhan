package com.example.administrator.yijing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Random;
import com.example.administrator.yijing.R;
import static com.example.administrator.yijing.R.layout.activity_main;
import static com.example.administrator.yijing.R.layout.splash_page;

public class SplashPage extends AppCompatActivity {
    private static final String TAG = "huangda";
    private final int SPLASH_DELAY_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(splash_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        InitUI();

    }


    public void InitUI(){
        TextView main_title;
        main_title = (TextView)findViewById(R.id.splash_page_title);
        main_title.setTextColor(Color.rgb(255,255,255));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashPage.this.startActivity(new Intent(SplashPage.this, MainActivity.class));
                SplashPage.this.finish();
            }
        }, SPLASH_DELAY_TIME);
    }


}
