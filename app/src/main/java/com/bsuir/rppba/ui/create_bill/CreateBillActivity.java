package com.bsuir.rppba.ui.create_bill;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.MergeAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.rppba.R;
import com.bsuir.rppba.ui.adapter.BillAddProductButtonAdapter;
import com.bsuir.rppba.ui.adapter.BillProductsAdapter;

public class CreateBillActivity extends AppCompatActivity implements CreateBillContract.CreateBillView {

    private CreateBillPresenter presenter = new CreateBillPresenter();

    private Switch supplySellingSwitch;
    private EditText supplierEt;
    private EditText waybillNumberEt;
    private CheckBox firstTestCb;
    private CheckBox secondTestCb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill);

        presenter.attachView(this);

        supplySellingSwitch = findViewById(R.id.supply_selling_switch);
        supplierEt = findViewById(R.id.supplier_customer_et);
        waybillNumberEt = findViewById(R.id.waybill_number_et);
        firstTestCb = findViewById(R.id.first_test_cb);
        secondTestCb = findViewById(R.id.second_test_cb);
        RecyclerView productsList = findViewById(R.id.products_list);
        Button saveBtn = findViewById(R.id.save_btn);

        BillProductsAdapter billProductsAdapter = new BillProductsAdapter();

        BillAddProductButtonAdapter billAddProductButtonAdapter = new BillAddProductButtonAdapter(billProductsAdapter::addRow);

        MergeAdapter adapter = new MergeAdapter(billProductsAdapter, billAddProductButtonAdapter);

        productsList.setLayoutManager(new LinearLayoutManager(this));
        productsList.setAdapter(adapter);

        saveBtn.setOnClickListener(v -> {
            String type = supplySellingSwitch.isChecked() ? "Supply" : "Selling";
            presenter.saveWaybill(type, supplierEt.getText().toString(), waybillNumberEt.getText().toString(), firstTestCb.isChecked(), secondTestCb.isChecked(), billProductsAdapter.getStockItems());
        });

    }

    @Override
    public void onWaybillSaved() {
        Toast.makeText(getApplicationContext(), "Bill saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWaybillFailed() {
        Toast.makeText(getApplicationContext(), "Bill saving failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmptyState(boolean value) {

    }

    @Override
    public void showLoadingIndicator(boolean value) {

    }

}
