package com.vti.entityex5q1q2;

import java.util.ArrayList;
import java.util.List;

public class QLCB {
    private List<CanBo> danhSachCanBo;

    public QLCB() {
        this.danhSachCanBo = new ArrayList<>();
    }

    // a) Thêm mới cán bộ
    public void themCanBo(CanBo canBo) {
        this.danhSachCanBo.add(canBo);
    }

    // b) Tìm kiếm theo họ tên
    public void timKiemTheoTen(String name) {
        boolean found = false;
        for (CanBo cb : danhSachCanBo) {
            if (cb.getHoTen().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(cb.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy cán bộ tên: " + name);
    }

    // c) Hiển thị thông tin
    public void hienThiDanhSach() {
        for (CanBo cb : danhSachCanBo) {
            System.out.println(cb.toString());
        }
    }

    // d) Xóa cán bộ theo tên
    public void xoaCanBo(String name) {
        boolean removed = danhSachCanBo.removeIf(cb -> cb.getHoTen().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Đã xóa cán bộ tên: " + name);
        } else {
            System.out.println("Không tìm thấy cán bộ để xóa.");
        }
    }
    
    // e) Hàm thoát chương trình 
    public void thoat() {
        System.out.println("Thoát chương trình.");
        System.exit(0);
    }
}
