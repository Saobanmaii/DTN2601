package com.vti.entityex5q1q2;

public class CongNhan extends CanBo {
    private int bac; // Từ 1 đến 10

    public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    public int getBac() { return bac; }
    public void setBac(int bac) { this.bac = bac; }

    @Override
    public String toString() {
        return "CongNhan{" + super.toString() + ", bac=" + bac + '}';
    }
}




