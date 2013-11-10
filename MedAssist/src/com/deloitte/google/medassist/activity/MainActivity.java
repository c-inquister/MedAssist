package com.deloitte.google.medassist.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.data.Doctor;
import com.deloitte.google.medassist.fragments.DoctorDetailsFragment;
import com.deloitte.google.medassist.fragments.DoctorSearchFragment;
import com.deloitte.google.medassist.fragments.PatientLandingPageOneFragment;

public class MainActivity extends FragmentActivity implements NavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //TODO Decide based on the some conditions which fragment to load
        showPatientFagrment();
    }

    /*
     * Toggles the fragment with the new fragment
     * 
     * @addtobackstack determines if the fragments need to be added to the backstack or no.
     */
    private void showFragment(Fragment fragment, boolean addtobackstack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.contentPane, fragment);
        if(addtobackstack){
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    /*
     * NavigationListener method callbacks
     */
    @Override
    public void showDoctorLandingFagrment() {
        //empty
    }

    @Override
    public void showPatientFagrment() {
        PatientLandingPageOneFragment pf = new PatientLandingPageOneFragment();
        showFragment(pf, false);
    }

    @Override
    public void showUpdateProfile() {
        //TODO show the update fragment.

    }

    @Override
    public void showSearchDoctors(String query) {
        showFragment(DoctorSearchFragment.getInstance(query), true);
    }

    @Override
    public void showDoctorDetails(Doctor doc) {
        showFragment(DoctorDetailsFragment.getInstance(doc), true);
    }


}
