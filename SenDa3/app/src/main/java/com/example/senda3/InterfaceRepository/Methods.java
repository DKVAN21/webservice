package com.example.senda3.InterfaceRepository;

import com.example.senda3.Model.GiohangModel;
import com.example.senda3.Model.GiohangPostCallBackModel;
import com.example.senda3.Model.GiohangPostModel;
import com.example.senda3.Model.HoadonModel;
import com.example.senda3.Model.HoadonPostCallBackModel;
import com.example.senda3.Model.HoadonPostModel;
import com.example.senda3.Model.KhachhangModel;
import com.example.senda3.Model.KhachhangPostCallBackModel;
import com.example.senda3.Model.KhachhangPostModel;
import com.example.senda3.Model.LoaiSPModel;
import com.example.senda3.Model.LoaiSPPostCallBackModel;
import com.example.senda3.Model.LoaiSPPostModel;
import com.example.senda3.Model.NhanvienModel;
import com.example.senda3.Model.NhanvienPostCallBackModel;
import com.example.senda3.Model.NhanvienPostModel;
import com.example.senda3.Model.SanphamModel;
import com.example.senda3.Model.SanphamPostCallBackModel;
import com.example.senda3.Model.SanphamPostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Methods {
    @GET("api/GIOHANG/get-GIOHANG")
    Call<GiohangModel> GetGiohang();
    @POST("api/GIOHANG/insert-GIOHANG")
    Call<GiohangPostCallBackModel> postGiohang(@Body GiohangPostModel giohangPostModel);

    @GET("api/HOADON/get-HOADON")
    Call<HoadonModel> GetHoadon();
    @POST("api/HOADON/insert-HOADON")
    Call<HoadonPostCallBackModel> postHoadon(@Body HoadonPostModel hoadonPostModel);

    @GET("api/KHACHHANG/get-KHACHHANG")
    Call<KhachhangModel> GetKhachhang();
    @POST("api/KHACHHANG/insert-KHACHHANG")
    Call<KhachhangPostCallBackModel> postKhachhang(@Body KhachhangPostModel khachhangPostModel);

    @GET("api/LOAISP/get-LOAISP")
    Call<LoaiSPModel> GetLoaiSP();
    @POST("api/LOAISP/insert-LOAISP")
    Call<LoaiSPPostCallBackModel> postLoaiSP(@Body LoaiSPPostModel loaiSPPostModel);

    @GET("api/NHANVIEN/get-NHANVIEN")
    Call<List<NhanvienModel>> GetNhanvien();
    @POST("api/NHANVIEN/insert-NHANVIEN")
    Call<NhanvienPostCallBackModel> postNhanvien(@Body NhanvienPostModel nhanvienPostModel);

    @GET("api/SANPHAM/get-SANPHAM")
    Call<SanphamModel> GetSanpham();
    @POST("api/SANPHAM/insert-SANPHAM")
    Call<SanphamPostCallBackModel> postSanpham(@Body SanphamPostModel sanphamPostModel);

}
