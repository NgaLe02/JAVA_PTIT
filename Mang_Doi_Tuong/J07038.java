/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onthi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author tuanv
 */
class SinhVien {

    private String maSV, hoTen, lop, email;

    public SinhVien(String maSV, String hoTen, String lop, String email) {
        this.maSV = maSV;
        this.hoTen = chuanHoaTen(hoTen);
        this.lop = lop;
        this.email = email;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getLop() {
        return lop;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + lop;
    }

    public static String chuanHoaTen(String s) {
        s = s.toLowerCase().trim();
        String[] a = s.split("\\s+");
        s = "";
        for (String x : a) {
            s += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1) + " ";
        }
        return s.trim();
    }

}

class DoanhNghiep {

    private String maDN, tenDN;
    private int soSV;

    public DoanhNghiep(String maDN, String tenDN, int soSV) {
        this.maDN = maDN;
        this.tenDN = tenDN;
        this.soSV = soSV;
    }

    public String getMaDN() {
        return maDN;
    }

    public String getTenDN() {
        return tenDN;
    }

    public int getSoSV() {
        return soSV;
    }
}

class ThucTap {

    private SinhVien sv;
    private DoanhNghiep dn;

    public ThucTap(SinhVien sv, DoanhNghiep dn) {
        this.sv = sv;
        this.dn = dn;
    }

    public SinhVien getSv() {
        return sv;
    }

    public DoanhNghiep getDn() {
        return dn;
    }
}

public class J07038 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/MangDoiTuong/SINHVIEN.in"));

        int t = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> list1 = new ArrayList<>();
        while (t-- > 0) {
            list1.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }

        sc = new Scanner(new File("src/MangDoiTuong/DN.in"));
        int t1 = Integer.parseInt(sc.nextLine());
        ArrayList<DoanhNghiep> list2 = new ArrayList<>();
        while (t1-- > 0) {
            list2.add(new DoanhNghiep(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }

        sc = new Scanner(new File("src/MangDoiTuong/THUCTAP.in"));
        int t2 = Integer.parseInt(sc.nextLine());
        ArrayList<ThucTap> list3 = new ArrayList<>();
        while (t2-- > 0) {
            String[] arr = sc.nextLine().split("\\s+");
            for (SinhVien x : list1) {
                if (x.getMaSV().equals(arr[0])) {
                    for (DoanhNghiep y : list2) {
                        if (y.getMaDN().equals(arr[1])) {
                            list3.add(new ThucTap(x, y));
                        }
                    }
                }
            }
        }

        Collections.sort(list3, new Comparator<ThucTap>() {
            @Override
            public int compare(ThucTap o1, ThucTap o2) {
                return o1.getSv().getMaSV().compareTo(o2.getSv().getMaSV());
            }

        });

        int m = Integer.parseInt(sc.nextLine());
        while (m-- > 0) {
            String s = sc.nextLine();
            String res = "";
            for (DoanhNghiep x : list2) {
                if (x.getMaDN().equals(s)) {
                    res = x.getTenDN();
                }
            }
            System.out.println("DANH SACH THUC TAP TAI " + res + ":");
            for (ThucTap x : list3) {
                int dem = x.getDn().getSoSV();
                if (x.getDn().getMaDN().equals(s)) {
                    for (SinhVien y : list1) {
                        if (x.getSv().getMaSV().equals(y.getMaSV())) {
                            System.out.println(x);
                            dem -= 1;
                        }
                        if (dem == 0) {
                            break;
                        }
                    }
                }
            }
        }

    }
}
