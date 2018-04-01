package com.nestedmango.infom;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class InstalledApps extends AppCompatActivity {
    Context context;
    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installed_apps);
        // #admob
      // MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
       // mAdView=(AdView)findViewById(R.id.adView);
       // AdRequest mAdRequest=new AdRequest.Builder().build();
      //  mAdView.loadAd(mAdRequest);

        ListView userInstalledApps = (ListView)findViewById(R.id.installed_app_list);

        List<AppList> installedApps = getInstalledApps();

        AppAdapter installedAppAdapter = new AppAdapter(this, installedApps);
        userInstalledApps.setAdapter(installedAppAdapter);

    }

    private List<AppList> getInstalledApps() {
        List<AppList> res = new ArrayList<AppList>();

        List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            if ((isSystemPackage(p) == false)) {
                String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
                String verName=p.versionName;
                String myPack=p.packageName;
                Log.e("package:",myPack);
                int versionCode=p.versionCode;
                Long instadate=p.firstInstallTime;
                Long up=p.lastUpdateTime;
                // Toast.makeText(getApplication(),verName+":"+versionCode+""+instadate+""+up,Toast.LENGTH_LONG).show();
                res.add(new AppList(appName, icon,verName,versionCode,instadate,up,myPack));



            }
        }


        return res;
    }



    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true : false;
    }
}
