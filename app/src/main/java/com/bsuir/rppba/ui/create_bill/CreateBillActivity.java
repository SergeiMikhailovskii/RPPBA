package com.bsuir.rppba.ui.create_bill;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.rppba.R;

public class CreateBillActivity extends AppCompatActivity implements CreateBillContract.CreateBillView {

    private CreateBillPresenter presenter = new CreateBillPresenter();

    private Switch supplySellingSwitch;
    private EditText supplierEt;
    private EditText waybillNumber;
    private CheckBox firstTestCb;
    private CheckBox secondTestCb;
    private RecyclerView productsList;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill);

        presenter.attachView(this);

        supplySellingSwitch = findViewById(R.id.supply_selling_switch);
        supplierEt = findViewById(R.id.supplier_customer_et);
        waybillNumber = findViewById(R.id.waybill_number_et);
        firstTestCb = findViewById(R.id.first_test_cb);
        secondTestCb = findViewById(R.id.second_test_cb);
        productsList = findViewById(R.id.products_list);
        saveBtn = findViewById(R.id.save_btn);

    }

    @Override
    public void showEmptyState(boolean value) {

    }

    @Override
    public void showLoadingIndicator(boolean value) {

    }

}
