package com.example.cubicalarm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DateFormat dateFormat = new SimpleDateFormat( "MM/dd/yyyy HH:mm:ss" ); 
        
        Calendar cal = Calendar.getInstance(); 
        
        Log.v("dbm" , "MainActivity on Start: " + dateFormat.format(cal.getTime()) ); 
        ArrayList<Date> arrayList = new ArrayList<Date>(); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add(cal.getTime()); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add(cal.getTime()); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add(cal.getTime()); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add(cal.getTime()); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add(cal.getTime()); 
        
        
        
        Intent intent = new Intent(this, AlarmReceivingAction.class);
        intent.putExtra("alarm_message", "O'Doyle Rules!");
        // In reality, you would want to have a static variable for the request code instead of 192837
        PendingIntent sender = PendingIntent.getBroadcast(this, 192837, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        
        // Get the AlarmManager service
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);
        
        Log.v("dbm" , "Main Activity Clocking: " + dateFormat.format(cal.getTime()) ); 
    }
    
    public void setAlarm( ArrayList<Date> timeList )
    {
    	Calendar cal = Calendar.getInstance(); 
    	
//    	Date closestTime;  
//    	for(int i = 0; i < timeList.size(); i++)
//    	{
//    		if( closestTime > Math.abs(  - timeList.get(i)  ) )
//    		{
//    			
//    		}
//    	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
