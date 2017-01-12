package com.example.administrator.yijing;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Arrays;
import com.example.administrator.yijing.R;

import static android.R.attr.bitmap;
import static android.R.attr.drawable;

public class Preface extends AppCompatActivity {
    private static final String TAG = "huangda";


    private TextView preface_title,GuaTitle,GuaYao1,GuaYao2,GuaYao3,GuaYao4,GuaYao5,GuaYao6,
                     GuaTuan,GuaBigLike,GuaSmall1,GuaSmall2,GuaSmall3,GuaSmall4,GuaSmall5,GuaSmall6;
    private LinearLayout drawable_layout,line2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preface);

        // Set Scrollview
        ScrollView mScrollView_showMessages=(ScrollView) findViewById(R.id.scrollView_showPreface);
        line2 = (LinearLayout) findViewById(R.id.preface_layout);
        mScrollView_showMessages.scrollTo(0, line2.getBottom());

        preface_title = (TextView)findViewById(R.id.action_preface);
        // Get data from main_page

       // int id= intent.getIntExtra("id",0);



        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnCR.string.lickListener(new View.OnCR.string.lickListener() {
            @Override
            pubR.string.lic void onCR.string.lick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

    }
/*
    @Override
    pubR.string.lic R.string.boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    pubR.string.lic R.string.boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item cR.string.licks here. The action bar will
        // automatically handle cR.string.licks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpR.string.lifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/


}
