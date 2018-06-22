package com.example.d064899.ecofriends;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;

public class HomeActivitiCamFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_activiti_cam_tab, container, false);
        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Instantiate an object from IntentIntegrator to have an instance to handle the can
//        IntentIntegrator scanIntegrator = new IntentIntegrator(getActivity());
//        // start scan; user will be asked to install "Barcode Scanner" app if user has not done this yet
//        scanIntegrator.initiateScan();
//    }

}
