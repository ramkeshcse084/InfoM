package com.nestedmango.infom;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.TimeZone;

public class Next2Info extends AppCompatActivity {
    TextView txttype,txtTimezone,txtSerial,txtMnc,txtAndroidId,txtTimeZoneId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2_info);
        txttype=(TextView)findViewById(R.id.textViewtype);
        txtAndroidId=(TextView)findViewById(R.id.textViewAndroid_Id);
        txtMnc=(TextView)findViewById(R.id.textViewMnc);
        txtSerial=(TextView)findViewById(R.id.textViewSerial);
        txtTimezone=(TextView)findViewById(R.id.textViewtimezone);
        txtTimeZoneId=(TextView)findViewById(R.id.textViewtimeZoneId);

        String typ=Type(1);
        String tmzone=timezone(2);
        String tmzoneId=timeZoneId(3);
        String srl=Serial(4);
        int mnc=Mnc(5);
      String andId=Android_Id(6);

txttype.setText(typ);
txtTimeZoneId.setText(tmzoneId);
txtTimezone.setText(tmzone);
txtSerial.setText(srl);
txtMnc.setText(mnc+"");
txtAndroidId.setText(andId);


    }
    public void Next3(View v){
        Intent i=new Intent(getApplication(),Next3Info.class);
        startActivity(i);
    }
    public static String Type(int number){
        String type = Build.TYPE;

        return type;

    }

    public static String timezone(int number){

        TimeZone tz = TimeZone.getDefault();
        String time_zone = tz.getDisplayName(false, TimeZone.SHORT);


        return time_zone;

    }

    public static String timeZoneId(int number){
        TimeZone tz = TimeZone.getDefault();
        String time_Zone_id = tz.getID();


        return time_Zone_id;

    }

    public static String Serial(int number){
        String serial = Build.SERIAL;


        return serial;

    }

    public int Mnc(int number){

        int mnc = getResources().getConfiguration().mnc;


        return mnc;

    }

    public String Android_Id(int number){
        String android_id = Settings.Secure.getString(Next2Info.this.getContentResolver(),
                Settings.Secure.ANDROID_ID);


        return android_id;

    }

}
