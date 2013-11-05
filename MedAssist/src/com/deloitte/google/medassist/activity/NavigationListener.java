package com.deloitte.google.medassist.activity;

import com.deloitte.google.medassist.data.Doctor;

public interface NavigationListener {

    public void showUpdateProfile();
    public void showSearchDoctors(String query);
    public void showDoctorDetails(Doctor doc);

}
