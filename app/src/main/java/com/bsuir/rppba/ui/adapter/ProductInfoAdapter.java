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

    private List<Place> places = new ArrayList<>();
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
    public void onBindViewHolder(@NonNull ViewHolder view, int position) {
        Place place = places.get(position);
        view.placeTextView.setText(place.getPlace());
        view.amountTextView.setText(place.getAmount()+"");
        view.moveButton.setText(R.string.Move);

        view.moveButton.setOnClickListener(v -> {
            if (view.getAdapterPosition() != RecyclerView.NO_POSITION){
                onItemClickListener.onItemClick(view.getAdapterPosition(), place);
            }
        });

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData (List<Place> placeArrayList){
        this.places.clear();
        this.places.addAll(placeArrayList);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener{
        void onItemClick (int position,Place place);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView placeTextView;
        private TextView amountTextView;
        private Button moveButton;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            placeTextView = itemView.findViewById(R.id.placeTextView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
            moveButton = itemView.findViewById(R.id.moveButton);

        }
    }
}
