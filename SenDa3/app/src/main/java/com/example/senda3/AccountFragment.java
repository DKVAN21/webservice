package com.example.senda3;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountFragment extends Fragment
{

    private Button btnTT;
    private TextView txtSDT;
    private SharedPreferences prefs;
    private String sdt;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = getView(inflater,container);
        txtSDT = view.findViewById(R.id.txtSDT);
        btnTT = view.findViewById(R.id.btn_edit_info);
        btnTT.setOnClickListener(view1 -> {
            getActivity().startActivity(new Intent(getContext(), EditInfoActivity.class));
        });

        setdata();

        return view;
    }

    private void setdata() {
        prefs = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        sdt = prefs.getString("SDT", "");
        Log.d("testss", "sdt: " + sdt);
        txtSDT.setText(sdt);
    }

    private View getView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        return view;
    }

}