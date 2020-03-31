package com.bsuir.rppba.ui.manufacture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bsuir.rppba.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ManufactureFragment extends Fragment {

    private Button sendToManufactureButton;
    private Button getFromManufactureButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manufacture_fragment, container, false);
        sendToManufactureButton = view.findViewById(R.id.sendToManufactureButton);
        getFromManufactureButton = view.findViewById(R.id.getFromManufactureButton);
        sendToManufactureButton.setOnClickListener(v -> Toast.makeText(getContext(), "Send", Toast.LENGTH_SHORT).show());
        getFromManufactureButton.setOnClickListener(v -> Toast.makeText(getContext(), "Get", Toast.LENGTH_SHORT).show());
        return view;
    }
}

