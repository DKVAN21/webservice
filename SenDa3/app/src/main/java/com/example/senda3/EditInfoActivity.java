package com.example.senda3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.senda3.Model.KhachhangModel;
import com.example.senda3.Model.SanphamModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditInfoActivity extends AppCompatActivity {
    private EditText edTen, edEmail, edSdt, edDiachi;
    private Button btnUpdate, btnThoat;
    private SharedPreferences prefs;
    private String sdt;
    Boolean kiemtra = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        mappingview();
        btnThoat.setOnClickListener(view -> {
            finish();
        });
        btnUpdate.setOnClickListener(view -> {
            update();
        });
    }

    private void update() {
        DangKyRequest dangKyRequest = new DangKyRequest();
        dangKyRequest.setSdt(edSdt.getText().toString());
        dangKyRequest.setTenkh(edTen.getText().toString());
        dangKyRequest.setEmail(edEmail.getText().toString());
        dangKyRequest.setDiachi(edDiachi.getText().toString());
        Call<DangKyResponse> dangKyResponseCall = ApiClient.getServices().dangkyuser(dangKyRequest);
        dangKyResponseCall.enqueue(new Callback<DangKyResponse>() {
            @Override
            public void onResponse(Call<DangKyResponse> call, Response<DangKyResponse> response) {
                if(response.isSuccessful()){
                    String message = "Cập nhật hành Công";
                    Toast.makeText(EditInfoActivity.this,message,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(EditInfoActivity.this,TrangChu.class));
                    finish();
                }else{
                    String message = "Lỗi";
                    Toast.makeText(EditInfoActivity.this,message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DangKyResponse> call, Throwable t) {

            }
        });
    }

    private void mappingview() {
        btnUpdate = findViewById(R.id.btnCreate);
        btnThoat = findViewById(R.id.btnExit);
        edTen = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edSdt = findViewById(R.id.edPhone);
        edDiachi = findViewById(R.id.edDiachi);

        prefs = getSharedPreferences("PREFS", MODE_PRIVATE);
        sdt = prefs.getString("SDT", "");
        Log.d("testss", "sdt: " + sdt);
        edSdt.setText(sdt);


        Call<KhachhangModel> sanphamCall = ApiClient.getServices().getTTkhachhang();
        sanphamCall.enqueue(new Callback<KhachhangModel>() {
            @Override
            public void onResponse(Call<KhachhangModel> call, Response<KhachhangModel> response) {
                List<KhachhangModel.Data> data = response.body().getData();
                String sdtS = null;
                String ten = null;
                String email = null;
                String diachi = null;
                for (KhachhangModel.Data dt : data) {
                    sdtS = dt.getSdt();
                    if (sdtS.equals(sdt)) {
                        ten = dt.getDiachi();
                        email = dt.getEmail();
                        diachi = dt.getDiachi();

                        edTen.setText(ten);
                        edSdt.setText(sdt);
                        edEmail.setText(email);
                        edDiachi.setText(diachi);
                    }
                    else {
                        Toast.makeText(EditInfoActivity.this, "Tài Khoản Không Tồn Tại!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<KhachhangModel> call, Throwable t) {
            }
        });

    }
}
