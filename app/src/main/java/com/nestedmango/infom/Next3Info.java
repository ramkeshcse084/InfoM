package com.nestedmango.infom;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Next3Info extends AppCompatActivity {
    TextView txttype,txtTimezone,txtSerial,txtMnc,txtAndroidId,txtTimeZoneId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next3_info);
    }

    public static String Cpu_Arch(int number){
        String cpu_arch = System.getProperty("os.arch");


        return cpu_arch;

    }

    public NetworkInfo Network_info(int number){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        //   NetworkInfo network_info = network;
        return network;

    }

    public static String Cpu_Abi(int number){
        String cpu_abi = Build.CPU_ABI;
        return cpu_abi;

    }

    public static String CarrierName(int number){
        String carrierName = null;
        String carrier = carrierName;
        return carrier;

    }

    public static String Os_Code(int number){

        String os_codename = Build.BOOTLOADER;

        return os_codename;

    }

    public static String ModelName(int number){
        String model = Build.MODEL;

        return model;

    }
}
