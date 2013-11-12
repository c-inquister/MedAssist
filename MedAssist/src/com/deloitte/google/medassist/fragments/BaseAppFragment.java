package com.deloitte.google.medassist.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.deloitte.google.medassist.activity.NavigationListener;

public class BaseAppFragment extends Fragment {

    @SuppressWarnings("unused")
    protected static String TAG = "BaseAppFragment";

    protected NavigationListener mNavListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof NavigationListener) {
            mNavListener = (NavigationListener) activity;
        }
        else {
            throw new IllegalStateException(activity.getClass().getName() + " does not implement NavigationListener");
        }
    }

    protected void showLog(String msg){
        Log.d(TAG, TAG + " :: " + msg);
    }

}
