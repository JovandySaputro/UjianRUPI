package com.example.ujianrupi;


import android.content.Context;
import android.content.SharedPreferences;

public class SessionPreferences {

    public static final String KEY_SESSION = "UjianRupi";
    public static final String KEY_ACCOUNT = "account";
    public static final String KEY_EMAIL= "email";
    public static final String KEY_NAME_CUS = "name";



    public static final String SP_SUDAH_LOGIN = "spSudahLogin";
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SessionPreferences(Context context) {
        sp = context.getSharedPreferences(KEY_SESSION, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void putSessionStr(String keySP, String value) {
        spEditor.putString(keySP, value);
        spEditor.apply();
    }

    public void putSessionInt(String keySP, Integer value) {
        spEditor.putInt(keySP, value);
        spEditor.apply();
    }
    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getValue(String keySp){
        return sp.getString(keySp,"");
    }
    public String getemail(){
        return sp.getString(KEY_EMAIL,"");
    }
    public String getNameCus(){
        return sp.getString(KEY_NAME_CUS,"");
    }


}
