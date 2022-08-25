package com.example.senda3.Model;

import java.io.Serializable;
import java.util.List;

public class KhachhangModel implements Serializable {
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
    public static class Data
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

        public Data(String sdt, String pass) {
            this.sdt = sdt;
            this.pass = pass;
        }

        public Data(String diachi, String sdt, String pass, String tenkh, String email) {
            this.diachi = diachi;
            this.sdt = sdt;
            this.pass = pass;
            this.tenkh = tenkh;
            this.email = email;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [diachi = "+diachi+", sdt = "+sdt+", pass = "+pass+", tenkh = "+tenkh+", email = "+email+"]";
        }
    }

}

