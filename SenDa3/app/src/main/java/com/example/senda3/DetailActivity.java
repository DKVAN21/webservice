package com.example.senda3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.senda3.Model.GiohangPostCallBackModel;
import com.example.senda3.Model.GiohangPostModel;
import com.example.senda3.Model.SanphamModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    TextView txtTen, txtGia, txtMota, txtSL, txtKichco;
    Button btnDathang;
    private ImageView imgHinh;
    EditText edSL;
    private static String id = null;
    private String tensp,gia,mota,sl,kichco,masp,hinh;
    private SharedPreferences prefs;
    private String sdt;
    Integer tongtien =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_product);
        mappingView();

    }

    private void mappingView(){
        txtTen = findViewById(R.id.txtTenDetail);
        txtGia = findViewById(R.id.txtGiaDetail);
        txtMota = findViewById(R.id.txtMotaDetail);
        txtSL = findViewById(R.id.txtSoluongDetail);
        txtKichco = findViewById(R.id.txtKichcoDetail);
        btnDathang = findViewById(R.id.btnDathang);
        imgHinh = findViewById(R.id.imgHinhDetail);
        edSL = findViewById(R.id.editSL);

        masp = getIntent().getStringExtra("MASP");
        tensp = getIntent().getStringExtra("TENSP");
        mota = getIntent().getStringExtra("MOTA");
        sl = getIntent().getStringExtra("SOLUONG");
        kichco = getIntent().getStringExtra("KICHCO");
        gia = getIntent().getStringExtra("GIA");
        hinh = getIntent().getStringExtra("HINH");

        txtTen.setText("Tên: "+tensp);
        txtGia.setText("Giá: "+gia);
        txtSL.setText("Đang có "+sl);
        txtMota.setText(mota);
        txtKichco.setText("Size: "+kichco);
        Glide.with(this).load(hinh).into(imgHinh);
        prefs = getSharedPreferences("PREFS", MODE_PRIVATE);
        sdt = prefs.getString("SDT", "");
        Log.d("testss", "sdt: " + sdt);
    }

    public void dathang(View view) {

        GiohangPostModel post = new GiohangPostModel();
        post.setMasp(masp);
        post.setSdt(sdt);
        post.setSoluong(edSL.getText().toString());
        post.setTongtien(gia);
        Call<GiohangPostCallBackModel> giohangcall = ApiClient.getServices().postGiohang(post);
        giohangcall.enqueue(new Callback<GiohangPostCallBackModel>() {
            @Override
            public void onResponse(Call<GiohangPostCallBackModel> call, Response<GiohangPostCallBackModel> response) {
                Toast.makeText(DetailActivity.this,"Đặt thành công",Toast.LENGTH_LONG).show();
                Log.d("testss", "ok ");
                startActivity(new Intent(DetailActivity.this,TrangChu.class));
                finish();
            }

            @Override
            public void onFailure(Call<GiohangPostCallBackModel> call, Throwable t) {
                String msg = t.getMessage();
                Log.d("testss", "not: " + msg);
                Toast.makeText(DetailActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

}
