package com.bsuir.rppba.ui.bills;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Bill;
import com.bsuir.rppba.ui.adapter.BillsAdapter;
import com.bsuir.rppba.ui.create_bill.CreateBillActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class BillsFragment extends Fragment implements BillsContract.BillsView, BillsAdapter.OnItemClickListener {

    private BillsPresenter presenter = new BillsPresenter();
    private RecyclerView billsList;
    private FloatingActionButton addBillFab;
    private SwipeRefreshLayout swipeRefreshLayout;
    private BillsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bills, container, false);
        presenter.attachView(this);

        billsList = view.findViewById(R.id.bills_list);
        addBillFab = view.findViewById(R.id.add_bill_fab);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        billsList.setLayoutManager(new LinearLayoutManager(getContext()));

        swipeRefreshLayout.setOnRefreshListener(() -> presenter.loadBills());

        adapter = new BillsAdapter(this);
        billsList.setAdapter(adapter);

        presenter.loadBills();

        return view;
    }

    @Override
    public void onBillsLoaded(List<Bill> bills) {
        adapter.setData(bills);
    }

    @Override
    public void onBillsFailed() {
        Toast.makeText(getContext(), "Loading failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmptyState(boolean value) {

    }

    @Override
    public void showLoadingIndicator(boolean value) {
        swipeRefreshLayout.setRefreshing(value);
    }

    @Override
    public void onItemClicked(int position, Bill bill) {
        startActivity(new Intent(getContext(), CreateBillActivity.class));
    }

}
