package com.example.senda3.Model;

import java.io.Serializable;

public class KhachhangPostModel implements Serializable
{
    private String diachi;

    private String sdt;

    private String pass;

    private String tenkh;

    private String email;

    public String getDiachi ()
    {
        return diachi;
    }

    public void setDiachi (String diachi)
    {
        this.diachi = diachi;
    }

    public String getSdt ()
    {
        return sdt;
    }

    public void setSdt (String sdt)
    {
        this.sdt = sdt;
    }

    public String getPass ()
    {
        return pass;
    }

    public void setPass (String pass)
    {
        this.pass = pass;
    }

    public String getTenkh ()
    {
        return tenkh;
    }

    public void setTenkh (String tenkh)
    {
        this.tenkh = tenkh;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [diachi = "+diachi+", sdt = "+sdt+", pass = "+pass+", tenkh = "+tenkh+", email = "+email+"]";
    }
}