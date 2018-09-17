package com.example.dc.pushnotificationsfirebasecm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFireBaseInstanceIDService extends FirebaseInstanceIdService{

    private static final String TAG = "MyFireBaseInstanceIDSer";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "new Token " +refreshedToken);


        //you can save the token into third party server to do anything you want

    }
}
