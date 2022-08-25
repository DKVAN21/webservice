package com.example.senda3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senda3.Model.SanphamModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    private RecyclerView rcProHome;
    ProductAdapter proAdapter;
    Button btnedit;
    public static Context mContext;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        mContext = getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rcProHome = view.findViewById(R.id.recyclerViewHome);
        btnedit = view.findViewById(R.id.btn_edit_info);
        btnedit.setOnClickListener(view1 -> {
            getActivity().startActivity(new Intent(getContext(), EditInfoActivity.class));
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Call<SanphamModel> sanphamCall = ApiClient.getServices().getValue();
        sanphamCall.enqueue(new Callback<SanphamModel>() {
            @Override
            public void onResponse(Call<SanphamModel> call, Response<SanphamModel> response) {
                List<SanphamModel.Data> data = response.body().getData();
                proAdapter = new ProductAdapter(data, mContext);
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rcProHome.setLayoutManager(layoutManager);
                rcProHome.setAdapter(proAdapter);
            }

            @Override
            public void onFailure(Call<SanphamModel> call, Throwable t) {
                Toast.makeText(getActivity(),"Ko co du lieu",Toast.LENGTH_SHORT).show();
            }
        });
    }
}