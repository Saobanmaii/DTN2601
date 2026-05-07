package com.vti.entityex5q4;

import java.util.ArrayList;
import java.util.List;

public class QuanLySach {
    private List<TaiLieu> danhSachTaiLieu;

    public QuanLySach() {
        this.danhSachTaiLieu = new ArrayList<>();
    }

    // a) Thêm mới tài liệu
    public void themTaiLieu(TaiLieu tl) {
        this.danhSachTaiLieu.add(tl);
    }

    // b) Xoá tài liệu theo mã tài liệu
    public void xoaTaiLieu(String maTaiLieu) {
        boolean removed = danhSachTaiLieu.removeIf(tl -> tl.getMaTaiLieu().equalsIgnoreCase(maTaiLieu));
        if (removed) {
            System.out.println("Đã xóa tài liệu mã: " + maTaiLieu);
        } else {
            System.out.println("Không tìm thấy mã tài liệu cần xóa.");
        }
    }

    // c) Hiển thị thông tin
    public void hienThiThongTin() {
        for (TaiLieu tl : danhSachTaiLieu) {
            System.out.println(tl.toString());
        }
    }

    // d) Tìm kiếm theo loại (Truyền vào từ khóa "Sach", "TapChi", "Bao")
    public void timKiemTheoLoai(String loai) {
        System.out.println("--- Kết quả tìm kiếm cho loại: " + loai + " ---");
        for (TaiLieu tl : danhSachTaiLieu) {
            if (loai.equalsIgnoreCase("Sach") && tl instanceof Sach) {
                System.out.println(tl.toString());
            } else if (loai.equalsIgnoreCase("TapChi") && tl instanceof TapChi) {
                System.out.println(tl.toString());
            } else if (loai.equalsIgnoreCase("Bao") && tl instanceof Bao) {
                System.out.println(tl.toString());
            }
        }
    }
    // e) Hàm thoát chương trình
    public void thoat() {
        System.out.println("Thoát chương trình.");
        System.exit(0);
    }
}