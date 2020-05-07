package com.bsuir.rppba.ui.products_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Place;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BottomModal extends BottomSheetDialogFragment implements BottomModalContract.BottomModalView {

    private Button moveBtn;
    private Spinner cellsSpinner;
    private EditText amountEt;

    private int cellId;
    private int productId;

    private boolean isUnsorted = false;

    private BottomModalPresenter presenter = new BottomModalPresenter();

    public BottomModal() {
    }

    public static BottomModal getInstance(boolean isUnsorted, int productId) {
        BottomModal modal = new BottomModal();
        Bundle args = new Bundle();
        args.putBoolean("isUnsorted", isUnsorted);
        args.putInt("productId", productId);
        modal.setArguments(args);
        return modal;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_modal, container, false);
        presenter.attachView(this);
        isUnsorted = Objects.requireNonNull(getArguments()).getBoolean("isUnsorted");
        productId = Objects.requireNonNull(getArguments()).getInt("productId");
        moveBtn = view.findViewById(R.id.move_btn);
        amountEt = view.findViewById(R.id.amount_et);

        moveBtn.setOnClickListener(btn -> {
            if (isUnsorted) {
                presenter.moveUnsortedProduct(productId, cellId, Integer.parseInt(amountEt.getText().toString()));
            }
        });

        cellsSpinner = view.findViewById(R.id.cells_spinner);

        presenter.getFreeCells();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showEmptyState(boolean value) {

    }

    @Override
    public void showLoadingIndicator(boolean value) {

    }

    @Override
    public void onFreeCellsLoaded(List<Place> cells) {
        List<Integer> cellIds = new ArrayList<>();

        for (Place place : cells) {
            cellIds.add(place.getId());
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_dropdown_item, cellIds);
        cellsSpinner.setAdapter(adapter);

        cellsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cellId = cellIds.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onFreeCellsFailed() {

    }

    @Override
    public void onUnsortedProductMoved() {
        Toast.makeText(getContext(), "Moved", Toast.LENGTH_SHORT).show();
    }

}
