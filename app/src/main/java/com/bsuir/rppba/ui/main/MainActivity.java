package com.bsuir.rppba.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.bsuir.rppba.R;
import com.bsuir.rppba.ui.materials.MaterialsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        FragmentTransaction startTransaction = getSupportFragmentManager().beginTransaction();
        MaterialsFragment materialsFragment = new MaterialsFragment();
        startTransaction.add(R.id.fragment_layout, materialsFragment);
        startTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        startTransaction.commit();
    }
}
