package com.example.marija.restoranstariprojekat.activiry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.marija.restoranstariprojekat.R;
import com.example.marija.restoranstariprojekat.fragments.FragmentLogin;
import com.example.marija.restoranstariprojekat.fragments.FragmentUserInfo;
import com.example.marija.restoranstariprojekat.fragments.Fragment_Add_New_Item_toMenu;
import com.example.marija.restoranstariprojekat.fragments.Fragment_Log_Out;
import com.example.marija.restoranstariprojekat.fragments.FreagmentAddOrder;
import com.example.marija.restoranstariprojekat.servis.Servis;


/**
 * Created by marija.radisavljevic on 5/16/2016.
 */
public class Host_fragment_Activity extends AppCompatActivity {

    private static boolean firstTime = true;
//    private Fragment fragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_fragment_layout);

      toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // toolbar.setNavigationIcon(R.drawable.back);
        //toolbar.setNavigationContentDescription(getResources().getString(R.string.nameOfApp));
       // toolbar.setLogo(R.drawable.help);
        toolbar.setLogoDescription(getResources().getString(R.string.Logo_description));


      //  getSupportActionBar().hide();
        Bundle extras = getIntent().getExtras();
        String fragmetnName;

        if (extras != null) {
            fragmetnName = extras.getString("name");
            Log.d("extras : ",extras.toString());
            if(fragmetnName !=null && fragmetnName.equals("FragmentUserInfo")) {
                toolbar.setSubtitle(Servis.getInstance().toolBarTypeNameSurnameString());
                FragmentManager fm = getSupportFragmentManager();
                FragmentUserInfo fragmentUserInfo = FragmentUserInfo.getInstance();
                fm.beginTransaction().replace(R.id.container_menu, fragmentUserInfo).commit();
            }else if(fragmetnName !=null &&  fragmetnName.equals("FreagmentAddOrder")){
                toolbar.setSubtitle(Servis.getInstance().toolBarTypeNameSurnameString());
                String action = extras.getString("action");
                if (action !=null &&  action.equals("plusbutton")){
                    FragmentManager fm = getSupportFragmentManager();
                    FreagmentAddOrder freagmentAddOrder = FreagmentAddOrder.getInstance();
                    Bundle bundle = new Bundle();
                    bundle.putString("action","plusbutton");
                    freagmentAddOrder.setArguments(bundle);
                    fm.beginTransaction().replace(R.id.container_menu, freagmentAddOrder).commit();
                }else{
                    if (action !=null &&  action.equals("onclick")){
                        FragmentManager fm = getSupportFragmentManager();
                        FreagmentAddOrder freagmentAddOrder = FreagmentAddOrder.getInstance();
                        Bundle bundle = new Bundle();
                        bundle.putString("rezervationId",extras.getString("rezervationId"));
                        bundle.putString("action","onclick");
                        freagmentAddOrder.setArguments(bundle);
                        fm.beginTransaction().replace(R.id.container_menu, freagmentAddOrder).commit();
                    }else{
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentLogin fragmentLogin = FragmentLogin.getInstance();
                        fm.beginTransaction().replace(R.id.container_menu, fragmentLogin).commit();
                    }
                }

            }else if (fragmetnName !=null && fragmetnName.equals("FragmentUserInfo")) {

            }else{
                FragmentManager fm = getSupportFragmentManager();
                FragmentLogin fragmentLogin = FragmentLogin.getInstance();
                fm.beginTransaction().replace(R.id.container_menu, fragmentLogin).commit();
            }
        }else
        {
            FragmentManager fm = getSupportFragmentManager();
            FragmentLogin fragmentLogin = FragmentLogin.getInstance();
            fm.beginTransaction().replace(R.id.container_menu, fragmentLogin).commit();

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


    public void callFragmentLogIn(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentLogin fragmentLogin = FragmentLogin.getInstance();
        fm.beginTransaction().replace(R.id.container_menu, fragmentLogin).commit();
    }

    public void callFragmentLogOut(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment_Log_Out fragmentLogout = Fragment_Log_Out.getInstance();
        fm.beginTransaction().replace(R.id.container_menu, fragmentLogout).commit();
    }

    public void callFragmentAddMenuItem(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment_Add_New_Item_toMenu fragment = Fragment_Add_New_Item_toMenu.getInstance();
        fm.beginTransaction().replace(R.id.container_menu, fragment).commit();
    }

    //action == onCLick treba i drugi parametart rezervationId
    //action == plusButton ne gleda drugi parametar

    public void callAddOrder(String action,String rezervationId){
        toolbar.setSubtitle(Servis.getInstance().toolBarTypeNameSurnameString());

        if (action !=null &&  action.equals("plusbutton")){
            FragmentManager fm = getSupportFragmentManager();
            FreagmentAddOrder freagmentAddOrder = FreagmentAddOrder.getInstance();
            Bundle bundle = new Bundle();
            bundle.putString("action","plusbutton");
            freagmentAddOrder.setArguments(bundle);
            fm.beginTransaction().replace(R.id.container_menu, freagmentAddOrder).commit();
        }else{
            if (action !=null &&  action.equals("onclick")){
                FragmentManager fm = getSupportFragmentManager();
                FreagmentAddOrder freagmentAddOrder = FreagmentAddOrder.getInstance();
                Bundle bundle = new Bundle();
                bundle.putString("rezervationId",rezervationId);
                bundle.putString("action","onclick");
                freagmentAddOrder.setArguments(bundle);
                fm.beginTransaction().replace(R.id.container_menu, freagmentAddOrder).commit();
            }else{
                FragmentManager fm = getSupportFragmentManager();
                FragmentLogin fragmentLogin = FragmentLogin.getInstance();
                fm.beginTransaction().replace(R.id.container_menu, fragmentLogin).commit();
            }

    }

    public  void callFragmentUserInfo(){
        toolbar.setSubtitle(Servis.getInstance().toolBarTypeNameSurnameString());
        FragmentManager fm = getSupportFragmentManager();
        FragmentUserInfo fragmentUserInfo = FragmentUserInfo.getInstance();
        fm.beginTransaction().replace(R.id.container_menu, fragmentUserInfo).commit();
    }


  /*  @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.container_menu);

        if (fragment instanceof FreagmentAddOrder){

        }else{

        }


    }*/


}
