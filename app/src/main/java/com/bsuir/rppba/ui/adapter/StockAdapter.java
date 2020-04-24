package com.bsuir.rppba.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.rppba.LogisticsApp;
import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.StockItem;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class StockAdapter extends RecyclerView.Adapter<StockAdapter.ViewHolder> {

    private List<StockItem> stockItems = new ArrayList<>();
    private OnItemClickListener onItemClickListener;


    public StockAdapter(OnItemClickListener onItemClickListener, ArrayList<StockItem> stockItems) {
        this.onItemClickListener = onItemClickListener;
        this.stockItems = stockItems;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_element, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StockItem stockItem = stockItems.get(position);
        holder.amount.setText(stockItem.getAmount() + "");
        holder.subName.setText(stockItem.getSubName());
        holder.name.setText(stockItem.getName());
        Glide.with(LogisticsApp.getAppContext()).load(stockItem.getIcon()).into(holder.icon);
        holder.itemView.setOnClickListener(v -> {
            if (holder.getBindingAdapterPosition() != RecyclerView.NO_POSITION) {
                int adapterPosition = holder.getBindingAdapterPosition();
                onItemClickListener.onItemClick(adapterPosition);
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

    public void setData(List<StockItem> stockItems) {
        this.stockItems.clear();
        this.stockItems.addAll(stockItems);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name;
        TextView subName;
        TextView amount;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            subName = itemView.findViewById(R.id.subName);
            amount = itemView.findViewById(R.id.amount);

        }
    }
}
