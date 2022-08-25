package com.example.senda3.Model;

import java.io.Serializable;
import java.util.List;

public class NhanvienModel implements Serializable {
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


}

