package com.example.senda3.Model;

import java.io.Serializable;

public class LoaiSPPostModel implements Serializable
{
    private String tenloai;

    private String maloai;

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    @Override
    public String toString() {
        return "ClassPojo [tenloai = " + tenloai + ", maloai = " + maloai + "]";
    }
}