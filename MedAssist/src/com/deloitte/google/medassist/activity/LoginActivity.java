package com.deloitte.google.medassist.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.data.User;
import com.deloitte.google.medassist.utils.Config;
import com.deloitte.google.medassist.utils.SharedPrefrenceUtil;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((TextView)findViewById(R.id.et_password)).setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    onRegisterClick(v);
                    return true;
                }
                return false;
            }
        });

        if(SharedPrefrenceUtil.isUserLoggedIn(this)){
            showMainActivity();
        }

    }

    public void onRegisterClick(View v){
        String username = ((TextView)findViewById(R.id.et_username)).getText().toString();
        String password = ((TextView)findViewById(R.id.et_password)).getText().toString();
        String type = Config.USER_TYPE_PATIENT;
        if(((username==null) || (username.isEmpty())) || ((password==null) || (password.isEmpty())) ){
            showError("Please enter valid username / password");
            return;
        }
        boolean isValid = false;

        if(username.equalsIgnoreCase(Config.USER_PATIENT_USERNAME) && password.equalsIgnoreCase(Config.USER_PATIENT_PASSWORD)) {
            type = Config.USER_TYPE_PATIENT;
        }else if(username.equalsIgnoreCase(Config.USER_DOC_USERNAME) && password.equalsIgnoreCase(Config.USER_DOC_PASSWORD)) {
            type = Config.USER_TYPE_DOC;
        }else{
            showError("Please enter valid username / password");
            return;
        }

        User u = new User(username, password, type);

        SharedPrefrenceUtil.saveLoginInfo(this, u);

        showMainActivity();

    }


    private void showError(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void showMainActivity(){
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }
}
