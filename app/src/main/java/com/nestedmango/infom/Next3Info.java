package com.nestedmango.infom;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Next3Info extends AppCompatActivity {
    TextView txtCpu_Arch,txtNetInfo,txtCpu_Abi,txtCarrierName,txtOsCode,txtModelName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next3_info);
        txtCpu_Arch=(TextView)findViewById(R.id.textViewCpu_Arch);
        txtNetInfo=(TextView)findViewById(R.id.textViewNextInfo);
        txtCpu_Abi=(TextView)findViewById(R.id.textViewalCpu_Abi);
        txtCarrierName=(TextView)findViewById(R.id.textViewCarrierName);
        txtOsCode=(TextView)findViewById(R.id.textViewOs_Code);
        txtModelName=(TextView)findViewById(R.id.textViewModelName);

    }
    public void Next4(View v){
        Intent i=new Intent(getApplication(),Next3Info.class);
        startActivity(i);
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
