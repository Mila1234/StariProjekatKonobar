package com.example.marija.restoranstariprojekat.activiry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.marija.restoranstariprojekat.R;
import com.example.marija.restoranstariprojekat.fragments.Fragment_Add_New_Item_toMenu;

/**
 * Created by marija.radisavljevic on 6/6/2016.
 */
public class Activity_Add_New_Item_toMenu extends AppCompatActivity {
    private static boolean firstTime = true;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // toolbar.setNavigationIcon(R.drawable.back);
        //toolbar.setNavigationContentDescription(getResources().getString(R.string.nameOfApp));
        // toolbar.setLogo(R.drawable.help);
        toolbar.setLogoDescription(getResources().getString(R.string.Logo_description));
        toolbar.setSubtitle(com.example.marija.restoranstariprojekat.servis.Servis.getInstance().toolBarTypeNameSurnameString());
        FragmentManager fm = getSupportFragmentManager();
        Fragment_Add_New_Item_toMenu fragmentAddMenuItem = Fragment_Add_New_Item_toMenu.getInstance();
        fm.beginTransaction().replace(R.id.container_menu, fragmentAddMenuItem).commit();

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
                intent.putExtra("name", "FragmentUserInfo");
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
