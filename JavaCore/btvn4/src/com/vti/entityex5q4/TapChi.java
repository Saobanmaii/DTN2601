package com.vti.entityex5q4;

public class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(String maTaiLieu, String nhaXuatBan, int soBanPhatHanh, int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, nhaXuatBan, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }
    // Getter & Setter...
    public int getSoPhatHanh() { return soPhatHanh; }
    public void setSoPhatHanh(int soPhatHanh) { this.soPhatHanh = soPhatHanh; }

    public int getThangPhatHanh() { return thangPhatHanh; }
    public void setThangPhatHanh(int thangPhatHanh) { this.thangPhatHanh = thangPhatHanh; }

    @Override
    public String toString() { return "Tạp chí{" + super.toString() + ", Số PH: " + soPhatHanh + ", Tháng PH: " + thangPhatHanh + "}"; }
}