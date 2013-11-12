package com.deloitte.google.medassist.activity;

import java.util.Calendar;

import com.deloitte.google.medassist.data.Doctor;
import com.deloitte.google.medassist.fragments.DateDialogFragment.DateDialogFragmentListener;
import com.deloitte.google.medassist.fragments.TimePickerFragment.TimePickedListener;


public interface NavigationListener {

    public void showDoctorLandingFagrment();
    public void showPatientFagrment();
    public void showUpdateProfile();
    public void showSearchDoctors(String query);
    public void showDoctorDetails(Doctor doc);
    public void addAppointment(Doctor doc);
    public void showDatePicker(DateDialogFragmentListener listener, Calendar now);
    public void showTimePicker(TimePickedListener listener, Calendar now);
}
