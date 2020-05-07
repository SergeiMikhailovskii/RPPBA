package com.bsuir.rppba.ui.manufacture;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bsuir.rppba.R;
import com.bsuir.rppba.ui.manufacture_items.ManufactureItemsActivity;

public class ManufactureFragment extends Fragment {

    public static final String TYPE = "TYPE";
    public static final String SEND = "SEND";
    public static final String GET = "GET";

    private Button sendToManufactureButton;
    private Button getFromManufactureButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manufacture_fragment, container, false);
        sendToManufactureButton = view.findViewById(R.id.sendToManufactureButton);
        getFromManufactureButton = view.findViewById(R.id.getFromManufactureButton);
        sendToManufactureButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ManufactureItemsActivity.class);
            intent.putExtra(TYPE, SEND);
            startActivity(intent);
        });
        getFromManufactureButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ManufactureItemsActivity.class);
            intent.putExtra(TYPE, GET);
            startActivity(intent);
        });
        return view;
    }
}

