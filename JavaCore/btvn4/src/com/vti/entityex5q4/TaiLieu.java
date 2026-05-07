package com.vti.entityex5q4;

public class TaiLieu {
    private String maTaiLieu;
    private String nhaXuatBan;
    private int soBanPhatHanh;

    public TaiLieu(String maTaiLieu, String nhaXuatBan, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.nhaXuatBan = nhaXuatBan;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public String getMaTaiLieu() { return maTaiLieu; }
    public void setMaTaiLieu(String maTaiLieu) { this.maTaiLieu = maTaiLieu; }

    public String getNhaXuatBan() { return nhaXuatBan; }
    public void setNhaXuatBan(String nhaXuatBan) { this.nhaXuatBan = nhaXuatBan; }

    public int getSoBanPhatHanh() { return soBanPhatHanh; }
    public void setSoBanPhatHanh(int soBanPhatHanh) { this.soBanPhatHanh = soBanPhatHanh; }

    @Override
    public String toString() {
        return "Mã TL: " + maTaiLieu + ", NXB: " + nhaXuatBan + ", Số bản: " + soBanPhatHanh;
    }
}