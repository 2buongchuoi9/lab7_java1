package mon_java1.lab7;

import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class Poly {
    private String ten, nganh;
    
    static DecimalFormat df= new DecimalFormat("#.##");

    public Poly(String ten) {
        this.ten = ten;
    }

    public static Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.print("Nhập tên: ");
        setTen(sc.nextLine());
        // int loai;
        // do {
        //     System.out.print("Nhập nganh(1.IT/2.Biz): ");
        //     loai = Integer.parseInt(sc.nextLine());
        // } while (loai!=1 && loai!=2);
        // setNganh(loai == 1 ? "IT" : "Biz");
    }

    public static void tieuDe() {
        System.out.printf("|%15s|%15s|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", "Tên", "Ngành", "Điểm", "Học lực", "Java",
                "Html", "Css", "Maketing", "Sales");
    }

    public void xuat() {
        System.out.printf("|%15s|%15s", getTen(), getNganh());
    }

    public abstract double getDiem();

    public String getHocLuc() {
        return getDiem() < 5 ? "Yếu"
                : getDiem() < 6.5 ? "Trung bình" : getDiem() < 7.5 ? "Khá" : getDiem() < 9 ? "Giỏi" : "Xuất sắc";
    }

    public Poly() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

}
