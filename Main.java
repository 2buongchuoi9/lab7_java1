package mon_java1.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Poly> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(new IT("a", 6, 9, 8));
        list.add(new Biz("b", 2, 6));
        list.add(new IT("c", 1, 5, 7));
        list.add(new Biz("d", 6, 2));
        list.add(new Biz("m", 8, 8));
        list.add(new IT("e", 10, 9, 9));
        list.add(new Biz("z", 2, 1));
        list.add(new IT("y", 4, 2, 3));
        list.add(new Biz("t", 4, 7));

        // mặc định danh sách xuất theo tên
        list.sort((o1, o2) -> o1.getTen().compareTo(o2.getTen()));
        int chon;
        do {
            System.out.println("0. Thoát!!!");
            System.out.println("1. Nhập Danh sách sinh viên");
            System.out.println("2. Xuất toàn bộ danh sách sinh viên(theo tên a->z)");
            System.out.println("3. Xuất danh sách sinh viên theo ngành");
            System.out.println("4. Xuất danh sách sinh viên theo lực(giảm dần)");
            System.out.println("5. Xuất danh sách sinh viên theo điểm(giảm dần)");
            System.out.print("Mời chọn: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 0:
                    System.out.println("Bạn đã thoát chương trình!!!");
                    break;
                case 1:
                    nhapDuLieu();
                    break;
                case 2:
                    xuatDuLieu();
                    break;
                case 3:
                    xuatTheoNganh();
                    break;
                case 4:
                    xuatTheoHocLuc();
                    break;
                case 5:
                    xuatTheoDiem();
                    break;

                default:
                    System.out.println("Không có chương trình mời chọn lại!!!");
                    break;
            }
        } while (chon != 0);
    }

    private static void nhapDuLieu() {
        Poly sv;
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sinh viên thứ " + (i + 1) + ": ");
            System.out.print("Chọn loại sinh viên: 1.IT/2.Biz\nChọn 1 hoặc 2: ");
            int loai = Integer.parseInt(sc.nextLine());
            sv = loai == 1 ? new IT() : new Biz();
            sv.nhap();
            list.add(sv);
        }
    }

    private static void xuatDuLieu() {
        list.sort((o1, o2) -> o1.getTen().compareTo(o2.getTen()));
        System.out.println("Danh sách sinh viên theo tên a->z: ");
        Poly.tieuDe();
        list.forEach(i -> i.xuat());
    }

    private static void xuatTheoNganh() {
        System.out.println("Danh sách sinh viên theo ngành: ");
        int dem = 0;
        for (Poly i : list) {
            if (i instanceof IT) {
                if (dem == 0) {
                    System.out.println("\tNgành IT: ");
                    System.out.printf("|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", "Tên", "Ngành", "Điểm tb", "Học lực",
                            "Java", "Html", "Css");
                    dem = 1;
                }
                ((IT) i).xuatIT();
            }
        }
        dem = 0;
        for (Poly i : list) {
            if (i instanceof Biz) {
                if (dem == 0) {
                    System.out.println("\tNgành Biz: ");
                    System.out.printf("|%15s|%15s|%15s|%15s|%15s|%15s|\n", "Tên", "Ngành", "Điểm tb", "Học lực",
                            "Maketing",
                            "Sales");
                    dem++;
                }
                ((Biz) i).xuatBiz();
            }
        }
    }

    private static void xuatTheoHocLuc() {
        System.out.println("Danh sách sinh viên theo học lực(Giảm dần): ");
        list.sort((o1, o2) -> Double.compare(o2.getDiem(), o1.getDiem()));
        int dem = 0;
        for (int j = 0; j < 5; j++) {
            for (Poly i : list) {
                if (dem == 0) {
                    System.out.println("\tHọc lực " + xepLoai(j) + ": ");
                    Poly.tieuDe();
                    dem++;
                }
                if (i.getHocLuc().equals(xepLoai(j)))
                    i.xuat();
            }
            dem = 0;
        }

    }

    private static void xuatTheoDiem() {
        System.out.println("Danh sách sinh viên theo điểm trung bình(Giảm dần): ");
        int dem = 0;
        list.sort((o1, o2) -> Double.compare(o2.getDiem(), o1.getDiem()));
        for (Poly i : list) {
            if (dem == 0) {
                System.out.println("\tĐiểm giảm dần: ");
                Poly.tieuDe();
                dem++;
            }
            i.xuat();
        }
    }

    private static String xepLoai(int j) {
        return j == 0 ? "Xuất sắc" : j == 1 ? "Giỏi" : j == 2 ? "Khá" : j == 3 ? "Trung bình" : "Yếu";
    }
}
