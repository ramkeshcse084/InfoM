 package com.nestedmango.infom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity {
     Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void next(View v){
        Intent i=new Intent(getApplication(),InstalledApps.class);
        startActivity(i);

    }
     public void nextMobInfo(View v){
         Intent i=new Intent(getApplication(),BasicInfoM.class);
         startActivity(i);

     }
}
