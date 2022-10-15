package mon_java1.lab7;

public class Biz extends Poly {
    private double diemMarketing, diemSales;

    public Biz(String ten, double diemMarketing, double diemSales) {
        super(ten);
        this.diemMarketing = diemMarketing;
        this.diemSales = diemSales;
        setNganh("Biz");
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập điểm marketing: ");
        while (!setDiemMarketing(Double.parseDouble(sc.nextLine())))
            ;
        System.out.print("Nhập điểm sales: ");
        while (!setDiemSales(Double.parseDouble(sc.nextLine())))
            ;
    }

    public void xuatBiz() {
        super.xuat();
        System.out.printf("|%15s|%15s|%15s|%15s|\n", df.format(getDiem()), getHocLuc(), getDiemMarketing(),
                getDiemSales());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", df.format(getDiem()), getHocLuc(), "", "", "",
                getDiemMarketing(), getDiemSales());
    }

    public Biz() {
    }

    public double getDiemMarketing() {
        return diemMarketing;
    }

    public boolean setDiemMarketing(double diemMarketing) {
        if (diemMarketing < 0 && diemMarketing > 10) {
            System.out.print("Điểm phải nằm trong khoảng 0->10!!!\nMời nhập lại: ");
            return false;
        } else {
            this.diemMarketing = diemMarketing;
            return true;
        }
    }

    public double getDiemSales() {
        return diemSales;
    }

    public boolean setDiemSales(double diemSales) {
        if (diemSales < 0 && diemSales > 10) {
            System.out.print("Điểm phải nằm trong khoảng 0->10!!!\nMời nhập lại: ");
            return false;
        } else {
            this.diemSales = diemSales;
            return true;
        }
    }

    @Override
    public double getDiem() {
        return (2 * getDiemMarketing() + getDiemSales()) / 3;
    }

}
