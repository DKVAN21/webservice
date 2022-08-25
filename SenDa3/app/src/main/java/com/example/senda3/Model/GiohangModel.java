package com.example.senda3.Model;

import java.io.Serializable;
import java.util.List;

public class GiohangModel implements Serializable {
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

}

