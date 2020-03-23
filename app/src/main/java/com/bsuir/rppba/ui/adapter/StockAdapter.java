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

    public StockAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stocks_element, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.amount.setText(stockItems.get(position).getAmount()+"");
        holder.subName.setText(stockItems.get(position).getSubName());
        holder.name.setText(stockItems.get(position).getName());
        Glide.with(LogisticsApp.getAppContext()).load(stockItems.get(position).getIcon()).into(holder.icon);

        holder.itemView.setOnClickListener(v -> {
            if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                onItemClickListener.onItemClicked(holder.getAdapterPosition(), stockItems.get(position));
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

        void onItemClicked(int position, StockItem materials);

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
