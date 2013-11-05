package com.deloitte.google.medassist.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.speech.SpeechRecognizer;
import android.widget.Toast;

public class DeviceOSFeatureUtils {

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasCamera(Context c) {
        PackageManager pm = c.getPackageManager();
        boolean hasFeature = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA);

        if (hasFeature && hasGingerbread()) {
            return Camera.getNumberOfCameras() > 0;
        }

        return hasFeature;
    }

    public static boolean hasFroyo() {
        // Can use static final constants like FROYO, declared in later versions
        // of the OS since they are inlined at compile time. This is guaranteed
        // behavior.
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }

    public static boolean hasHoneycombMR2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2;
    }

    public static boolean hasICS() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    public static boolean hasICSMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasJellyBeanMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
    }

    public static boolean hasJellyBeanMR2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static boolean isHoneycombOrLaterTablet(Context context) {
        return hasHoneycomb() && isTablet(context);
    }

    public static boolean isGoogleMapsV1Available(Context c, boolean showToastOnException) {
        try {
            // check if class is available. We see crash reports in the Play Store for
            // NoClassDefFoundError, which is possible only if the maps.jar is
            // missing from the device.
            // Possibly a Custom ROM.
            Class.forName("com.google.android.maps.MapActivity");
        } catch (ClassNotFoundException e) {
            if (showToastOnException) {
                Toast.makeText(
                        c,
                        "Unable to initialize maps on your device. If this is a custom ROM, you may be missing the Google maps library.",
                        Toast.LENGTH_LONG).show();
            }

            return false;
        }

        return true;
    }

    public static boolean isLocationServicesSupported(Context c) {
        LocationManager lm = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
        return lm != null;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <Param, Progress, Result> AsyncTask<Param, Progress, Result>
        executeOnThreadPoolExecutor(AsyncTask<Param, Progress, Result> task, Param... params) {

        if (hasHoneycomb()) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        }

        return task.execute(params);
    }

    public static boolean isVoiceRecognitionSupported(Context c) {
        return SpeechRecognizer.isRecognitionAvailable(c);
    }

}
