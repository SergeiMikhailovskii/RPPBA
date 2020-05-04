package com.bsuir.rppba.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Bill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class BillsAdapter extends RecyclerView.Adapter<BillsAdapter.ViewHolder> {

    private List<Bill> bills = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public BillsAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_element, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bill bill = bills.get(position);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.s", Locale.ENGLISH);
        Date date = null;
        Calendar calendar = Calendar.getInstance();

        try {
            date = dateFormat.parse(bill.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.setTime(Objects.requireNonNull(date));

        holder.billNumberTv.setText("Number: " + bill.getBillId());
        holder.createdAtTv.setText("Created at: " + calendar.get(Calendar.DAY_OF_MONTH) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR) + ", " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
        holder.supplier.setText(bill.getStockItemSupplier());

        if (bill.isAreChecksPassed()) {
            holder.statusIv.setImageResource(R.drawable.ic_done);
        } else {
            holder.statusIv.setImageResource(R.drawable.ic_in_progress);
        }

        if (bill.getType().equals("SUPPLY")) {
            holder.billIv.setImageResource(R.drawable.bill_in);
        } else {
            holder.billIv.setImageResource(R.drawable.bill_out);
        }

        holder.itemView.setOnClickListener(v -> {
            if (holder.getBindingAdapterPosition() != RecyclerView.NO_POSITION) {
                onItemClickListener.onItemClicked(holder.getBindingAdapterPosition(), bill);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setData(List<Bill> bills) {
        this.bills.clear();
        this.bills.addAll(bills);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {

        void onItemClicked(int position, Bill bill);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView statusIv;
        TextView supplier;
        TextView createdAtTv;
        ImageView billIv;
        TextView billNumberTv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            statusIv = itemView.findViewById(R.id.status_iv);
            supplier = itemView.findViewById(R.id.supplier);
            createdAtTv = itemView.findViewById(R.id.created_at_tv);
            billIv = itemView.findViewById(R.id.bill_icon);
            billNumberTv = itemView.findViewById(R.id.bill_number);

        }
    }
}
