package mon_java1.lab7;

public class IT extends Poly {
    private double diemJava, diemCss, diemHtml;

    public IT(String ten, double diemJava, double diemCss, double diemHtml) {
        super(ten);
        this.diemJava = diemJava;
        this.diemCss = diemCss;
        this.diemHtml = diemHtml;
        setNganh("IT");
    }

    public IT() {
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhập điểm java: ");
        while (!setDiemJava(Double.parseDouble(sc.nextLine())))
            ;
        System.out.print("Nhập điểm html: ");
        while (!setDiemHtml(Double.parseDouble(sc.nextLine())))
            ;
        System.out.print("Nhập điểm css: ");
        while (!setDiemCss(Double.parseDouble(sc.nextLine())))
            ;
    }

    public void xuatIT() {
        super.xuat();
        System.out.printf("|%15s|%15s|%15s|%15s|%15s|\n", df.format(getDiem()), getHocLuc(), getDiemJava(),
                getDiemHtml(), getDiemCss());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", df.format(getDiem()), getHocLuc(), getDiemJava(),
                getDiemHtml(), getDiemCss(), "", "");
    }

    public double getDiemJava() {
        return diemJava;
    }

    public boolean setDiemJava(double diemJava) {
        if (diemJava < 0 && diemJava > 10) {
            System.out.print("Điểm phải nằm trong khoảng 0->10!!!\nMời nhập lại: ");
            return false;
        } else {
            this.diemJava = diemJava;
            return true;
        }
    }

    public double getDiemCss() {
        return diemCss;
    }

    public boolean setDiemCss(double diemCss) {
        if (diemCss < 0 && diemCss > 10) {
            System.out.print("Điểm phải nằm trong khoảng 0->10!!!\nMời nhập lại: ");
            return false;
        } else {
            this.diemCss = diemCss;
            return true;
        }
    }

    public double getDiemHtml() {
        return diemHtml;
    }

    public boolean setDiemHtml(double diemHtml) {
        if (diemHtml < 0 && diemHtml > 10) {
            System.out.print("Điểm phải nằm trong khoảng 0->10!!!\nMời nhập lại: ");
            return false;
        } else {
            this.diemHtml = diemHtml;
            return true;
        }
    }

    @Override
    public double getDiem() {
        return (2 * getDiemJava() + getDiemHtml() + getDiemCss()) / 4;
    }

}
