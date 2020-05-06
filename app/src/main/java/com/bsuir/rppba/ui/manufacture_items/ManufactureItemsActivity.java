package com.bsuir.rppba.ui.manufacture_items;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    private Button actionButton;
    private EditText amountEt;
    private int productPosition;
    private int cellPosition;

    private List<RawMaterialsResponse> products = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufacture_items);

        cellsSpinner = findViewById(R.id.cells_spinner);
        productsSpinner = findViewById(R.id.products_spinner);
        actionButton = findViewById(R.id.action_btn);
        amountEt = findViewById(R.id.amount_et);

        productsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!products.isEmpty()) {
                    productPosition = position;
                    List<String> names = new ArrayList<>();
                    for (Place cell : products.get(position).getCell()) {
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

        cellsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cellPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cellsSpinner.setEnabled(false);

        presenter.attachView(this);

        String type = getIntent().getStringExtra(ManufactureFragment.TYPE);

        if (Objects.requireNonNull(type).equals(ManufactureFragment.GET)) {
            actionButton.setText("Get products");
            actionButton.setOnClickListener(view -> {
            });
        } else {
            actionButton.setText("Send materials");
            actionButton.setOnClickListener(view -> presenter.sendMaterialsToManufacture(products.get(productPosition).getId(),
                    products.get(productPosition).getCell()[cellPosition].getId(),
                    Integer.parseInt(amountEt.getText().toString())
            ));
        }

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
