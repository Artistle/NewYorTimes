package com.example.newyorktimes.view.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newyorktimes.R;

public class FragmentFix extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fix, container, false);
        return view;
    }

    public FragmentFix() {
    }

    public static FragmentFix getFragmentFix(){
        return new FragmentFix();
    }
}
