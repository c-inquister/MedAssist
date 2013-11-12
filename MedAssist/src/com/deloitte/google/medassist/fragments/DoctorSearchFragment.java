package com.deloitte.google.medassist.fragments;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.adapter.DoctorListAdapter;
import com.deloitte.google.medassist.adapter.DoctorListAdapter.DoctorClickListener;
import com.deloitte.google.medassist.data.Doctor;

@SuppressLint("ValidFragment")
public class DoctorSearchFragment extends BaseAppFragment implements DoctorClickListener{

    public static final String SEARCH_QUERY = "search_query";

    ListView docSearchListView;
    ArrayList<Doctor> mDoctors;
    String mSearchQery;

    public static Fragment getInstance(String searchQuery) {
        Bundle bundle = new Bundle();
        bundle.putString(DoctorSearchFragment.SEARCH_QUERY, searchQuery);

        DoctorSearchFragment pf = new DoctorSearchFragment();
        pf.setArguments(bundle);

        return pf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        TAG = "DoctorSearchFragment";
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.doctor_search_page, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        docSearchListView = (ListView)view.findViewById(R.id.doc_search_listview);
        docSearchListView.setAdapter(getListAdapter());
        docSearchListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                showLog("onItemClick: " + position);
                if(mNavListener != null){
                    mNavListener.showDoctorDetails(mDoctors.get(position));
                }
            }
        });


        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    public void onDestroyView() {
        docSearchListView = null;
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        // TODO associate the list adapter here

        super.onResume();
    }

    private DoctorListAdapter getListAdapter() {
        mDoctors = new ArrayList<Doctor>();

        mDoctors.add(new Doctor("1","Dr. SUHAS C BENDRE","Vikhroli","Cardio Thorasic And Vascular","91","91","Vikhroli","2pm to 4pm","MTWTFSS"));
        mDoctors.add(new Doctor("2","Dr. AMIT BHARAT SANGHVI ","Powai","Cardiology","91","92","Powai","9am to 12pm ","MTWTFSS"));
        mDoctors.add(new Doctor("3","Dr. DILIP V MAYDEO ","Mulund","Chest Physician","91","93","Mulund","9am to 11am ","MTWTFSS"));
        mDoctors.add(new Doctor("4","Dr. BHARTI V KHANDEKAR ","Lower Parel","Cleft Clinic","91","94","Lower Parel","12pm to 2pm ","MTWTFSS"));
        mDoctors.add(new Doctor("5","Dr. NAZREEN SHAIKH ","Andheri","Clinical Psychology","91","95","Andheri","2pm to 5pm","MTWTFSS"));
        mDoctors.add(new Doctor("6","Dr. JEEVAN S SHETTY","Powai","Dental","91","96","Powai","1pm to 2pm & 5pm to 7pm","MTWTFSS"));
        mDoctors.add(new Doctor("7","Dr. HARIHARAN KRISHANAN","Borivali","Dermatology","91","97","Borivali","11am to 12pm ","MTWTFSS"));
        mDoctors.add(new Doctor("8","Dr. ABHIJIT ASHOK JADHAV ","Ghatkopar","Diabetology","91","98","Ghatkopar","3pm to 5pm","MTWTFSS"));
        mDoctors.add(new Doctor("9","Dr. JITEN CHOWDHRY ","Dadar","General Surgery","91","99","Dadar","9am to 2pm","MTWTFSS"));
        mDoctors.add(new Doctor("10","Dr. ADITI SINGHI ","Dadar","Gynaecology","91","100","Dadar","6pm to 7pm","MTWTFSS"));

        return new DoctorListAdapter(getActivity(), mDoctors, this);
    }

    @Override
    public void onCallClicked(int position) {
        Doctor doc = mDoctors.get(position);
        //TODO initiate the call
        Log.d(TAG, doc.name);
    }

    @Override
    public void onItemClicked(int position) {
        if(mNavListener!=null){
            mNavListener.showDoctorDetails(mDoctors.get(position));
        }
    }


}
