package com.example.marija.restoranstariprojekat.activiry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.marija.restoranstariprojekat.R;
import com.example.marija.restoranstariprojekat.fragments.Fragment_Log_Out;
import com.example.marija.restoranstariprojekat.servis.Servis;

/**
 * Created by marija.radisavljevic on 6/8/2016.
 */
public class Activity_Log_Out extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // toolbar.setNavigationIcon(R.drawable.back);
        //toolbar.setNavigationContentDescription(getResources().getString(R.string.nameOfApp));
        // toolbar.setLogo(R.drawable.help);
        toolbar.setLogoDescription(getResources().getString(R.string.Logo_description));
        toolbar.setSubtitle(Servis.getInstance().toolBarTypeNameSurnameString());

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            //ako nesto zelim da prosldim fragmentu
            // arguments.putString(Fragment_Add_Menu_Item.ARG_ITEM_ID,



            Fragment fragment = new Fragment_Log_Out();
            fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction().add(R.id.container_menu, fragment).commit();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manu_gui, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_user_info:
                Intent intent = new Intent(getApplicationContext(), Host_fragment_Activity.class);
                intent.putExtra("name","FragmentUserInfo");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
                return true;
            case R.id.action_logout:
                //call popup win for logout
                intent = new Intent(getApplicationContext(), Activity_Log_Out.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
                return true;
            case R.id.action_add:

                Intent intent2 = new Intent(getApplicationContext(), Host_fragment_Activity.class);
                intent2.putExtra("name", "FreagmentAddOrder");
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }


}
