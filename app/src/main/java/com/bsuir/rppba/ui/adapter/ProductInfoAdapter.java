package com.bsuir.rppba.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Place;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductInfoAdapter extends RecyclerView.Adapter<ProductInfoAdapter.ViewHolder> {

    private List<Place> placeArrayList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public ProductInfoAdapter(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_info_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Place place = placeArrayList.get(position);
        holder.infoTextViewPlace.setText(place.getPlace());
        holder.infoTextViewAmount.setText(place.getAmount());
        holder.infoButton.setText(R.string.Move);

        holder.itemView.setOnClickListener(v -> {
            if (holder.getAdapterPosition() != RecyclerView.NO_POSITION){
                onItemClickListener.onItemClick(holder.getAdapterPosition(), place);
            }
        });

    }

    @Override
    public int getItemCount() {
        return placeArrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData (List<Place> placeArrayList){
        this.placeArrayList.clear();
        this.placeArrayList.addAll(placeArrayList);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener{
        void onItemClick (int position,Place place);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView infoTextViewPlace;
        private TextView infoTextViewAmount;
        private Button infoButton;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            infoTextViewPlace = itemView.findViewById(R.id.infoTextViewPlace);
            infoTextViewAmount = itemView.findViewById(R.id.infoTextViewAmount);
            infoButton = itemView.findViewById(R.id.infoButton);

        }
    }
}
