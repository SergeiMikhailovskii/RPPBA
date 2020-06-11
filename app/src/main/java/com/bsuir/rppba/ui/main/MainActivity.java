package com.bsuir.rppba.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.bsuir.rppba.R;
import com.bsuir.rppba.ui.bills.BillsFragment;
import com.bsuir.rppba.ui.manufacture.ManufactureFragment;
import com.bsuir.rppba.ui.materials.MaterialFragment;
import com.bsuir.rppba.ui.products.ProductFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        FragmentTransaction startTransaction = getSupportFragmentManager().beginTransaction();
        MaterialFragment materialFragment = new MaterialFragment();
        startTransaction.add(R.id.fragment_layout, materialFragment);
        startTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        startTransaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            Fragment fragment = null;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.materials:
                    menuItem.setChecked(true);
                    fragment = new MaterialFragment();
                    break;
                case R.id.products:
                    menuItem.setChecked(true);
                    fragment = new ProductFragment();
                    break;
                case R.id.bills:
                    menuItem.setChecked(true);
                    fragment = new BillsFragment();
                    break;
                case R.id.manufacture:
                    menuItem.setChecked(true);
                    fragment = new ManufactureFragment();
                    break;
                default:
                    break;
            }

            if (fragment != null) {
                fragmentTransaction.replace(R.id.fragment_layout, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }

            return false;
        });
    }
}
