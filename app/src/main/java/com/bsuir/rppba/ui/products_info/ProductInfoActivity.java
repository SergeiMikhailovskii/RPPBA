package com.bsuir.rppba.ui.products_info;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Place;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.adapter.ProductInfoAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductInfoActivity extends AppCompatActivity implements ProductInfoContract.ProductInfoView, ProductInfoAdapter.OnItemClickListener {

    private ProductInfoPresenter productInfoPresenter = new ProductInfoPresenter();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView productInfoRecyclerView;
    private ProductInfoAdapter adapter;
    private ImageView productIv;

    private StockItem item;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra("ID", 0);
        }

        productInfoPresenter.attachView(this);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> productInfoPresenter.loadProductInfoList(id));
        productIv = findViewById(R.id.productImage);

        productInfoRecyclerView = findViewById(R.id.productInfo_list);
        productInfoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productInfoRecyclerView.addItemDecoration(new DividerItemDecoration(this, (DividerItemDecoration.VERTICAL)));
        adapter = new ProductInfoAdapter(this);
        productInfoRecyclerView.setAdapter(adapter);
        productInfoPresenter.loadProductInfoList(id);


    }

    @Override
    public void onItemClick(int position, Place place) {
        if (item.getPlaces().get(position).getPlace().equals("Unsorted")) {
            BottomModal bottomModal = BottomModal.getInstance(true, id);
            bottomModal.show(getSupportFragmentManager(), null);
        }
    }


    @Override
    public void onProductInfoLoaded(StockItem item) {
        if (item.getIcon() != null) {
            item.setIcon("https://pngimage.net/wp-content/uploads/2018/06/vector-pen-png.png");
        }
        Glide.with(getApplicationContext()).load(item.getIcon()).into(productIv);
        if (item.getAmount() > 0) {
            if (item.getPlaces() == null) {
                item.setPlaces(new ArrayList<>());
            }
            item.getPlaces().add(new Place("Unsorted", item.getAmount(), 0));
        }
        this.item = item;
        adapter.setData(item.getPlaces());
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
        swipeRefreshLayout.setRefreshing(value);
    }
}
