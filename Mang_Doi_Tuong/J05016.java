package Mang_Doi_Tuong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class J05016 {

    private String ma, name, soPhong, ngayNhanPhong, ngayTraPhong;

    private int tienPhatSinh, soNgayO, thanhTien;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public J05016(int ma, String name, String soPhong, String ngayNhanPhong, String ngayTraPhong, int tienPhatSinh) {
        this.ma = String.format("KH%02d", ma);
        this.name = name;
        this.soPhong = soPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.tienPhatSinh = tienPhatSinh;
    }


    public int getDonGia() {
        char c = soPhong.charAt(0);
        if (c == '1') {
            return 25;
        } else if (c == '2') {
            return 34;
        } else if (c == '3') {
            return 50;
        } else {
            return 80;
        }
    }

    public int getSoNgayO() throws ParseException {
        int diff = -1;
        Date dateStart = simpleDateFormat.parse(ngayNhanPhong);
        Date dateEnd = simpleDateFormat.parse(ngayTraPhong);
        diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (1000 * 60 * 60 * 24));
        return diff + 1;
    }

    public int getThanhTien() throws ParseException {
        return getDonGia() * getSoNgayO()+ tienPhatSinh;
    }

    @Override
    public String toString() {
        try {
            return ma + " " + name + " " + soPhong + " " + getSoNgayO() + " " + getThanhTien();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        ArrayList<J05016> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(new J05016(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }

        Collections.sort(list, new Comparator<J05016>() {
            @Override
            public int compare(J05016 o1, J05016 o2) {
                try {
                    return o2.getThanhTien() - o1.getThanhTien();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        for (J05016 x : list) {
            System.out.println(x.toString());
        }
    }
}
