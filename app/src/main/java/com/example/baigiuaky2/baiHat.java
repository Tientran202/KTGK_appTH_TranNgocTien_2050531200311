package com.example.baigiuaky2;

import java.util.Objects;

public class baiHat {
    private int anh;
    private String ten,mota;

    public  baiHat(){

    }

    public baiHat(int anh, String ten, String mota) {
        this.anh = anh;
        this.ten = ten;
        this.mota = mota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        baiHat baihat = (baiHat) o;
        return Objects.equals(ten, baihat.ten);
    }

    public baiHat(String ten) {
        this.ten = ten;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
