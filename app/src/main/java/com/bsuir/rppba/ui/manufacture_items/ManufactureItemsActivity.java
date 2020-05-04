package com.bsuir.rppba.ui.manufacture_items;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Place;
import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.ui.manufacture.ManufactureFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManufactureItemsActivity extends AppCompatActivity implements ManufactureItemsContract.ManufactureItemsView {

    private ManufactureItemsPresenter presenter = new ManufactureItemsPresenter();
    private Spinner cellsSpinner;
    private Spinner productsSpinner;

    private List<RawMaterialsResponse> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufacture_items);

        cellsSpinner = findViewById(R.id.cells_spinner);
        productsSpinner = findViewById(R.id.products_spinner);

        productsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!products.isEmpty()) {
                    List<String> names = new ArrayList<>();
                    for (Place cell : products.get(0).getCell()) {
                        names.add(String.valueOf(cell.getId()));
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, names);
                    cellsSpinner.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        cellsSpinner.setEnabled(false);

        presenter.attachView(this);

        String type = getIntent().getStringExtra(ManufactureFragment.TYPE);

        presenter.getAvailableProducts(Objects.requireNonNull(type));

    }

    @Override
    public void onProductsLoaded(List<RawMaterialsResponse> products) {
        cellsSpinner.setEnabled(true);

        this.products = products;

        List<String> productNames = new ArrayList<>();

        for (RawMaterialsResponse product : products) {
            productNames.add(product.getNomenclature().getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, productNames);
        productsSpinner.setAdapter(adapter);

    }

    @Override
    public void onProductsFailed() {

    }

    @Override
    public void showEmptyState(boolean value) {

    }

    @Override
    public void showLoadingIndicator(boolean value) {

    }

}
