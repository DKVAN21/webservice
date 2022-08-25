package com.example.senda3.Model;

import java.io.Serializable;
import java.util.List;

public class LoaiSPModel implements Serializable {
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
    public class Data {
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
}

