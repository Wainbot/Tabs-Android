package com.example.jeremy.td_tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class ChooseFragment extends Fragment {

    private String[]     mChevres;
    private NumberPicker mPickerChevres;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mChevres       = new String[]{"Chèvre 1", "Chèvre 2", "Chèvre 3"};
        View view      = inflater.inflate(R.layout.fragment_choose, container, false);
        mPickerChevres = (NumberPicker) view.findViewById(R.id.numberPickerChevres);
        mPickerChevres.setMinValue(0);
        mPickerChevres.setMaxValue(2);
        mPickerChevres.setDisplayedValues(mChevres);

        return view;
    }

    public NumberPicker getNumberPicker() {
        return mPickerChevres;
    }

    public String[] mesChevres() {
        return mChevres;
    }
}