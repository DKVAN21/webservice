package com.example.senda3;

import java.io.Serializable;

public class DangNhapResponse implements Serializable {

    private String manv;
    private String pass;

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
