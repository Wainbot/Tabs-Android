package com.example.jeremy.td_tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewFragment extends Fragment {

    ImageView mImageViewChevre;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view        = inflater.inflate(R.layout.fragment_view, container, false);
        mImageViewChevre = (ImageView) view.findViewById(R.id.imageViewChevres);
        mImageViewChevre.setImageResource(R.mipmap.chevre_1);

        return view;
    }

    public ImageView getImageView() {
        return mImageViewChevre;
    }
}