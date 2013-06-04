package com.example.cubicalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceivingAction extends BroadcastReceiver {
	 
	 @Override
	 public void onReceive(Context context, Intent intent) {
		 try{
		 Intent intent2 = new Intent(  context, AlarmReceiverActivity.class ); 
		 intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
		 context.startActivity(intent2); 
		 }
		 catch(Exception e)
		 {
			 Log.v("dbm"  , e.toString() ); 
		 }
	}

}
