package com.example.senda3.Model;

import java.io.Serializable;

public class NhanvienPostModel implements Serializable
{
    private String chucvu;

    private String pass;

    private String tennv;

    private String manv;

    public String getChucvu ()
    {
        return chucvu;
    }

    public void setChucvu (String chucvu)
    {
        this.chucvu = chucvu;
    }

    public String getPass ()
    {
        return pass;
    }

    public void setPass (String pass)
    {
        this.pass = pass;
    }

    public String getTennv ()
    {
        return tennv;
    }

    public void setTennv (String tennv)
    {
        this.tennv = tennv;
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
        return "ClassPojo [chucvu = "+chucvu+", pass = "+pass+", tennv = "+tennv+", manv = "+manv+"]";
    }
}