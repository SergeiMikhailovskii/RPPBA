package com.bsuir.rppba.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.StockItem;

import java.util.ArrayList;
import java.util.List;

public class BillProductsAdapter extends RecyclerView.Adapter<BillProductsAdapter.ViewHolder> {

    private List<StockItem> stockItems = new ArrayList<>();

    private List<Integer> productsIds = new ArrayList<>();

    private List<StockItem> viewItems = new ArrayList<>();

    public BillProductsAdapter() {
        viewItems.add(new StockItem());
        viewItems.add(new StockItem());
        viewItems.add(new StockItem());
    }

    public void setData(List<StockItem> items) {

    }

    public List<Integer> getProductsIds() {
        return productsIds;
    }

    public void addRow() {
        viewItems.add(0, new StockItem());
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        viewItems.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_product_element, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> itemNames = new ArrayList<>();

        for (StockItem stockItem : stockItems) {
            itemNames.add(stockItem.getName());
        }

        if (!itemNames.isEmpty()) {

            ArrayAdapter<String> adapter = new ArrayAdapter<>(holder.itemView.getContext(), android.R.layout.simple_spinner_dropdown_item, itemNames);
            holder.productSpinner.setAdapter(adapter);
            holder.productSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    productsIds.add(stockItems.get(position).getId());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return viewItems.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.bill_product_element;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        Spinner productSpinner;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            productSpinner = itemView.findViewById(R.id.name_spinner);

        }

    }

}
