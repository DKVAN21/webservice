package com.example.senda3.Model;

import java.io.Serializable;
import java.util.List;

public class HoadonModel implements Serializable {
    private List<Data> data;

    private String status;

    private String message1;

    public List<Data> getData ()
    {
        return data;
    }

    public void setData (List<Data> data)
    {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getMessage1 ()
    {
        return message1;
    }

    public void setMessage1 (String message1)
    {
        this.message1 = message1;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+", message1 = "+message1+"]";
    }
    public class Data
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

}

