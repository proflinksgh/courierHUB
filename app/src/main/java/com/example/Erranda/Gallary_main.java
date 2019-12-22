package com.example.Erranda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class Gallary_main extends Fragment {
    private int[] imageUrls = new int[]{R.drawable.img, R.drawable.elshaddai,
    R.drawable.bb, R.drawable.err, R.drawable.erd, R.drawable.thygrace};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_gallary, container, false );


        ViewPager viewPager = rootView.findViewById( R.id.view_pager );
        ViewPagerAdapter adapter = new ViewPagerAdapter( getActivity(), imageUrls );
        viewPager.setAdapter( adapter );


        return rootView;
    }
}





