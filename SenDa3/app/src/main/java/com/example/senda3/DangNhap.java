package com.example.senda3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.senda3.InterfaceRepository.Methods;
import com.example.senda3.Model.KhachhangModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangNhap extends AppCompatActivity {

    private SharedPreferences prefs;
    Button btnLogin, btnRegister;
    EditText txtuser, txtpasswork;
    private Boolean kiemtra = false;
    private String taikhoan, matkhau;
    public static final String SDT = "SDT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        txtuser = findViewById(R.id.txtUsername);
        txtpasswork = findViewById(R.id.txtPassword);
        kiemtra = false;

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DangNhap.this, DangKy.class));
            }
        });
    }

    public void register(View view) {
        Intent intent = new Intent(DangNhap.this, DangKy.class);
        startActivity(intent);
    }

    public void login(View view) {
        prefs = getSharedPreferences("PREFS", MODE_PRIVATE);
        Call<KhachhangModel> khachhangModelCall = ApiClient.getServices().dangnhapuser();
        khachhangModelCall.enqueue(new Callback<KhachhangModel>() {
            @Override
            public void onResponse(Call<KhachhangModel> call, Response<KhachhangModel> response) {
                List<KhachhangModel.Data> data = response.body().getData();
                taikhoan = txtuser.getText().toString();
                matkhau = txtpasswork.getText().toString();
                String tkserver = null;
                String mkserver = null;
                for (KhachhangModel.Data dt : data) {
                    tkserver = dt.getSdt();
                    mkserver = dt.getPass();
                    if (tkserver.equals(taikhoan)) {
                        if (mkserver.equals(matkhau)) {
                            prefs.edit().putString(SDT,tkserver).commit();
                            Intent intent = new Intent(DangNhap.this, TrangChu.class);
                            startActivity(intent);
                            kiemtra = true;
                            finish();
                        } else {
                            Toast.makeText(DangNhap.this, "Sai Mật Khẩu!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                if (!tkserver.equals(taikhoan) && !kiemtra) {
                    Toast.makeText(DangNhap.this, "Tài Khoản Không Tồn Tại!!!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<KhachhangModel> call, Throwable t) {
            }
        });
    }
}