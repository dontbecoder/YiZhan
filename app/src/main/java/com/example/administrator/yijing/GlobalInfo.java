package com.example.administrator.yijing;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class GlobalInfo extends Application{
	private static final String TAG = "huangda";

	public static final String IP_NULL = "0.0.0.0";
	public static final String PACKAGE_NAME = "com.example.administrator.yijing";

	
	public String getIp(){  
	    WifiManager wm=(WifiManager)getSystemService(Context.WIFI_SERVICE);  

	    if(!wm.isWifiEnabled())  
	        wm.setWifiEnabled(true);  
	    WifiInfo wi=wm.getConnectionInfo();  

	    int ipAdd=wi.getIpAddress();  

	    String ip=intToIp(ipAdd);  
	    return ip;  
	} 
	private String intToIp(int i) {  
	    return (i & 0xFF ) + "." +  
	    ((i >> 8 ) & 0xFF) + "." +  
	    ((i >> 16 ) & 0xFF) + "." +  
	    ( i >> 24 & 0xFF) ;  
	}
	
	public int getVersionCode(Context context)  
	{  
	    int versionCode = 0;  
	    try  
	    {  
	        versionCode = context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0).versionCode;  
	    } catch (NameNotFoundException e)  
	    {  
	        e.printStackTrace();  
	    }  
	    return versionCode;  
	}  
	
	public String getVersionName(Context context)
	{
		String versionName = null;  
	    try  
	    {    
	    	versionName = context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0).versionName;  
	    } catch (NameNotFoundException e)  
	    {  
	        e.printStackTrace();  
	    }  
	    return versionName;  
	}

	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}



	public static boolean isMobileConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mMobileNetworkInfo = mConnectivityManager
					.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			if (mMobileNetworkInfo != null) {
				return mMobileNetworkInfo.isAvailable();
			}
		}
		return false;
	}



	public static int getConnectedType(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
				return mNetworkInfo.getType();
			}
		}
		return -1;
	}
}
