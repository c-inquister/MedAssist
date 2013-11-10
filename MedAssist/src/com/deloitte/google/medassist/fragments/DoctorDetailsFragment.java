package com.deloitte.google.medassist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.data.Doctor;

public class DoctorDetailsFragment extends BaseAppFragment {

    public static final String BUNDLE_DOC_STRING = "doctor";
    private Doctor mDoctor;
    private TextView mName;
    private TextView mPhone1;
    private TextView mPhone2;
    private TextView mAddress;
    private TextView mTimmings;
    private Button mAppointment;
    private TextView mSpecialization;

    public static Fragment getInstance(Doctor doc) {
        DoctorDetailsFragment df = new DoctorDetailsFragment();
        Bundle bun = new Bundle();
        bun.putParcelable(BUNDLE_DOC_STRING, doc);
        df.setArguments(bun);
        return df;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mDoctor = getArguments().getParcelable(BUNDLE_DOC_STRING);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.doctordetails, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Doctor Details");
        mName = (TextView)view.findViewById(R.id.doc_name);
        mPhone1 = (TextView)view.findViewById(R.id.phone1);
        mPhone2 = (TextView)view.findViewById(R.id.phone2);
        mAddress  = (TextView)view.findViewById(R.id.address);
        mTimmings = (TextView)view.findViewById(R.id.timmings);
        mAppointment = (Button)view.findViewById(R.id.btn_appointment);
        mSpecialization = (TextView)view.findViewById(R.id.specialization);
        initData();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void initData() {
        mName.setText(mDoctor.name);
        mPhone1.setText(mDoctor.phone1);
        mPhone2.setText(mDoctor.phone2);
        mAddress.setText(mDoctor.address);
        mTimmings.setText("Timmings: "+mDoctor.timings);
        mSpecialization.setText(mDoctor.specialisation);
    }

    @Override
    public void onDestroyView() {
        mName = null;
        mPhone1 = null;
        mPhone2 = null;
        mAddress = null;
        mTimmings = null;
        mAppointment = null;
        mSpecialization = null;
        super.onDestroyView();
    }

}
