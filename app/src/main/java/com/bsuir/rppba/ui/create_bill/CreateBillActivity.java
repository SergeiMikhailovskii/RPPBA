package com.bsuir.rppba.ui.create_bill;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.MergeAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Clientele;
import com.bsuir.rppba.ui.adapter.BillAddProductButtonAdapter;
import com.bsuir.rppba.ui.adapter.BillProductsAdapter;
import com.bsuir.rppba.ui.bills.BillsFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateBillActivity extends AppCompatActivity implements CreateBillContract.CreateBillView {

    private CreateBillPresenter presenter = new CreateBillPresenter();

    private Switch supplySellingSwitch;
    private EditText waybillNumberEt;
    private CheckBox firstTestCb;
    private CheckBox secondTestCb;
    private Spinner clienteles_spinner;

    private boolean isUpdatingBill;
    private String toolbarTitle;
    private int clientelePosition;

    private List<Clientele> clienteles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill);

        presenter.attachView(this);

        isUpdatingBill = getIntent().getStringExtra(BillsFragment.BILL_NUMBER) == null;
        toolbarTitle = getIntent().getStringExtra(BillsFragment.BILL_SUPPLIER);

        if (toolbarTitle == null) {
            toolbarTitle = "Create bill";
        }

        Objects.requireNonNull(getSupportActionBar()).setTitle(toolbarTitle);

        supplySellingSwitch = findViewById(R.id.supply_selling_switch);
        waybillNumberEt = findViewById(R.id.waybill_number_et);
        firstTestCb = findViewById(R.id.first_test_cb);
        secondTestCb = findViewById(R.id.second_test_cb);
        RecyclerView productsList = findViewById(R.id.products_list);
        Button saveBtn = findViewById(R.id.save_btn);
        clienteles_spinner = findViewById(R.id.clienteles_spinner);

        clienteles_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                clientelePosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        BillProductsAdapter billProductsAdapter = new BillProductsAdapter();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteBillProductCallback(billProductsAdapter));
        itemTouchHelper.attachToRecyclerView(productsList);

        BillAddProductButtonAdapter billAddProductButtonAdapter = new BillAddProductButtonAdapter(billProductsAdapter::addRow);

        MergeAdapter adapter = new MergeAdapter(billProductsAdapter, billAddProductButtonAdapter);

        productsList.setLayoutManager(new LinearLayoutManager(this));
        productsList.setAdapter(adapter);

        saveBtn.setOnClickListener(v -> {
//            if (supplierEt.getText().toString().equals("") || waybillNumberEt.getText().toString().equals("")) {
//                Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            String type = supplySellingSwitch.isChecked() ? "Supply" : "Selling";
//            presenter.saveWaybill(type, supplierEt.getText().toString(), waybillNumberEt.getText().toString(), firstTestCb.isChecked(), secondTestCb.isChecked(), billProductsAdapter.getStockItems());
        });

        presenter.loadClienteles();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
    public void onClientelesLoaded(List<Clientele> clienteles) {
        this.clienteles = clienteles;

        List<String> clientelesNames = new ArrayList<>();

        for (Clientele clientele : clienteles) {
            clientelesNames.add(clientele.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, clientelesNames);

        clienteles_spinner.setAdapter(adapter);
    }

    @Override
    public void onClientelesFailed() {

    }

    @Override
    public void showEmptyState(boolean value) {

    }

    @Override
    public void showLoadingIndicator(boolean value) {

    }

}
