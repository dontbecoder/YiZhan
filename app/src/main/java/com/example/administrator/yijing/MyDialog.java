package com.example.administrator.yijing;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;

public class MyDialog {

	//private String title = "title";
	//private String msg = "message";
	//private String LeftBtName ="OK";
	//private String RightBtName ="Cancel";
	//private DialogInterface.OnClickListener LeftBtlistener = null;
	//private DialogInterface.OnClickListener RightBtlistener = null;
	
	public MyDialog(Context context,String title,String msg,String LeftBtName,
			DialogInterface.OnClickListener LeftBtlistener,
			String RightBtName,DialogInterface.OnClickListener RightBtlistener){
		
		 AlertDialog.Builder builder  = new Builder(context);
 		 builder.setTitle(title ) ;
 		 builder.setMessage(msg ) ;
 		 builder.setPositiveButton(LeftBtName ,  LeftBtlistener );
 		 builder.setNegativeButton(RightBtName ,  RightBtlistener );
 		 builder.show();
	}
}
