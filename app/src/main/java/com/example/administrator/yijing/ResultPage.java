package com.example.administrator.yijing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class ResultPage extends AppCompatActivity {
    private static final String TAG = "huangda";
    private int _id =0;
    private int[] gua={0,0};
    private int dong;
    private int gua_id;
    private int[][] gua_table={
        /*    {1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},
            {2,1},{2,2},{2,3},{2,4},{2,5},{2,6},{2,7},{2,8},
            {3,1},{3,2},{3,3},{3,4},{3,5},{3,6},{3,7},{3,8},
            {4,1},{4,2},{4,3},{4,4},{4,5},{4,6},{4,7},{4,8},
            {5,1},{5,2},{5,3},{5,4},{5,5},{5,6},{5,7},{5,8},
            {6,1},{6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{6,8},
            {7,1},{7,2},{7,3},{7,4},{7,5},{7,6},{7,7},{7,8},
            {8,1},{8,2},{8,3},{8,4},{8,5},{8,6},{8,7},{8,8},*/
            {1,1},{8,8},{6,4},{7,6},{6,1},{1,6},{8,6},{6,8},
            {5,1},{1,2},{8,1},{1,8},{1,3},{3,1},{8,7},{4,8},
            {2,4},{7,5},{8,2},{5,8},{3,4},{7,3},{7,8},{8,4},
            {1,4},{7,1},{7,4},{2,5},{6,6},{3,3},{2,7},{4,5},
            {1,7},{4,1},{3,8},{8,3},{5,3},{3,2},{6,7},{4,6},
            {7,2},{5,4},{2,1},{1,5},{2,8},{8,5},{2,6},{6,5},
            {2,3},{3,5},{4,4},{7,7},{5,7},{4,2},{4,3},{3,7},
            {5,5},{2,2},{5,6},{6,2},{5,2},{4,7},{6,3},{3,6},
    };
    private int[][] gua_init_able={
    {R.string.qian_name,R.string.qian_title,R.string.qian_1,R.string.qian_2,R.string.qian_3,R.string.qian_4,R.string.qian_5,R.string.qian_6,R.string.qian_tuanci,R.string.qian_bigLike,R.string.qian_small_L1},
    {R.string.kun_name,R.string.kun_title,R.string.kun_1,R.string.kun_2,R.string.kun_3,R.string.kun_4,R.string.kun_5,R.string.kun_6,R.string.kun_tuanci,R.string.kun_bigLike,R.string.kun_small_L1},
    {R.string.tun_name,R.string.tun_title,R.string.tun_1,R.string.tun_2,R.string.tun_3,R.string.tun_4,R.string.tun_5,R.string.tun_6,R.string.tun_tuanci,R.string.tun_bigLike,R.string.tun_small_L1},
    {R.string.meng_name,R.string.meng_title,R.string.meng_1,R.string.meng_2,R.string.meng_3,R.string.meng_4,R.string.meng_5,R.string.meng_6,R.string.meng_tuanci,R.string.meng_bigLike,R.string.meng_small_L1},
    {R.string.xu_name,R.string.xu_title,R.string.xu_1,R.string.xu_2,R.string.xu_3,R.string.xu_4,R.string.xu_5,R.string.xu_6,R.string.xu_tuanci,R.string.xu_bigLike,R.string.xu_small_L1},
    {R.string.song_name,R.string.song_title,R.string.song_1,R.string.song_2,R.string.song_3,R.string.song_4,R.string.song_5,R.string.song_6,R.string.song_tuanci,R.string.song_bigLike,R.string.song_small_L1},
    {R.string.shi_name,R.string.shi_title,R.string.shi_1,R.string.shi_2,R.string.shi_3,R.string.shi_4,R.string.shi_5,R.string.shi_6,R.string.shi_tuanci,R.string.shi_bigLike,R.string.shi_small_L1},
    {R.string.bi_name,R.string.bi_title,R.string.bi_1,R.string.bi_2,R.string.bi_3,R.string.bi_4,R.string.bi_5,R.string.bi_6,R.string.bi_tuanci,R.string.bi_bigLike,R.string.bi_small_L1},
    {R.string.xiaoxu_name,R.string.xiaoxu_title,R.string.xiaoxu_1,R.string.xiaoxu_2,R.string.xiaoxu_3,R.string.xiaoxu_4,R.string.xiaoxu_5,R.string.xiaoxu_6,R.string.xiaoxu_tuanci,R.string.xiaoxu_bigLike,R.string.xiaoxu_small_L1},
    {R.string.lv_name,R.string.lv_title,R.string.lv_1,R.string.lv_2,R.string.lv_3,R.string.lv_4,R.string.lv_5,R.string.lv_6,R.string.lv_tuanci,R.string.lv_bigLike,R.string.lv_small_L1},
    {R.string.tai_name,R.string.tai_title,R.string.tai_1,R.string.tai_2,R.string.tai_3,R.string.tai_4,R.string.tai_5,R.string.tai_6,R.string.tai_tuanci,R.string.tai_bigLike,R.string.tai_small_L1},
    {R.string.pi_name,R.string.pi_title,R.string.pi_1,R.string.pi_2,R.string.pi_3,R.string.pi_4,R.string.pi_5,R.string.pi_6,R.string.pi_tuanci,R.string.pi_bigLike,R.string.pi_small_L1},
    {R.string.tongren_name,R.string.tongren_title,R.string.tongren_1,R.string.tongren_2,R.string.tongren_3,R.string.tongren_4,R.string.tongren_5,R.string.tongren_6,R.string.tongren_tuanci,R.string.tongren_bigLike,R.string.tongren_small_L1},
    {R.string.dayou_name,R.string.dayou_title,R.string.dayou_1,R.string.dayou_2,R.string.dayou_3,R.string.dayou_4,R.string.dayou_5,R.string.dayou_6,R.string.dayou_tuanci,R.string.dayou_bigLike,R.string.dayou_small_L1},
    {R.string.qian1_name,R.string.qian1_title,R.string.qian1_1,R.string.qian1_2,R.string.qian1_3,R.string.qian1_4,R.string.qian1_5,R.string.qian1_6,R.string.qian1_tuanci,R.string.qian1_bigLike,R.string.qian1_small_L1},
    {R.string.yu_name,R.string.yu_title,R.string.yu_1,R.string.yu_2,R.string.yu_3,R.string.yu_4,R.string.yu_5,R.string.yu_6,R.string.yu_tuanci,R.string.yu_bigLike,R.string.yu_small_L1},
    {R.string.sui_name,R.string.sui_title,R.string.sui_1,R.string.sui_2,R.string.sui_3,R.string.sui_4,R.string.sui_5,R.string.sui_6,R.string.sui_tuanci,R.string.sui_bigLike,R.string.sui_small_L1},
    {R.string.gu_name,R.string.gu_title,R.string.gu_1,R.string.gu_2,R.string.gu_3,R.string.gu_4,R.string.gu_5,R.string.gu_6,R.string.gu_tuanci,R.string.gu_bigLike,R.string.gu_small_L1},
    {R.string.lin_name,R.string.lin_title,R.string.lin_1,R.string.lin_2,R.string.lin_3,R.string.lin_4,R.string.lin_5,R.string.lin_6,R.string.lin_tuanci,R.string.lin_bigLike,R.string.lin_small_L1},
            {R.string.guan_name,R.string.guan_title,R.string.guan_1,R.string.guan_2,R.string.guan_3,R.string.guan_4,R.string.guan_5,R.string.guan_6,R.string.guan_tuanci,R.string.guan_bigLike,R.string.guan_small_L1},
            {R.string.shihe_name,R.string.shihe_title,R.string.shihe_1,R.string.shihe_2,R.string.shihe_3,R.string.shihe_4,R.string.shihe_5,R.string.shihe_6,R.string.shihe_tuanci,R.string.shihe_bigLike,R.string.shihe_small_L1},
            {R.string.bi4_name,R.string.bi4_title,R.string.bi4_1,R.string.bi4_2,R.string.bi4_3,R.string.bi4_4,R.string.bi4_5,R.string.bi4_6,R.string.bi4_tuanci,R.string.bi4_bigLike,R.string.bi4_small_L1},
            {R.string.bo_name,R.string.bo_title,R.string.bo_1,R.string.bo_2,R.string.bo_3,R.string.bo_4,R.string.bo_5,R.string.bo_6,R.string.bo_tuanci,R.string.bo_bigLike,R.string.bo_small_L1},
            {R.string.fu_name,R.string.fu_title,R.string.fu_1,R.string.fu_2,R.string.fu_3,R.string.fu_4,R.string.fu_5,R.string.fu_6,R.string.fu_tuanci,R.string.fu_bigLike,R.string.fu_small_L1},
            {R.string.wuwang_name,R.string.wuwang_title,R.string.wuwang_1,R.string.wuwang_2,R.string.wuwang_3,R.string.wuwang_4,R.string.wuwang_5,R.string.wuwang_6,R.string.wuwang_tuanci,R.string.wuwang_bigLike,R.string.wuwang_small_L1},
            {R.string.daxu_name,R.string.daxu_title,R.string.daxu_1,R.string.daxu_2,R.string.daxu_3,R.string.daxu_4,R.string.daxu_5,R.string.daxu_6,R.string.daxu_tuanci,R.string.daxu_bigLike,R.string.daxu_small_L1},
            {R.string.yi_name,R.string.yi_title,R.string.yi_1,R.string.yi_2,R.string.yi_3,R.string.yi_4,R.string.yi_5,R.string.yi_6,R.string.yi_tuanci,R.string.yi_bigLike,R.string.yi_small_L1},
            {R.string.daguo_name,R.string.daguo_title,R.string.daguo_1,R.string.daguo_2,R.string.daguo_3,R.string.daguo_4,R.string.daguo_5,R.string.daguo_6,R.string.daguo_tuanci,R.string.daguo_bigLike,R.string.daguo_small_L1},
            {R.string.kan_name,R.string.kan_title,R.string.kan_1,R.string.kan_2,R.string.kan_3,R.string.kan_4,R.string.kan_5,R.string.kan_6,R.string.kan_tuanci,R.string.kan_bigLike,R.string.kan_small_L1},
            {R.string.li_name,R.string.li_title,R.string.li_1,R.string.li_2,R.string.li_3,R.string.li_4,R.string.li_5,R.string.li_6,R.string.li_tuanci,R.string.li_bigLike,R.string.li_small_L1},
            {R.string.xian_name,R.string.xian_title,R.string.xian_1,R.string.xian_2,R.string.xian_3,R.string.xian_4,R.string.xian_5,R.string.xian_6,R.string.xian_tuanci,R.string.xian_bigLike,R.string.xian_small_L1},
            {R.string.heng_name,R.string.heng_title,R.string.heng_1,R.string.heng_2,R.string.heng_3,R.string.heng_4,R.string.heng_5,R.string.heng_6,R.string.heng_tuanci,R.string.heng_bigLike,R.string.heng_small_L1},
            {R.string.dun_name,R.string.dun_title,R.string.dun_1,R.string.dun_2,R.string.dun_3,R.string.dun_4,R.string.dun_5,R.string.dun_6,R.string.dun_tuanci,R.string.dun_bigLike,R.string.dun_small_L1},
            {R.string.dazhuang_name,R.string.dazhuang_title,R.string.dazhuang_1,R.string.dazhuang_2,R.string.dazhuang_3,R.string.dazhuang_4,R.string.dazhuang_5,R.string.dazhuang_6,R.string.dazhuang_tuanci,R.string.dazhuang_bigLike,R.string.dazhuang_small_L1},
            {R.string.jin_name,R.string.jin_title,R.string.jin_1,R.string.jin_2,R.string.jin_3,R.string.jin_4,R.string.jin_5,R.string.jin_6,R.string.jin_tuanci,R.string.jin_bigLike,R.string.jin_small_L1},
            {R.string.mingyi_name,R.string.mingyi_title,R.string.mingyi_1,R.string.mingyi_2,R.string.mingyi_3,R.string.mingyi_4,R.string.mingyi_5,R.string.mingyi_6,R.string.mingyi_tuanci,R.string.mingyi_bigLike,R.string.mingyi_small_L1},
            {R.string.jiaren_name,R.string.jiaren_title,R.string.jiaren_1,R.string.jiaren_2,R.string.jiaren_3,R.string.jiaren_4,R.string.jiaren_5,R.string.jiaren_6,R.string.jiaren_tuanci,R.string.jiaren_bigLike,R.string.jiaren_small_L1},
            {R.string.kui_name,R.string.kui_title,R.string.kui_1,R.string.kui_2,R.string.kui_3,R.string.kui_4,R.string.kui_5,R.string.kui_6,R.string.kui_tuanci,R.string.kui_bigLike,R.string.kui_small_L1},
            {R.string.jian_name,R.string.jian_title,R.string.jian_1,R.string.jian_2,R.string.jian_3,R.string.jian_4,R.string.jian_5,R.string.jian_6,R.string.jian_tuanci,R.string.jian_bigLike,R.string.jian_small_L1},
            {R.string.jie_name,R.string.jie_title,R.string.jie_1,R.string.jie_2,R.string.jie_3,R.string.jie_4,R.string.jie_5,R.string.jie_6,R.string.jie_tuanci,R.string.jie_bigLike,R.string.jie_small_L1},
            {R.string.sun_name,R.string.sun_title,R.string.sun_1,R.string.sun_2,R.string.sun_3,R.string.sun_4,R.string.sun_5,R.string.sun_6,R.string.sun_tuanci,R.string.sun_bigLike,R.string.sun_small_L1},
            {R.string.yi4_name,R.string.yi4_title,R.string.yi4_1,R.string.yi4_2,R.string.yi4_3,R.string.yi4_4,R.string.yi4_5,R.string.yi4_6,R.string.yi4_tuanci,R.string.yi4_bigLike,R.string.yi4_small_L1},
            {R.string.guai_name,R.string.guai_title,R.string.guai_1,R.string.guai_2,R.string.guai_3,R.string.guai_4,R.string.guai_5,R.string.guai_6,R.string.guai_tuanci,R.string.guai_bigLike,R.string.guai_small_L1},
            {R.string.gou_name,R.string.gou_title,R.string.gou_1,R.string.gou_2,R.string.gou_3,R.string.gou_4,R.string.gou_5,R.string.gou_6,R.string.gou_tuanci,R.string.gou_bigLike,R.string.gou_small_L1},
            {R.string.cui_name,R.string.cui_title,R.string.cui_1,R.string.cui_2,R.string.cui_3,R.string.cui_4,R.string.cui_5,R.string.cui_6,R.string.cui_tuanci,R.string.cui_bigLike,R.string.cui_small_L1},
            {R.string.sheng_name,R.string.sheng_title,R.string.sheng_1,R.string.sheng_2,R.string.sheng_3,R.string.sheng_4,R.string.sheng_5,R.string.sheng_6,R.string.sheng_tuanci,R.string.sheng_bigLike,R.string.sheng_small_L1},
            {R.string.kun4_name,R.string.kun4_title,R.string.kun4_1,R.string.kun4_2,R.string.kun4_3,R.string.kun4_4,R.string.kun4_5,R.string.kun4_6,R.string.kun4_tuanci,R.string.kun4_bigLike,R.string.kun4_small_L1},
            {R.string.jing_name,R.string.jing_title,R.string.jing_1,R.string.jing_2,R.string.jing_3,R.string.jing_4,R.string.jing_5,R.string.jing_6,R.string.jing_tuanci,R.string.jing_bigLike,R.string.jing_small_L1},
            {R.string.ge_name,R.string.ge_title,R.string.ge_1,R.string.ge_2,R.string.ge_3,R.string.ge_4,R.string.ge_5,R.string.ge_6,R.string.ge_tuanci,R.string.ge_bigLike,R.string.ge_small_L1},
            {R.string.ding_name,R.string.ding_title,R.string.ding_1,R.string.ding_2,R.string.ding_3,R.string.ding_4,R.string.ding_5,R.string.ding_6,R.string.ding_tuanci,R.string.ding_bigLike,R.string.ding_small_L1},
            {R.string.zhen_name,R.string.zhen_title,R.string.zhen_1,R.string.zhen_2,R.string.zhen_3,R.string.zhen_4,R.string.zhen_5,R.string.zhen_6,R.string.zhen_tuanci,R.string.zhen_bigLike,R.string.zhen_small_L1},
            {R.string.gen_name,R.string.gen_title,R.string.gen_1,R.string.gen_2,R.string.gen_3,R.string.gen_4,R.string.gen_5,R.string.gen_6,R.string.gen_tuanci,R.string.gen_bigLike,R.string.gen_small_L1},
            {R.string.jian4_name,R.string.jian4_title,R.string.jian4_1,R.string.jian4_2,R.string.jian4_3,R.string.jian4_4,R.string.jian4_5,R.string.jian4_6,R.string.jian4_tuanci,R.string.jian4_bigLike,R.string.jian4_small_L1},
            {R.string.guimei_name,R.string.guimei_title,R.string.guimei_1,R.string.guimei_2,R.string.guimei_3,R.string.guimei_4,R.string.guimei_5,R.string.guimei_6,R.string.guimei_tuanci,R.string.guimei_bigLike,R.string.guimei_small_L1},
            {R.string.feng_name,R.string.feng_title,R.string.feng_1,R.string.feng_2,R.string.feng_3,R.string.feng_4,R.string.feng_5,R.string.feng_6,R.string.feng_tuanci,R.string.feng_bigLike,R.string.feng_small_L1},
            {R.string.nu_name,R.string.nu_title,R.string.nu_1,R.string.nu_2,R.string.nu_3,R.string.nu_4,R.string.nu_5,R.string.nu_6,R.string.nu_tuanci,R.string.nu_bigLike,R.string.nu_small_L1},
            {R.string.xun_name,R.string.xun_title,R.string.xun_1,R.string.xun_2,R.string.xun_3,R.string.xun_4,R.string.xun_5,R.string.xun_6,R.string.xun_tuanci,R.string.xun_bigLike,R.string.xun_small_L1},
            {R.string.dui_name,R.string.dui_title,R.string.dui_1,R.string.dui_2,R.string.dui_3,R.string.dui_4,R.string.dui_5,R.string.dui_6,R.string.dui_tuanci,R.string.dui_bigLike,R.string.dui_small_L1},
            {R.string.huan_name,R.string.huan_title,R.string.huan_1,R.string.huan_2,R.string.huan_3,R.string.huan_4,R.string.huan_5,R.string.huan_6,R.string.huan_tuanci,R.string.huan_bigLike,R.string.huan_small_L1},
            {R.string.jie2_name,R.string.jie2_title,R.string.jie2_1,R.string.jie2_2,R.string.jie2_3,R.string.jie2_4,R.string.jie2_5,R.string.jie2_6,R.string.jie2_tuanci,R.string.jie2_bigLike,R.string.jie2_small_L1},
            {R.string.zhongfu_name,R.string.zhongfu_title,R.string.zhongfu_1,R.string.zhongfu_2,R.string.zhongfu_3,R.string.zhongfu_4,R.string.fu_5,R.string.zhongfu_6,R.string.zhongfu_tuanci,R.string.zhongfu_bigLike,R.string.zhongfu_small_L1},
            {R.string.xiaoguo_name,R.string.xiaoguo_title,R.string.xiaoguo_1,R.string.xiaoguo_2,R.string.xiaoguo_3,R.string.xiaoguo_4,R.string.xiaoguo_5,R.string.xiaoguo_6,R.string.xiaoguo_tuanci,R.string.xiaoguo_bigLike,R.string.xiaoguo_small_L1},
            {R.string.jiji_name,R.string.jiji_title,R.string.jiji_1,R.string.jiji_2,R.string.jiji_3,R.string.jiji_4,R.string.jiji_5,R.string.jiji_6,R.string.jiji_tuanci,R.string.jiji_bigLike,R.string.jiji_small_L1},
            {R.string.weiji_name,R.string.weiji_title,R.string.weiji_1,R.string.weiji_2,R.string.weiji_3,R.string.weiji_4,R.string.weiji_5,R.string.weiji_6,R.string.weiji_tuanci,R.string.weiji_bigLike,R.string.weiji_small_L1},
    };
   /* private  int[] gua_image_table={
            R.drawable.qian,R.drawable.kun,R.drawable.tun,R.drawable.meng,R.drawable.xu,R.drawable.song,R.drawable.shi,R.drawable.bi,
            R.drawable.xiaoxu,R.drawable.lv,R.drawable.tai,R.drawable.pi,R.drawable.tongren,R.drawable.dayou,R.drawable.qian1,R.drawable.yu,
            R.drawable.sui,R.drawable.gu,R.drawable.lin,R.drawable.guan,R.drawable.shihe,R.drawable.bi4,R.drawable.bo,R.drawable.fu,
            R.drawable.wuwang,R.drawable.daxu,R.drawable.yi,R.drawable.daguo,R.drawable.kan,R.drawable.li,R.drawable.xian,R.drawable.heng,
            R.drawable.dun,R.drawable.dazhuang,R.drawable.jin,R.drawable.mingyi,R.drawable.jiaren,R.drawable.kui,R.drawable.jian,R.drawable.jie,
            R.drawable.sun,R.drawable.yi4,R.drawable.guai,R.drawable.gou,R.drawable.cui,R.drawable.sheng,R.drawable.kun4,R.drawable.jing,
            R.drawable.ge,R.drawable.ding,R.drawable.zhen,R.drawable.gen,R.drawable.jian4,R.drawable.guimei,R.drawable.feng,R.drawable.nu,
            R.drawable.xun,R.drawable.dui,R.drawable.huan,R.drawable.jie2,R.drawable.zhongfu,R.drawable.xiaoguo,R.drawable.jiji,R.drawable.weiji,
    };*/
    private int[][] yao_talbe={
            {1,1,1,1,1,1},{0,0,0,0,0,0},{0,1,0,0,0,1},{1,0,0,0,1,0},{0,1,0,1,1,1},{1,1,1,0,1,0},{0,0,0,0,1,0},{0,1,0,0,0,0},
            {1,1,0,1,1,1},{1,1,1,0,1,1},{0,0,0,1,1,1},{1,1,1,0,0,0},{1,1,1,1,0,1},{1,0,1,1,1,1},{0,0,0,1,0,0},{0,0,1,0,0,0},
            {0,1,1,0,0,1},{1,0,0,1,1,0},{0,0,0,0,1,1},{1,1,0,0,0,0},{1,0,1,0,0,1},{1,0,0,1,0,1},{1,0,0,0,0,0},{0,0,0,0,0,1},
            {1,1,1,0,0,1},{1,0,0,1,1,1},{1,0,0,0,0,1},{0,1,1,1,1,0},{0,1,0,0,1,0},{1,0,1,1,0,1},{0,1,1,1,0,0},{0,0,1,1,1,0},
            {1,1,1,1,0,0},{0,0,1,1,1,1},{1,0,1,0,0,0},{0,0,0,1,0,1},{1,1,0,1,0,1},{1,0,1,0,1,1},{0,1,0,1,0,0},{0,0,1,0,1,0},
            {1,0,0,0,1,1},{1,1,0,0,0,1},{0,1,1,1,1,1},{1,1,1,1,1,0},{0,1,1,0,0,0},{0,0,0,1,1,0},{0,1,1,0,1,0},{0,1,0,1,1,0},
            {0,1,1,1,0,1},{1,0,1,1,1,0},{0,0,1,0,0,1},{1,0,0,1,0,0},{1,1,0,1,0,0},{0,0,1,0,1,1},{0,0,1,1,0,1},{1,0,1,1,0,0},
            {1,1,0,1,1,0},{0,1,1,0,1,1},{1,1,0,0,1,0},{0,1,0,0,1,1},{1,1,0,0,1,1},{0,0,1,1,0,0},{0,1,0,1,0,1},{1,0,1,0,1,0}
    };
    private TextView GuaName,GuaTitle,GuaYao1,GuaYao2,GuaYao3,GuaYao4,GuaYao5,GuaYao6,
                     GuaTuan,GuaBigLike,GuaSmall1,GuaSmall2,GuaSmall3,GuaSmall4,GuaSmall5,GuaSmall6;
    private LinearLayout drawable_layout,line2;
    private ImageView Gua_image;
    private Bitmap bitmap;
    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultpage);

        // Set Scrollview
        ScrollView mScrollView_showMessages=(ScrollView) findViewById(R.id.scrollView_showMessages);
        drawable_layout = (LinearLayout) findViewById(R.id.Drawable_area);
        line2 = (LinearLayout) findViewById(R.id.LinearLayout2);
        mScrollView_showMessages.scrollTo(0, line2.getBottom());

        // Get data from main_page
        Intent intent=getIntent();
        if(true){
            SharedPreferences sharedPreferences= getSharedPreferences("gua_data",
                    Activity.MODE_PRIVATE);

            gua[0] =sharedPreferences.getInt("shang_gua", 1);
            gua[1]  =sharedPreferences.getInt("xia_gua", 1);
            dong =sharedPreferences.getInt("dong_yao", 1);
        }else {

            gua[0] = intent.getIntExtra("shang_gua", 1);
            gua[1] = intent.getIntExtra("xia_gua", 1);
            dong = intent.getIntExtra("dong_yao", 1);
        }
       // int id= intent.getIntExtra("id",0);
     //   Log.d(TAG,"gua  "+gua[0] + " "+gua[1]);
     //   Log.d(TAG,"dong  "+dong);

        gua_id = GetGuaId(gua);
        ShowGuaText(gua_id); // id for test
        DrawGuaImage(gua_id);
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
    public int GetGuaId(int[] input_gua){
        int i;
        for(i=0;i<64;i++)
        {
           if( Arrays.equals(input_gua,gua_table[i]))
           {
               //i +=1;
             //  Log.d(TAG,"id is "+i);
               break;
           }
        }
        return i;
    }

    public void ShowGuaText(int index){
        Gua_64 gua_64;
      //  gua_64 = new Gua_64();
        GuaName = (TextView)findViewById(R.id.gua_name);
        GuaTitle = (TextView)findViewById(R.id.gua_title);
        GuaYao1 = (TextView)findViewById(R.id.yao1);
        GuaYao2 = (TextView)findViewById(R.id.yao2);
        GuaYao3 = (TextView)findViewById(R.id.yao3);
        GuaYao4 = (TextView)findViewById(R.id.yao4);
        GuaYao5 = (TextView)findViewById(R.id.yao5);
        GuaYao6 = (TextView)findViewById(R.id.yao6);
        GuaTuan = (TextView)findViewById(R.id.tuanci);
        GuaBigLike = (TextView)findViewById(R.id.biglike);
        GuaSmall1 = (TextView)findViewById(R.id.small1);
     /*   GuaSmall2 = (TextView)findViewById(R.id.small2);
        GuaSmall3 = (TextView)findViewById(R.id.small3);
        GuaSmall4 = (TextView)findViewById(R.id.small4);
        GuaSmall5 = (TextView)findViewById(R.id.small5);
        GuaSmall6 = (TextView)findViewById(R.id.small6);*/

        GuaName.setText(gua_init_able[index][0]);
        GuaTitle.setText(gua_init_able[index][1]);
        GuaYao1.setText(gua_init_able[index][2]);
        GuaYao2.setText(gua_init_able[index][3]);
        GuaYao3.setText(gua_init_able[index][4]);
        GuaYao4.setText(gua_init_able[index][5]);
        GuaYao5.setText(gua_init_able[index][6]);
        GuaYao6.setText(gua_init_able[index][7]);
        GuaTuan.setText(gua_init_able[index][8]);
        GuaBigLike.setText(gua_init_able[index][9]);
        GuaSmall1.setText(gua_init_able[index][10]);

        switch (dong)
        {
            case 1:
                GuaYao1.setTextColor(Color.rgb(255,0,0));
                break;
            case 2:
                GuaYao2.setTextColor(Color.rgb(255,0,0));
                break;
            case 3:
                GuaYao3.setTextColor(Color.rgb(255,0,0));
                break;
            case 4:
                GuaYao4.setTextColor(Color.rgb(255,0,0));
                break;
            case 5:
                GuaYao5.setTextColor(Color.rgb(255,0,0));
                break;
            case 6:
                GuaYao6.setTextColor(Color.rgb(255,0,0));
                break;
            default:
                break;


        }
      /*  GuaSmall2.setText(gua_init_able[index][11]);
        GuaSmall3.setText(gua_init_able[index][12]);
        GuaSmall4.setText(gua_init_able[index][13]);
        GuaSmall5.setText(gua_init_able[index][14]);
        GuaSmall6.setText(gua_init_able[index][15]);*/

       // Gua_image = (ImageView)findViewById(R.id.gua_image);

       // Gua_image.setImageResource(gua_image_table[index]);
    }

    public void DrawGuaImage(int index){


        Paint paint;
        int startX,startY,endX,endY,space,paint_with,double_with,double_space;

        paint = new Paint();
        paint_with =50;
        paint.setStrokeWidth(paint_with);//笔宽像素
        paint.setColor(Color.BLACK);//设置为红笔

        startX =5;
        startY =20;
        endX =115;
        endY = 20;
        space = 45;

        double_with=40;
        double_space =30;

        bitmap = Bitmap.createBitmap(120, 600, Bitmap.Config.ARGB_8888); //设置位图的宽高,bitmap为透明
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);//设置为透明，画布也是透明


        if(1==yao_talbe[index][0]) {
            canvas.drawLine(startX, startY, endX, endY, paint);
        }
        else {
            canvas.drawLine(startX, startY, startX + double_with, endY, paint);
            canvas.drawLine(startX + double_with + double_space, startY, endX, endY, paint);
        }
        if(1==yao_talbe[index][1]) {
            canvas.drawLine(startX, startY + paint_with + space, endX, endY + paint_with + space, paint);
        }
        else {
            canvas.drawLine(startX, startY + paint_with + space, startX + double_with, endY + paint_with + space, paint);
            canvas.drawLine(startX + double_with + double_space, startY + paint_with + space, endX, endY + paint_with + space, paint);
        }
        if(1==yao_talbe[index][2]) {
            canvas.drawLine(startX, startY + (paint_with + space) * 2, endX, endY + (paint_with + space) * 2, paint);
        }else {
            canvas.drawLine(startX, startY + (paint_with + space) * 2, startX + double_with, endY + (paint_with + space) * 2, paint);
            canvas.drawLine(startX + double_with + double_space, startY + (paint_with + space) * 2, endX, endY + (paint_with + space) * 2, paint);
        }
        if(1==yao_talbe[index][3]) {
            canvas.drawLine(startX, startY + (paint_with + space) * 3, endX, endY + (paint_with + space) * 3, paint);
        }else {
            canvas.drawLine(startX, startY + (paint_with + space) * 3, startX + double_with, endY + (paint_with + space) * 3, paint);
            canvas.drawLine(startX + double_with + double_space, startY + (paint_with + space) * 3, endX, endY + (paint_with + space) * 3, paint);
        }
        if(1==yao_talbe[index][4]) {
            canvas.drawLine(startX, startY + (paint_with + space) * 4, endX, endY + (paint_with + space) * 4, paint);
        }else {
            canvas.drawLine(startX, startY + (paint_with + space) * 4, startX + double_with, endY + (paint_with + space) * 4, paint);
            canvas.drawLine(startX + double_with + double_space, startY + (paint_with + space) * 4, endX, endY + (paint_with + space) * 4, paint);
        }
        if(1==yao_talbe[index][5]) {
            canvas.drawLine(startX, startY + (paint_with + space) * 5, endX, endY + (paint_with + space) * 5, paint);
        }else {
            canvas.drawLine(startX, startY + (paint_with + space) * 5, startX + double_with, endY + (paint_with + space) * 5, paint);
            canvas.drawLine(startX + double_with + double_space, startY + (paint_with + space) * 5, endX, endY + (paint_with + space) * 5, paint);
        }

        Drawable drawable = new BitmapDrawable(bitmap) ;
        drawable_layout.setBackgroundDrawable(drawable);
    }
}
