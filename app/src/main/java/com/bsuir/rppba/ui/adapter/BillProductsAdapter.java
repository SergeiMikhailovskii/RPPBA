package com.bsuir.rppba.ui.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.StockItem;

import java.util.ArrayList;
import java.util.List;

public class BillProductsAdapter extends RecyclerView.Adapter<BillProductsAdapter.ViewHolder> {

    private List<StockItem> stockItems = new ArrayList<>();

    public BillProductsAdapter() {
        stockItems.add(new StockItem());
        stockItems.add(new StockItem());
        stockItems.add(new StockItem());
    }

    public void addRow() {
        stockItems.add(0, new StockItem());
        notifyDataSetChanged();
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void deleteItem(int position) {
        stockItems.remove(position);
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
        Log.i(getClass().getName(), String.valueOf(position));
        holder.name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stockItems.get(position).setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        holder.amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stockItems.get(position).setAmount(Integer.parseInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return stockItems.size();
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

        EditText name;
        EditText amount;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_et);
            amount = itemView.findViewById(R.id.amount_et);

        }

    }

}
