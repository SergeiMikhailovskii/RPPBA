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
import com.bsuir.rppba.data.entity.Material;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MaterialsAdapter extends RecyclerView.Adapter<MaterialsAdapter.ViewHolder> {

    private List<Material> materials = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public MaterialsAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.materials_element, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.amount.setText(materials.get(position).getAmount()+"");
        holder.subName.setText(materials.get(position).getSubName());
        holder.name.setText(materials.get(position).getName());
        Glide.with(LogisticsApp.getAppContext()).load(materials.get(position).getIcon()).into(holder.icon);

        holder.itemView.setOnClickListener(v -> {
            if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                onItemClickListener.onItemClicked(holder.getAdapterPosition(), materials.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return materials.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(List<Material> materials) {
        this.materials.clear();
        this.materials.addAll(materials);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {

        void onItemClicked(int position, Material materials);

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
