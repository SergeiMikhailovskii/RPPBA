package com.bsuir.rppba.ui.products_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsuir.rppba.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomModal extends BottomSheetDialogFragment {

    public BottomModal() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom_modal, container, false);
    }
}
