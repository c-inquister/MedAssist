package com.deloitte.google.medassist.fragments;

import java.util.Calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.data.Doctor;
import com.deloitte.google.medassist.fragments.DateDialogFragment.DateDialogFragmentListener;
import com.deloitte.google.medassist.fragments.TimePickerFragment.TimePickedListener;


public class AddAppointmentFragment extends BaseAppFragment {

    Doctor mDoc;
    public static final String BUNDLE_DOC_STRING = "doctor";

    EditText mDocName;
    TextView mAddress;
    TextView mDate;
    TextView mTime;
    CheckBox mReminder;
    Button mSave;
    Calendar now;

    public static Fragment getInstance(Doctor doc) {
        AddAppointmentFragment df = new AddAppointmentFragment();
        Bundle bun = new Bundle();
        bun.putParcelable(BUNDLE_DOC_STRING, doc);
        df.setArguments(bun);
        return df;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        mDoc = getArguments().getParcelable(BUNDLE_DOC_STRING);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_appointment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDocName = (EditText)view.findViewById(R.id.etDocName);
        mAddress = (TextView)view.findViewById(R.id.tvAddress);
        mDate = (TextView)view.findViewById(R.id.dateView);
        mTime = (TextView)view.findViewById(R.id.timeView);
        mReminder = (CheckBox)view.findViewById(R.id.checkboxReminder);
        mSave = (Button)view.findViewById(R.id.btSaveAppointment);

        initData();
    }

    private void initData() {
        mDocName.setText(mDoc.name);
        mAddress.setText(mDoc.address);
        now = Calendar.getInstance();
        mDate.setText(String.valueOf(now.get(Calendar.MONTH)+1)+"-"+String.valueOf(now.get(Calendar.DAY_OF_MONTH))+"-"+String.valueOf(now.get(Calendar.YEAR)));
        mDate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mNavListener.showDatePicker(new DateDialogFragmentListener() {

                    @Override
                    public void updateChangedDate(int year, int month, int day) {
                        now.set(year, month, day);
                    }
                }, now);
            }
        });

        mTime.setText(String.valueOf(now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE)));
        mTime.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mNavListener.showTimePicker(new TimePickedListener() {

                    @Override
                    public void onTimePicked(Calendar time) {
                        now.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY));
                        now.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
                    }
                }, now);
            }
        });
    }

    @Override
    public void onDestroyView() {
        mDocName = null;
        mAddress = null;
        mDate = null;
        mTime = null;
        mReminder = null;
        mSave = null;
        now = null;
        super.onDestroyView();
    }


}
