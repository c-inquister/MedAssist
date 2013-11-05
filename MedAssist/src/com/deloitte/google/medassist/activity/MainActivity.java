package com.deloitte.google.medassist.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.data.Doctor;
import com.deloitte.google.medassist.fragments.DoctorSearchFragment;
import com.deloitte.google.medassist.fragments.PatientLandingPageOneFragment;

public class MainActivity extends FragmentActivity implements NavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPatientFagrment();
    }

    public void showPatientFagrment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        PatientLandingPageOneFragment pf = new PatientLandingPageOneFragment();

        ft.replace(R.id.contentPane, pf);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void showDoctorLandingFagrment(){
        //empty
    }

    /*
     * NavigationListener method callbacks
     */
    @Override
    public void showUpdateProfile() {
        //TODO show the update fragment.
    }

    @Override
    public void showSearchDoctors(String query) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString(DoctorSearchFragment.SEARCH_QUERY, query);

        DoctorSearchFragment pf = new DoctorSearchFragment();
        pf.setArguments(bundle);

        ft.replace(R.id.contentPane, pf);
        //ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void showDoctorDetails(Doctor doc) {

    }




}
