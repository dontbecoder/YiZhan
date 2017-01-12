package com.example.administrator.yijing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

/** 
 *   a service to wait for receive message from other client
 */
public class UpdateService extends Service{
	
	ServerSocket mServerSocket = null;
    Thread mThread = null;
    private static final String TAG="huangda"; 
    private Socket mSocket;

    private String received_sql = null;

    
	public IBinder onBind(Intent intent){
		return null;
	}
	
	public void onCreate(){
		super.onCreate();

		Log.d(TAG,"onCreate---------DBServerService ");
		new Thread(){
			public void run(){

		}}.start();
	}
	
	public int onStartCommand(Intent intent, int flags, int startId){
		Log.d(TAG,"onStartCommand---------DBServerService");
		return super.onStartCommand(intent, flags, startId);
	}
	
	public void onDestroy(){
		super.onDestroy();

	}
	
	public void update_LocalDB(){		
    	Log.d(TAG,"begin to operate LocalDB in DBServerService with another thread");
    	new Thread(){
			public void run(){

			}
    	}.start();
		
	}		
}
