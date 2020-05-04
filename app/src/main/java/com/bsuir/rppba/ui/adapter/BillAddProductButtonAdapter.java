package com.bsuir.rppba.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.rppba.R;

public class BillAddProductButtonAdapter extends RecyclerView.Adapter<BillAddProductButtonAdapter.ViewHolder> {

    private OnItemClickListener onItemClickListener;

    public BillAddProductButtonAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_add_product_element, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.addRow.setOnClickListener(v -> {
            onItemClickListener.onItemClicked();
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.bill_add_product_element;
    }

    public interface OnItemClickListener {

        void onItemClicked();

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        Button addRow;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            addRow = itemView.findViewById(R.id.add_row_btn);
        }
    }

}
