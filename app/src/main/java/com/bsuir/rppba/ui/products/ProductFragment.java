package com.bsuir.rppba.ui.products;

import android.content.Intent;
import android.os.Bundle;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class ProductFragment extends Fragment implements ProductContract.ProductView, StockAdapter.OnItemClickListener {

    private ProductContract.ProductsPresenter presenter = new ProductPresenter();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView products;
    private StockAdapter adapter;
    private List<StockItem> stockItems = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        presenter.attachView(this);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.loadProductsList());

        products = view.findViewById(R.id.products_list);
        products.setLayoutManager(new LinearLayoutManager(getContext()));
        products.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        stockItems = new ArrayList<>();
        adapter = new StockAdapter(this, (ArrayList<StockItem>) stockItems);
        products.setAdapter(adapter);


        presenter.loadProductsList();

        return view;
    }


    @Override
    public void onProductsLoaded(List<StockItem> productsList) {
        adapter.setData(productsList);
    }

    @Override
    public void onProductsFailed() {
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
