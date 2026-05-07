package com.vti.entityex5q4;

public class Bao extends TaiLieu {
    private int ngayPhatHanh;

    public Bao(String maTaiLieu, String nhaXuatBan, int soBanPhatHanh, int ngayPhatHanh) {
        super(maTaiLieu, nhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }
    // Getter & Setter...
    public int getNgayPhatHanh() { return ngayPhatHanh; }
    public void setNgayPhatHanh(int ngayPhatHanh) { this.ngayPhatHanh = ngayPhatHanh; }


    @Override
    public String toString() { return "Báo{" + super.toString() + ", Ngày PH: " + ngayPhatHanh + "}"; }
}