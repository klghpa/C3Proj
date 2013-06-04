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
	
	public ArrayList<Calendar> arrayList; 
	public AlarmManager am; 
	public PendingIntent sender; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DateFormat dateFormat = new SimpleDateFormat( "MM/dd/yyyy HH:mm:ss" ); 
        
        Calendar cal = Calendar.getInstance(); 
        
        Log.v("dbm" , "MainActivity on Start: " + dateFormat.format(cal.getTime()) ); 
        arrayList = new ArrayList<Calendar>(); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add((Calendar)cal.clone()); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add((Calendar)cal.clone()); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add((Calendar)cal.clone()); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add((Calendar)cal.clone()); 
        cal.add(Calendar.SECOND, 5); 
        arrayList.add((Calendar)cal.clone()); 
        
        Intent intent = new Intent(this, AlarmReceivingAction.class);
//        intent.putExtra("alarm_message", "O'Doyle Rules!");
        // In reality, you would want to have a static variable for the request code instead of 192837
        sender = PendingIntent.getBroadcast(this, 192837, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        
        // Get the AlarmManager service
        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);
        
//        setAlarm(am, sender, arrayList); 
        
    }
    
    public void setAlarm( AlarmManager alarmManager , PendingIntent sender , ArrayList<Calendar> timeList  )
    {
    	Calendar cal = Calendar.getInstance(); 
    	
    	int bestPos = 0; 
    	long closestTime = cal.getTimeInMillis() - timeList.get(bestPos).getTimeInMillis(); 
    	for(int i = 1; i < timeList.size(); i++)
    	{
    		Calendar currentCal = timeList.get(i); 
    		if( closestTime > Math.abs( cal.getTimeInMillis() - currentCal.getTimeInMillis()   ) )
    		{
    			bestPos = i; 
    			closestTime = cal.getTimeInMillis() - currentCal.getTimeInMillis(); 
    		}
    	}
//    	alarmManager.set(AlarmManager.RTC_WAKEUP , cal.getTimeInMillis() , sender ); 
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	menu.add("Create Alarm"); 
    	menu.add("Options"); 
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
