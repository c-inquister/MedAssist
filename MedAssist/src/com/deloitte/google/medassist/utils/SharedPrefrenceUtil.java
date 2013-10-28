package com.deloitte.google.medassist.utils;

import com.deloitte.google.medassist.data.User;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrenceUtil {

	public static void saveLoginInfo(Context c, User user){
		SharedPreferences prefs = c.getSharedPreferences(
			      c.getPackageName(), Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("app_user_info", user.getUserInfoToSaveToSharedPref());
		editor.putBoolean("isUserLogedIn", true);
		editor.commit();
	}
	
	public static User getUserInfoSaved(Context c) throws NullPointerException{
		SharedPreferences prefs = c.getSharedPreferences(
			      c.getPackageName(), Context.MODE_PRIVATE);
		
		String data = prefs.getString("app_user_info", "");
		if(data.isEmpty()){
			throw new NullPointerException();
		}
		return new User(data);
	}
	
	public static boolean isUserLoggedIn(Context c){
		SharedPreferences prefs = c.getSharedPreferences(
			      c.getPackageName(), Context.MODE_PRIVATE);
		return prefs.getBoolean("isUserLogedIn", false);
	}
	
}
