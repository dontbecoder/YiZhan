package com.example.administrator.yijing;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import static com.example.administrator.yijing.R.layout.resultpage;

public class Gua_64   {
    private String name;
    private String title;
    private String tuanci;

    private String[] yaoci;
    private String bigLike;
    private String[] smallLike;
    private String use_ci;


    public  Gua_64(String name, String title, String tuanci,String[] yaoci, String bigLike,
                        String[] smallLike,String use_ci)
    {
        this.name = name;
        this.title=title;
        this.tuanci=tuanci;
        this.yaoci=yaoci;
        this.bigLike=bigLike;
        this.smallLike=smallLike;
        this.use_ci=use_ci;
    }
}
