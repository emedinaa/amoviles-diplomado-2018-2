package com.emedinaa.myfirstapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;

public class BasicFragment extends Fragment {

    private TextView textView;
    public BasicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_basic, container, false);
        setUpView(view);
        return view;
    }

    private void setUpView(View view){
        //textView= view.findViewById(R.id.textview);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //to do...
        //getView().findViewById()
        //getActivity()
        //getActivity().startActivity();
    }
}
