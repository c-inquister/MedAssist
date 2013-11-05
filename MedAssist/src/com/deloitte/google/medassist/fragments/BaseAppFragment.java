package com.deloitte.google.medassist.fragments;

import android.support.v4.app.Fragment;
import android.util.Log;

public class BaseAppFragment extends Fragment {

    @SuppressWarnings("unused")
    protected static String TAG = "BaseAppFragment";



    protected void showLog(String msg){
        Log.d(TAG, TAG + " :: " + msg);
    }

}
