package com.example.marija.restoranstariprojekat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marija.restoranstariprojekat.R;
import com.example.marija.restoranstariprojekat.activiry.Activity_Log_Out;
import com.example.marija.restoranstariprojekat.activiry.Host_fragment_Activity;
import com.example.marija.restoranstariprojekat.adapters.MyCustomAdatperForTheList;
import com.example.marija.restoranstariprojekat.data.UserData;
import com.example.marija.restoranstariprojekat.database.Rezervation;
import com.example.marija.restoranstariprojekat.servis.Servis;

import java.util.ArrayList;

/**
 * Created by marija on 24.1.17.
 */

public class Fragment_Log_Out extends Fragment {


    private static Fragment_Log_Out instance;
    public static Fragment_Log_Out getInstance() {


        if(instance == null){
            return new Fragment_Log_Out();
        }else return instance;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.activity_logout, container, false);


        //Toolbar toolbar = (Toolbar) mRoot.findViewById(R.id.toolbar);
        //((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        // toolbar.setNavigationIcon(R.drawable.back);
        //toolbar.setNavigationContentDescription(getResources().getString(R.string.nameOfApp));
        // toolbar.setLogo(R.drawable.help);
        //toolbar.setLogoDescription(getResources().getString(R.string.Logo_description));
        //toolbar.setSubtitle(Servis.getInstance().toolBarTypeNameSurnameString());

        Button ok =  (Button) mRoot.findViewById(R.id.ok_button);
        assert ok != null;
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Odjava", Toast.LENGTH_LONG).show();

                Intent intent2 = new Intent(getActivity().getApplicationContext(), Host_fragment_Activity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().getApplicationContext().startActivity(intent2);

            }
        });
        Button cancel =  (Button) mRoot.findViewById(R.id.cancel_button);

        assert cancel != null;
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Odustajem", Toast.LENGTH_LONG).show();

                getActivity().onBackPressed();


            }
        });


        return mRoot;
    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_logout).setVisible(true);
        menu.findItem(R.id.action_user_info).setVisible(true);
        menu.findItem(R.id.action_add).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }

}
