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

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "huangda";
    private GlobalInfo globalinfo;
    int shang_gua;
    int xia_gua;
    int dong_yao;
    ImageButton goToResult;
    int _id;
    UpdateManager update_manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        InitUI();

        CheckEnviroment();


    /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;
        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.action_settings:
                break;
            case R.id.action_about:
                new AlertDialog.Builder(MainActivity.this).setTitle(R.string.ver_title)
                        .setMessage(R.string.ver_info)
                        .setPositiveButton(R.string.OK,new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();
                break;
            case R.id.update_bin:
                update_manager = new UpdateManager(MainActivity.this);
                Log.d(TAG,"begin to update");
                update_manager.checkUpdate();
                break;
            case R.id.action_preface:
                intent = new Intent();
                intent.setClass(MainActivity.this, Preface.class);
                startActivity(intent);
                break;
            case R.id.action_prev_tag:
                if(GetPreviousOne()) {
                    intent = new Intent();
                    intent.setClass(MainActivity.this, ResultPage.class);
                    intent.putExtra("shang_gua", shang_gua);
                    intent.putExtra("xia_gua", xia_gua);
                    intent.putExtra("dong_yao", dong_yao);
                    startActivity(intent);
                }else {

                    new AlertDialog.Builder(MainActivity.this).setTitle(R.string.warn_no_pre_info_title)
                            .setMessage(R.string.warn_no_pre_info)
                            .setPositiveButton(R.string.OK,new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();

                }
                break;
        }
/*
        if (id == R.id.action_settings) {

            return true;
        }else if(id == R.id.action_about){
            new AlertDialog.Builder(MainActivity.this).setTitle(R.string.ver_title)
                    .setMessage(R.string.ver_info)
                    .setPositiveButton(R.string.OK,new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
            return true;
        }else if(id == R.id.action_preface){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Preface.class);
            startActivity(intent);
        }else if(id ==R.id.action_prev_tag){
            if(GetPreviousOne()) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ResultPage.class);
                intent.putExtra("shang_gua", shang_gua);
                intent.putExtra("xia_gua", xia_gua);
                intent.putExtra("dong_yao", dong_yao);
                startActivity(intent);
            }else {

                new AlertDialog.Builder(MainActivity.this).setTitle(R.string.warn_no_pre_info_title)
                        .setMessage(R.string.warn_no_pre_info)
                        .setPositiveButton(R.string.OK,new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();

            }
        }
*/
        return super.onOptionsItemSelected(item);
    }
    public boolean GetPreviousOne(){
        SharedPreferences sharedPreferences= getSharedPreferences("gua_data",
                Activity.MODE_PRIVATE);
         shang_gua =sharedPreferences.getInt("shang_gua", 1);
         xia_gua =sharedPreferences.getInt("xia_gua", 1);
         dong_yao =sharedPreferences.getInt("dong_yao", 1);

        return true;
    }

    public void GetGua(){
       // int  temp[][];
       // temp=new int[100][3];
        Random random1 = new Random();
      /*  {
        for(int i=0;i<100;i++)
            {
                temp[i][0]= (random1.nextInt(99))%8;
                temp[i][1]= (random1.nextInt(99))%8;
                temp[i][2]= (random1.nextInt(99))%6;
                Log.d(TAG,i + " is "+ String.valueOf(temp[i][0]) + " "+ String.valueOf(temp[i][1]) +" "+ String.valueOf(temp[i][2]));
            }
        }*/
        shang_gua = (random1.nextInt(99))%8;
        shang_gua = shang_gua + 1;    /* 1 - 8 */
        Log.d(TAG,"shang is " + String.valueOf(shang_gua));

        xia_gua = (random1.nextInt(99))%8;
        xia_gua = xia_gua + 1;       /* 1 - 8 */
        Log.d(TAG,"xia is " + String.valueOf(xia_gua));

        dong_yao = (random1.nextInt(99))%6;
        dong_yao = dong_yao + 1;    /* 1 - 6 */
        Log.d(TAG,"dong is " + String.valueOf(dong_yao));


        SaveDataToSharePref();

    }
    public void SaveDataToSharePref() {
//实例化SharedPreferences对象（第一步）
        SharedPreferences mySharedPreferences= getSharedPreferences("gua_data",
                Activity.MODE_PRIVATE);
//实例化SharedPreferences.Editor对象（第二步）
        SharedPreferences.Editor editor = mySharedPreferences.edit();
//用putString的方法保存数据
        editor.putInt("shang_gua", shang_gua);
        editor.putInt("xia_gua", xia_gua);
        editor.putInt("dong_yao", dong_yao);
//提交当前数据
        editor.commit();
//使用toast信息提示框提示成功写入数据
        //Toast.makeText(this, "数据成功写入SharedPreferences！" , Toast.LENGTH_LONG).show();
    }

    public void InitUI(){
        TextView main_title;
        main_title = (TextView)findViewById(R.id.page_title);
        main_title.setTextColor(Color.rgb(255,255,255));
        goToResult = (ImageButton)findViewById(R.id.GoToResult);
        goToResult.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                GetGua();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ResultPage.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //    intent.putExtra("shang_gua",shang_gua);
                //    intent.putExtra("xia_gua",xia_gua);
                //    intent.putExtra("dong_yao",dong_yao);

                //  for debug test
                //    intent.putExtra("id",_id);
                startActivity(intent);
                //    _id+=1;
                //    if((_id>64)||(_id==64))
                //    {
                //        _id=0;
                //    }
                //   overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        });
    }

    public void CheckEnviroment(){
        globalinfo=(GlobalInfo)getApplicationContext();
        Log.d(TAG,"VersionCode is " + globalinfo.getVersionCode(MainActivity.this));
        Log.d(TAG,"VersionName is " + globalinfo.getVersionName(MainActivity.this));


        if(globalinfo.isNetworkConnected(MainActivity.this)
               && (1==globalinfo.getConnectedType(MainActivity.this)) ){
            Log.d(TAG,"getConnectedType is Wifi" );


        }else{

        }
    }
}
