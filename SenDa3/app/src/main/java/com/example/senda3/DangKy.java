package com.example.senda3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangKy extends AppCompatActivity {

    Button btnCreate, btnExit;
    EditText txtname, txtsdt, txtpasswork, txtemail, txtdiachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        btnCreate = findViewById(R.id.btnCreate);
        btnExit = findViewById(R.id.btnExit);
        txtname = findViewById(R.id.txtName);
        txtsdt = findViewById(R.id.txtPhone);
        txtpasswork = findViewById(R.id.txtPassword);
        txtemail = findViewById(R.id.txtEmail);
        txtdiachi = findViewById(R.id.txtAddress);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( TextUtils.isEmpty(txtname.getText().toString()) || TextUtils.isEmpty(txtsdt.getText().toString()) ||
                    TextUtils.isEmpty(txtpasswork.getText().toString()) || TextUtils.isEmpty(txtdiachi.getText().toString()) ||
                    TextUtils.isEmpty(txtemail.getText().toString())){
                    String message = "Hãy nhập đầy đủ thông tin!!!";
                    Toast.makeText(DangKy.this,message,Toast.LENGTH_LONG).show();
                }else{
                    DangKyRequest dangKyRequest = new DangKyRequest();
                    dangKyRequest.setTenkh(txtname.getText().toString());
                    dangKyRequest.setSdt(txtsdt.getText().toString());
                    dangKyRequest.setPass(txtpasswork.getText().toString());
                    dangKyRequest.setEmail(txtemail.getText().toString());
                    dangKyRequest.setDiachi(txtdiachi.getText().toString());
                    dangkyuser(dangKyRequest);
                }
            }
        });
    }

    public void dangkyuser(DangKyRequest dangKyRequest){
        Call<DangKyResponse> dangKyResponseCall = ApiClient.getServices().dangkyuser(dangKyRequest);
        dangKyResponseCall.enqueue(new Callback<DangKyResponse>() {
            @Override
            public void onResponse(Call<DangKyResponse> call, Response<DangKyResponse> response) {
                if(response.isSuccessful()){
                    String message = "Thành Công";
                    Toast.makeText(DangKy.this,message,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(DangKy.this,DangNhap.class));
                    finish();
                }else{
                    String message = "Lỗi";
                    Toast.makeText(DangKy.this,message,Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<DangKyResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(DangKy.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }
}