package com.example.senda3.Model;

import java.io.Serializable;

public class GiohangPostModel implements Serializable
{
    private String tongtien;

    private String masp;

    private String sdt;

    private String soluong;

    public String getTongtien ()
    {
        return tongtien;
    }

    public void setTongtien (String tongtien)
    {
        this.tongtien = tongtien;
    }

    public String getMasp ()
    {
        return masp;
    }

    public void setMasp (String masp)
    {
        this.masp = masp;
    }

    public String getSdt ()
    {
        return sdt;
    }

    public void setSdt (String sdt)
    {
        this.sdt = sdt;
    }

    public String getSoluong ()
    {
        return soluong;
    }

    public void setSoluong (String soluong)
    {
        this.soluong = soluong;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [tongtien = "+tongtien+", masp = "+masp+", sdt = "+sdt+", soluong = "+soluong+"]";
    }
}