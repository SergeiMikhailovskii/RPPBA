package com.bsuir.rppba.ui.productsinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Place;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.adapter.ProductInfoAdapter;
import com.bsuir.rppba.ui.products.ProductContract;

import java.util.List;
import java.util.Objects;

public class ProductInfoActivity extends AppCompatActivity implements ProductInfoContract.ProductInfoView, ProductInfoAdapter.OnItemClickListener {

    private ProductInfoPresenter productInfoPresenter = new ProductInfoPresenter();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView productInfoRecyclerView;
    private ProductInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> productInfoPresenter.loadProductInfoList());

        productInfoRecyclerView = findViewById(R.id.productInfo_list);
        productInfoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
       // productInfoRecyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(DividerItemDecoration.VERTICAL, this));
        adapter = new ProductInfoAdapter(this);
        productInfoRecyclerView.setAdapter(adapter);
        productInfoPresenter.loadProductInfoList();

    }

    @Override
    public void onItemClick(int position, Place place) {
        //TODO replace with Intent
        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onProductInfoLoaded(List<Place> places) {
        adapter.setData(places);
    }

    @Override
    public void onProductInfoFailed() {
        Toast.makeText(this, "Loading failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmptyState(boolean value) {

    }

    @Override
    public void showLoadingIndicator(boolean value) {

    }
}
