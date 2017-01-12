package com.example.administrator.yijing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateManager {
    private TextView progress_percent;
	private static final String TAG = "huangda";
	private static final String APK_NAME="jap.apk";
	private static final String APK_URL_1="http://nb.baidupcs.com/file/05755a97facc716dc0bf3108ec83bf43?fid=1731004582-250528-926108065679376&time=1413861078&sign=FDTAXER-DCb740ccc5511e5e8fedcff06b081203-L7MPAkxFAyqkdpb1tRYNbduexos%3D&to=nbb&fm=Nin,B,T,t&newver=1&newfm=1&flow_ver=3&expires=8h&rt=sh&r=354337232&mlogid=857733694&vuk=1731004582&vbdid=1228984080&fn=MyAndroid.apk";
	private static final String APK_URL_2="http://192.168.10.63/JAP.apk";//"http://nj.baidupcs.com/file/e863231cdec9b0595c26cd2012dd076a?fid=1731004582-250528-632136427792124&time=1413859580&sign=FDTAXER-DCb740ccc5511e5e8fedcff06b081203-RJYHnQEle38cX9rq%2F82ysO3iPlU%3D&to=nb&fm=Bei,B,T,t&newver=1&newfm=1&flow_ver=3&expires=8h&rt=sh&r=648453071&mlogid=857402935&vuk=1731004582&vbdid=1228984080&fn=JAP.apk";
	
	private static final String APK_DOWNLOAD_DIR = "my_test_download";
	
	/* 下载中 */
    public static final int DOWNLOAD = 1;  
    /* 下载结束 */
    public static final int DOWNLOAD_FINISH = 2;
    
    public static final int URL_ERROR = 3;
    public static final int IO_ERROR = 4;
    /* 保存解析的XML信息 */
    private HashMap<String, String> mHashMap;  
    /* 下载保存路径 */  
    private String mSavePath;  
    /* 记录进度条数量 */  
    private int progress;  
    /* 是否取消更新 */
    private boolean cancelUpdate = false;  
  
    private Context mContext;  
    /* 更新进度条 */  
    private ProgressBar mProgress;  
    private Dialog mDownloadDialog;  
    
    private Handler mHandler = new Handler()  
    {  
        public void handleMessage(Message msg)  
        {  
            switch (msg.what)  
            {  
            // 正在下载  
            case DOWNLOAD:  
                // 设置进度条位置  
                mProgress.setProgress(progress);
                progress_percent.setText(String.valueOf(progress)+"%");
                break;  
            case DOWNLOAD_FINISH:  
                // 安装文件  
                installApk();  
                break;
            case URL_ERROR:
            	new MyDialog(mContext,"error","MalformedURLException","ok",null,null,null);
            	break;
            case IO_ERROR:
            	new MyDialog(mContext,"error","IOException","ok",null,null,null);
            	break;
            default:  
                break;  
            }  
        };  
    };  
  
    public UpdateManager(Context context)  
    {  
        this.mContext = context;  
    }  
  
    /** 
     * 检测软件更新 
     */  
    public void checkUpdate()  
    {  
        if (isUpdate())
        {  
            // 显示提示对话框  
            showNoticeDialog();  
        } else  
        {  
            Toast.makeText(mContext, R.string.soft_update_no, Toast.LENGTH_LONG).show();  
        }  
    }  
  
    /** 
     * 检查软件是否有更新版本 
     *  
     * @return 
     */
    /**
    private boolean isUpdate() 
    {
    	return true;
    }
    */
    private boolean isUpdate()  
    {  
    	Log.d(TAG,"isUpdate() ");
    	//mHashMap.put("url", value);
        // 获取当前软件版本  
        int versionCode = 2;//getVersionCode(mContext);  
        // 把version.xml放到网络上，然后获取文件信息  
        InputStream inStream = ParseXmlService.class.getClassLoader().getResourceAsStream("version.xml"); 
        Log.d(TAG,"InputStream) " + inStream);
        // 解析XML文件。 由于XML文件比较小，因此使用DOM方式进行解析  
        ParseXmlService service = new ParseXmlService();  
        try  
        {  
            mHashMap = service.parseXml(inStream);  
            Log.d(TAG,"mHashMap is "+mHashMap);
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        if (null != mHashMap)  
        {  
            int serviceCode = Integer.valueOf(mHashMap.get("version"));  
            // 版本判断  
            if (serviceCode > versionCode)  
            {  
                return true;  
            }  
        }  
        return false;
    }  
 
/** 
 * 获取软件版本号 
 *  
 * @param context 
 * @return 
 */  
    /**
private int getVersionCode(Context context)  
{  
    int versionCode = 0;  
    try  
    {  
        // 获取软件版本号，对应AndroidManifest.xml下android:versionCode  
        versionCode = context.getPackageManager().getPackageInfo("com.szy.update", 0).versionCode;  
    } catch (NameNotFoundException e)  
    {  
        e.printStackTrace();  
    }  
    return versionCode;  
}  
  */
    /** 
     * 显示软件更新对话框 
     */  
    
    private void showNoticeDialog()  
    {  
    	Log.d(TAG,"showNoticeDialog() begin");
        // 构造对话框  
        AlertDialog.Builder builder = new Builder(mContext);  
        builder.setTitle(R.string.soft_update_title);  
        builder.setMessage(R.string.soft_update_info);  
        // 更新  
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener()
        {  
            @Override  
            public void onClick(DialogInterface dialog, int which)  
            {  
                dialog.dismiss();  
                // 显示下载对话框  
                Log.d(TAG,"update now");
                showDownloadDialog();  
            }  
        });  
        // 稍后更新  
        builder.setNegativeButton(R.string.soft_update_cancel, new DialogInterface.OnClickListener()
        {  
            @Override  
            public void onClick(DialogInterface dialog, int which)  
            {  
            	Log.d(TAG,"update later");
                dialog.dismiss();  
            }  
        });  
        Dialog noticeDialog = builder.create();  
        noticeDialog.show(); 
        
    }  
  
    /** 
     * 显示软件下载对话框 
     */  
    
    private void showDownloadDialog()  
    {  
    	Log.d(TAG,"showDownloadDialog()");
        // 构造软件下载对话框  
        AlertDialog.Builder builder = new Builder(mContext);  
        builder.setTitle(R.string.soft_updating);  
        // 给下载对话框增加进度条  
        final LayoutInflater inflater = LayoutInflater.from(mContext);  
        View v = inflater.inflate(R.layout.softupdate_progress, null);  
        mProgress = (ProgressBar) v.findViewById(R.id.update_progress);
        progress_percent=(TextView)v.findViewById(R.id.progressbar_percent);
        builder.setView(v);  
        // 取消更新  
        builder.setNegativeButton(R.string.soft_update_cancel, new DialogInterface.OnClickListener()  
        {  
            @Override  
            public void onClick(DialogInterface dialog, int which)  
            {  
                dialog.dismiss();  
                // 设置取消状态  
                cancelUpdate = true;  
            }  
        });  
        mDownloadDialog = builder.create();  
        mDownloadDialog.show();  
        
        
        downloadApk();
    }  
 
    /** 
     * 下载apk文件 
     */  
    private void downloadApk()  
    {


    	mHashMap = new HashMap<String, String>();
    	//mHashMap.put("url",APK_URL_1);
    	mHashMap.put("url",APK_URL_2);
    	mHashMap.put("name",APK_NAME);
    	
    	if(!GlobalInfo.isNetworkConnected(mContext)){
    		Log.d(TAG,"please turn on the network!");
    		mDownloadDialog.cancel();
    		new MyDialog(mContext,"error","please turn on the network","ok",null,null,null);
    		return;
    	}
    	// 启动新线程下载软件  
    	Log.d(TAG,"begin to download...");
        new downloadApkThread().start();  
    }  
  
    /** 
     * 下载文件线程 

     */  
    private class downloadApkThread extends Thread  
    {


        @Override  
        public void run()  
        {  
            try  
            {  
                // 判断SD卡是否存在，并且是否具有读写权限  
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))  
                {  
                	Log.d(TAG,"run thread here...");
                    // 获得存储卡的路径  
                    String sdpath = Environment.getExternalStorageDirectory() + "/";  
                    mSavePath = sdpath + APK_DOWNLOAD_DIR; 
                    Log.d(TAG,"mSavePath is "+ mSavePath);
                    Log.d(TAG,"mHashMap.get('url') is "+ mHashMap.get("url"));
                    URL url = new URL(mHashMap.get("url"));  
                    // 创建连接  
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
                    conn.connect();  
                    // 获取文件大小  
                    int length = conn.getContentLength();
                    Log.d(TAG,"length is "+ length);
                    // 创建输入流  
                    InputStream is = conn.getInputStream();  
                    Log.d(TAG,"InputStream is "+ is);
                    File file = new File(mSavePath);  
                    // 判断文件目录是否存在  
                    if (!file.exists())  
                    {  
                        file.mkdir();  
                    }  
                    File apkFile = new File(mSavePath, mHashMap.get("name"));  
                    Log.d(TAG,"begin to  fos");
                    FileOutputStream fos = new FileOutputStream(apkFile);  
                    int count = 0;  
                    // 缓存  
                    byte buf[] = new byte[1024];  
                    // 写入到文件中  
                    do  
                    {  
                        int numread = is.read(buf);  
                        count += numread;  
                        // 计算进度条位置  
                        progress = (int) (((float) count / length) * 100);  
                        // 更新进度

                        mHandler.sendEmptyMessage(DOWNLOAD);  
                        if (numread <= 0)  
                        {  
                            // 下载完成  
                            mHandler.sendEmptyMessage(DOWNLOAD_FINISH);  
                            break;  
                        }  
                        // 写入文件  
                        fos.write(buf, 0, numread);  
                    } while (!cancelUpdate);// 点击取消就停止下载.  
                    fos.close();  
                    is.close();  
                }  
            } catch (MalformedURLException e)  
            {  
            	Log.d(TAG,"catch MalformedURLException here ");
            	//new MyDialog(mContext,"error","MalformedURLException","ok",null,null,null);
            	mHandler.sendEmptyMessage(URL_ERROR);
                e.printStackTrace();  
            } catch (IOException e)  
            {  
            	Log.d(TAG,"catch IOException here ");
            	mHandler.sendEmptyMessage(IO_ERROR);
            	//new MyDialog(mContext,"error","IOException","ok",null,null,null);
                e.printStackTrace();  
            }  
            // 取消下载对话框显示  
            mDownloadDialog.dismiss();  
        }  
    };  
  
    /** 
     * 安装APK文件 
     */  
    void installApk()  
    {

        File apkfile = new File(mSavePath, mHashMap.get("name"));  
        if (!apkfile.exists())  
        {  
            return;  
        }  
        // 通过Intent安装APK文件  
        Intent i = new Intent(Intent.ACTION_VIEW);  
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");  
        mContext.startActivity(i);  
    }  
    
    void setProgressBar()
    {
    	 mProgress.setProgress(progress);
    }
}
