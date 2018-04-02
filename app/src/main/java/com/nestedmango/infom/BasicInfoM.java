package com.nestedmango.infom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.TimeZone;

public class BasicInfoM extends AppCompatActivity {
TextView txtFingerPrint,txtOsIncre,txtHardWare,txtDevice,txtCpuCore,txtPrivateIp;
TextView txtNextPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info_m);
        txtFingerPrint=(TextView)findViewById(R.id.textViewFinger);
      txtOsIncre=(TextView)findViewById(R.id.textViewOsIncrement);
      txtHardWare=(TextView)findViewById(R.id.textViewHardware);
      txtDevice=(TextView)findViewById(R.id.textViewDevice);
      txtCpuCore=(TextView)findViewById(R.id.textViewCpu_Core);
      txtPrivateIp=(TextView)findViewById(R.id.textViewPrivate_ip);

       String p= fingerPrint(8);
       String osi=osIncrement(1);
       String hrware=Hardware(3);
       String device=Device(1);
       int cpu_Core=Cpu_Core(2);
       String priIp=Private_ip(3);

        txtFingerPrint.setText(p);
        txtCpuCore.setText(cpu_Core+"");
        txtDevice.setText(device);
        txtPrivateIp.setText(priIp);
        txtHardWare.setText(hrware);
        txtOsIncre.setText(osi);
    }

    public void Next2(View v){
        Intent i=new Intent(getApplication(),Next2Info.class);
        startActivity(i);
    }

    public static String fingerPrint(int number){

        String fingerprint = Build.FINGERPRINT;
        Log.e("finger:",fingerprint);
        return fingerprint;

    }
    public static String osIncrement(int number){

        String Os_increment = Build.VERSION.INCREMENTAL;
        Log.e("finger:",Os_increment);
        return Os_increment;

    }


    public static String Hardware(int number){
        String hardware = Build.HARDWARE;


        return hardware;

    }
    public static String Device(int number){

        String device = Build.DEVICE;

        return device;

    }
    public static int Cpu_Core(int number){

        int cpu_core = Runtime.getRuntime().availableProcessors();

        return cpu_core;

    }

    public String Private_ip(int number){

        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        String private_ip = ip;

        return private_ip;

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
        String android_id = Settings.Secure.getString(BasicInfoM.this.getContentResolver(),
                Settings.Secure.ANDROID_ID);


        return android_id;

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
    private String ReadCPUinfo() {
        {
            ProcessBuilder cmd;
            String result = "";


            try {
                String[] args = {"/system/bin/cat", "/proc/cpuinfo"};
                cmd = new ProcessBuilder(args);

                Process process = cmd.start();
                InputStream in = process.getInputStream();
                byte[] re = new byte[1024];
                while (in.read(re) != -1) {
                    System.out.println(new String(re));
                    result = result + new String(re);
                }
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return result;
        }
    }
    public String Processor(int number){

        String processor = ReadCPUinfo().toString();
        return processor;

    }

    public static String LocalTimeZone(int number){
        TimeZone tz = TimeZone.getDefault();
        String local_tz_name = tz.getID();


        return local_tz_name;

    }

    @SuppressLint("MissingPermission")
    public String imei(int number){

        String Imei = null;
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        Imei = telephonyManager.getDeviceId();
        return Imei;

    }

}
