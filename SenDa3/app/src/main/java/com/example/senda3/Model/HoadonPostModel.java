package com.example.senda3.Model;

import java.io.Serializable;

public class HoadonPostModel implements Serializable
{
    private String masp;

    private String sdt;

    private String mahd;

    private String thanhtien;

    private String manv;

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

    public String getMahd ()
    {
        return mahd;
    }

    public void setMahd (String mahd)
    {
        this.mahd = mahd;
    }

    public String getThanhtien ()
    {
        return thanhtien;
    }

    public void setThanhtien (String thanhtien)
    {
        this.thanhtien = thanhtien;
    }

    public String getManv ()
    {
        return manv;
    }

    public void setManv (String manv)
    {
        this.manv = manv;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [masp = "+masp+", sdt = "+sdt+", mahd = "+mahd+", thanhtien = "+thanhtien+", manv = "+manv+"]";
    }
}