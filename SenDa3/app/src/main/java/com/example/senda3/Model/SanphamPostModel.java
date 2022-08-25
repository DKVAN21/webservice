package com.example.senda3.Model;

import java.io.Serializable;

public class SanphamPostModel implements Serializable
{
    private String masp;

    private String kichco;

    private String maloai;

    private String tensp;

    private String hinh;

    private String soluong;

    private String mota;

    private String gia;

    public String getMasp ()
    {
        return masp;
    }

    public void setMasp (String masp)
    {
        this.masp = masp;
    }

    public String getKichco ()
    {
        return kichco;
    }

    public void setKichco (String kichco)
    {
        this.kichco = kichco;
    }

    public String getMaloai ()
    {
        return maloai;
    }

    public void setMaloai (String maloai)
    {
        this.maloai = maloai;
    }

    public String getTensp ()
    {
        return tensp;
    }

    public void setTensp (String tensp)
    {
        this.tensp = tensp;
    }

    public String getHinh ()
    {
        return hinh;
    }

    public void setHinh (String hinh)
    {
        this.hinh = hinh;
    }

    public String getSoluong ()
    {
        return soluong;
    }

    public void setSoluong (String soluong)
    {
        this.soluong = soluong;
    }

    public String getMota ()
    {
        return mota;
    }

    public void setMota (String mota)
    {
        this.mota = mota;
    }

    public String getGia ()
    {
        return gia;
    }

    public void setGia (String gia)
    {
        this.gia = gia;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [masp = "+masp+", kichco = "+kichco+", maloai = "+maloai+", tensp = "+tensp+", hinh = "+hinh+", soluong = "+soluong+", mota = "+mota+", gia = "+gia+"]";
    }
}