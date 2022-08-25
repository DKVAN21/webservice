package com.example.senda3;

import com.example.senda3.Model.GiohangModel;
import com.example.senda3.Model.GiohangPostCallBackModel;
import com.example.senda3.Model.GiohangPostModel;
import com.example.senda3.Model.KhachhangModel;
import com.example.senda3.Model.SanphamModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserServices {


    @POST("api/KHACHHANG/insert-KHACHHANG/")
    Call<DangKyResponse> dangkyuser (@Body DangKyRequest dangKyRequest);

    @POST("api/GIOHANG/insert-GIOHANG")
    Call<GiohangPostCallBackModel> postGiohang(@Body GiohangPostModel giohangPostModel);

    @GET("api/KHACHHANG/get-KHACHHANG/")
    Call<KhachhangModel> dangnhapuser();

    @GET("api/SANPHAM/get-SANPHAM")
    Call<SanphamModel> getValue();

    @GET("api/KHACHHANG/get-SANPHAM")
    Call<KhachhangModel> getTTkhachhang();
}
