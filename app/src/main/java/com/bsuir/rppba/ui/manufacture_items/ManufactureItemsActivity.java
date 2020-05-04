package com.bsuir.rppba.ui.manufacture_items;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bsuir.rppba.R;
import com.bsuir.rppba.ui.manufacture.ManufactureFragment;

public class ManufactureItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufacture_items);

        String type = getIntent().getStringExtra(ManufactureFragment.TYPE);

    }

}
