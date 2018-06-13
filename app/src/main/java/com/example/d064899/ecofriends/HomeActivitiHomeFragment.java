package com.example.d064899.ecofriends;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;


public class HomeActivitiHomeFragment extends Fragment implements View.OnClickListener {

    private ImageButton ibtn_scan;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_activiti_home_tab, container, false);

        ibtn_scan = view.findViewById(R.id.ibtn_scan);
        ibtn_scan.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        /*
         * Checks if scan button (here: ibtn_scan) was pressed
         */
        if(view.getId() == R.id.ibtn_scan) {
            // Instantiate an object from IntentIntegrator to have an instance to handle the can
            IntentIntegrator scanIntegrator = new IntentIntegrator(getActivity());
            // start scan; user will be asked to install "Barcode Scanner" app if user has not done this yet
            scanIntegrator.initiateScan();
        }
    }

}
