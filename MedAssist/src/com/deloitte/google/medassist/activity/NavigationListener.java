package com.deloitte.google.medassist.activity;

import com.deloitte.google.medassist.data.Doctor;

public interface NavigationListener {

    public void showDoctorLandingFagrment();
    public void showPatientFagrment();
    public void showUpdateProfile();
    public void showSearchDoctors(String query);
    public void showDoctorDetails(Doctor doc);

}
