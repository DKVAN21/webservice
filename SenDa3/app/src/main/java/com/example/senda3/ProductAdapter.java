package com.example.senda3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.senda3.Model.SanphamModel;

import java.io.Serializable;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.UserViewHolder>{
    private Context mcontext;
    private List<SanphamModel.Data> mListDt;

    public ProductAdapter(List<SanphamModel.Data> mListDt, Context mContext){
        if (mListDt == null) {
            return;
        }
        this.mcontext =  mContext;
        this.mListDt =  mListDt;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        SanphamModel.Data dt = mListDt.get(position);
        mcontext = holder.itemView.getContext();
        if(dt == null){
            return;
        }
        Glide.with(mcontext).load(dt.getHinh()).into(holder.imgPro);
        holder.txt_name.setText("Tên: "+dt.getTensp());
        holder.txt_price.setText("Giá: "+ String.valueOf(dt.getGia()));
        holder.btnMua.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("MASP", mListDt.get(position).getMasp());
            intent.putExtra("TENSP", mListDt.get(position).getTensp());
            intent.putExtra("SOLUONG", mListDt.get(position).getSoluong());
            intent.putExtra("KICHCO", mListDt.get(position).getKichco());
            intent.putExtra("MOTA", mListDt.get(position).getMota());
            intent.putExtra("GIA", mListDt.get(position).getGia());
            intent.putExtra("HINH", mListDt.get(position).getHinh());
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mListDt.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPro;
        private TextView txt_name,txt_price;
        Button btnMua;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPro = itemView.findViewById(R.id.imgProduct);
            btnMua = itemView.findViewById(R.id.btnMuangay);
            txt_name = itemView.findViewById(R.id.txtTenProduct);
            txt_price = itemView.findViewById(R.id.txtGiaproduct);
        }
    }

    private void onClickGoToDetail(List<SanphamModel.Data> dt){
        Intent intent = new Intent(mcontext, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj_data", (Serializable) dt);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }
}
