package com.example.ujianrupi;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity  extends AppCompatActivity {

    Context mContext;

    protected Timer timer;

    final Fragment fragment1 = new ListFragment();
    final Fragment fragment2 = new ProfileFragment();

    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    private boolean mPressFirstBackKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.fl_container, fragment2,"2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.fl_container, fragment1,"1").commit();

//        Bundle bundle = new Bundle();
//        bundle.putInt("orderId", 314);
//        bundle.putInt("selected", 0);
//        fragment4.setArguments(bundle);
//        navView.setSelectedItemId(R.id.navigation_trasaksi);

//        if(getIntent().hasExtra("selectedOrder")){
//            Bundle bundle = new Bundle();
//            if(getIntent().hasExtra("orderId")){
//                bundle.putInt("orderId", getIntent().getIntExtra("orderId",0));
//            }
//            bundle.putInt("selected", getIntent().getIntExtra("selectedOrder",0));
//            fragment4.setArguments(bundle);
//            navView.setSelectedItemId(R.id.navigation_trasaksi);
//        }else{
//            navView.setSelectedItemId(R.id.navigation_home);
//        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = menuItem -> {
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                fm.beginTransaction().hide(active).show(fragment1).commit();
                active = fragment1;
                return true;
            case R.id.navigation_account:
                fm.beginTransaction().hide(active).show(fragment2).commit();
                active = fragment2;
                return true;
        }
        return false;
    };

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), getString(R.string.to_exit_press_back_button_onemore),Toast.LENGTH_SHORT).show();
        if (!mPressFirstBackKey) {
            mPressFirstBackKey = true;
            TimerTask second = new TimerTask() {
                @Override
                public void run() {
                    timer.cancel();
                    timer = null;
                    mPressFirstBackKey = false;
                }
            };
            if (timer != null) {
                timer.cancel();
                timer = null;
            }
            timer = new Timer();
            timer.schedule(second, 2000);
        } else {
            finish();
            super.onBackPressed();
        }
    }
}

