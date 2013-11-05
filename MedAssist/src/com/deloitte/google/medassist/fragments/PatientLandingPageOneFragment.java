package com.deloitte.google.medassist.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.activity.NavigationListener;
import com.deloitte.google.medassist.utils.ApplicationUtils;
import com.deloitte.google.medassist.utils.StringUtils;

public class PatientLandingPageOneFragment extends BaseAppFragment {

    Button btnUpdateProfile;
    Button btnChange;
    EditText etSearch;

    NavigationListener mNavListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        TAG = "PatientLandingPageOneFragment";
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.patient_landing_page_one, container, false);
    }

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

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnUpdateProfile = (Button)view.findViewById(R.id.btn_update_profile);
        btnChange = (Button)view.findViewById(R.id.btn_change);
        etSearch = (EditText)view.findViewById(R.id.et_search);

        initListeners();
    }

    @Override
    public void onDestroyView() {
        btnUpdateProfile = null;
        btnChange = null;
        etSearch = null;
        super.onDestroyView();
    }

    private void initListeners() {
        btnUpdateProfile.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                onUpdateProfileClicked();
            }
        });

        etSearch.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == EditorInfo.IME_ACTION_DONE) || (actionId == EditorInfo.IME_ACTION_SEARCH)) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });

    }

    protected void onUpdateProfileClicked() {
        Toast.makeText(getActivity(), "Update profile is not available in POC version.", Toast.LENGTH_SHORT).show();
    }

    protected void performSearch(){
        ApplicationUtils.hideSoftKeyboard(getActivity(), etSearch);
        if(StringUtils.isNotEmpty(etSearch.getText().toString())) {
            mNavListener.showSearchDoctors(etSearch.getText().toString());
        }
    }

}
