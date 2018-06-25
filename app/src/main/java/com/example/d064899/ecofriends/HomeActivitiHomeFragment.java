package com.example.d064899.ecofriends;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;


public class HomeActivitiHomeFragment extends Fragment implements View.OnClickListener {

    private TabLayout tabLayout;

    private ImageButton ibtn_shop;
    private ImageButton ibtn_news;
    private ImageButton ibtn_scan;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_activiti_home_tab, container, false);

        ibtn_shop = view.findViewById(R.id.ibtn_shop);
        ibtn_shop.setOnClickListener(this);
        ibtn_news = view.findViewById(R.id.ibtn_news);
        ibtn_news.setOnClickListener(this);
        ibtn_scan = view.findViewById(R.id.ibtn_scan);
        ibtn_scan.setOnClickListener(this);

        return view;
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ibtn_shop:
                tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
                TabLayout.Tab tab_shop = tabLayout.getTabAt(1);
                tab_shop.select();
                break;
            case R.id.ibtn_news:
                tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
                TabLayout.Tab tab_news = tabLayout.getTabAt(2);
                tab_news.select();
                break;
            case R.id.ibtn_scan:
                // Instantiate an object from IntentIntegrator to have an instance to handle the can
                IntentIntegrator scanIntegrator = new IntentIntegrator(getActivity());
                // start scan; user will be asked to install "Barcode Scanner" app if user has not done this yet
                scanIntegrator.initiateScan();
                break;
        }
    }

}
