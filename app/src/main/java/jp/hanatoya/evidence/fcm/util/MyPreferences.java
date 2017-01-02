package jp.hanatoya.evidence.fcm.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import jp.hanatoya.evidence.fcm.R;


public class MyPreferences {

    public static void writeCreds(Activity act, String username, String password){
        SharedPreferences sharedPref = act.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(act.getString(R.string.preference_username), username);
        editor.putString(act.getString(R.string.preference_password), password);
        editor.commit();
    }

    public static String[] loadCreds(Activity act){
        String[] res = new String[2];
        SharedPreferences sharedPref = act.getPreferences(Context.MODE_PRIVATE);
        String username = sharedPref.getString(act.getString(R.string.preference_username), null);
        String password = sharedPref.getString(act.getString(R.string.preference_password), null);
        if (username == null || password == null){
            return null;
        }
        res[0] = username;
        res[1] = password;
        return res;
    }

    public static void writeFcmToken(Activity act, String fcmtoken){
        SharedPreferences sharedPref = act.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(act.getString(R.string.preference_fcmtoken), fcmtoken);
        editor.commit();
    }

    public static String loadFcmToken(Activity act){
        SharedPreferences sharedPref = act.getPreferences(Context.MODE_PRIVATE);
        String fcmToken = sharedPref.getString(act.getString(R.string.preference_fcmtoken), null);
        return  fcmToken;
    }
}
