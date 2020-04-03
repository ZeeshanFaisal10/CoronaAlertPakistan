package com.example.coronaalertpakistan.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.coronaalertpakistan.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SafetyPrecautionFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_safety_precaution, container, false);

        return v;    }

}
