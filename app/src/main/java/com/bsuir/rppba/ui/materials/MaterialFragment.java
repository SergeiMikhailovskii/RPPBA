package com.bsuir.rppba.ui.materials;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.adapter.StockAdapter;
import com.bsuir.rppba.ui.products_info.ProductInfoActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MaterialFragment extends Fragment implements MaterialContract.MaterialsView, StockAdapter.OnItemClickListener {

    private MaterialPresenter presenter = new MaterialPresenter();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView materials;
    private StockAdapter adapter;
    private List<StockItem> stockItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materials, container, false);
        presenter.attachView(this);


        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.loadMaterialsList());
        materials = view.findViewById(R.id.materials_list);
        materials.setLayoutManager(new LinearLayoutManager(getContext()));
        materials.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        stockItems = new ArrayList<>();
        adapter = new StockAdapter(this, (ArrayList<StockItem>) stockItems);
        materials.setAdapter(adapter);


        presenter.loadMaterialsList();

        return view;
    }

    @Override
    public void onMaterialsLoaded(List<StockItem> stockItems) {

        adapter.setData(stockItems);
    }

    @Override
    public void onMaterialsFailed() {
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
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), ProductInfoActivity.class);
        intent.putExtra("ID", stockItems.get(position).getId());
        startActivity(intent);
    }
}
