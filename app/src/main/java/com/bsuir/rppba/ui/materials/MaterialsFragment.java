package com.bsuir.rppba.ui.materials;

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
import com.bsuir.rppba.data.entity.Material;
import com.bsuir.rppba.ui.adapter.MaterialsAdapter;

import java.util.List;
import java.util.Objects;

public class MaterialsFragment extends Fragment implements MaterialsContract.MaterialsView, MaterialsAdapter.OnItemClickListener {

    private MaterialsPresenter presenter = new MaterialsPresenter();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView materials;
    private MaterialsAdapter adapter;

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
        adapter = new MaterialsAdapter(this);
        materials.setAdapter(adapter);

        presenter.loadMaterialsList();

        return view;
    }

    @Override
    public void onMaterialsLoaded(List<Material> materials) {
        adapter.setData(materials);
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
    public void onItemClicked(int position, Material materials) {
        //TODO replace with Intent
        Toast.makeText(getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
    }

}
