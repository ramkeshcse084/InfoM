package com.nestedmango.infom;

import android.graphics.drawable.Drawable;

public class AppList {

    private String name;
    Drawable icon;
    private String verName;
    private int versionCode;
    private String packageName;
    private long instadate,up;

    public AppList(String name, Drawable icon, String verName, int versionCode, Long instadate, Long up,String packageName) {
        this.name = name;
        this.icon = icon;
        this.verName=verName;
        this.versionCode=versionCode;
        this.instadate=instadate;
        this.up=up;
        this.packageName=packageName;
    }

    public String getName() {
        return name;
    }
    public String getPackageName() {
        return packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getVerName(){
        return verName;
    }
    public int getVersionCode(){return versionCode;}
    public long getInstadate(){return instadate;}
    public long getUp(){
        return up;
    }
}
