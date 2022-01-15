package teacherSalaryManagement;

import java.util.Scanner;

public class Teacher extends Person{
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private String level;

    public Teacher() {
    }

    public Teacher(int iD, String name, String adress, String phone, String level) {
        super(iD, name, adress, phone);
        this.level = level;
    }

    public void Input(){
        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.println("Trình độ: ");
        String[] arr = {"GS_TS", "PGS-TS", "Giảng viên chính","Th.S"};

        boolean check = true;
        do {
            check = true;
            int a = 0;
            System.out.println("Chọn loại trình độ: ");
            System.out.println("1.GS_TS");
            System.out.println("2.PGS-TS");
            System.out.println("3.Giảng viên chính");
            System.out.println("4.Th.S");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    this.setLevel(arr[0]);
                    break;
                case 2:
                    this.setLevel(arr[1]);
                    break;
                case 3:
                    this.setLevel(arr[2]);
                    break;
                case 4:
                    this.setLevel(arr[3]);
                    break;
                default:
                    System.out.println("Không có danh mục vừa nhập, vui lòng nhập lại!");
                    check = false;
                    break;
            }
        }
        while (!check) ;
    }

    @Override
    public String toString(){
        return "Teacher{" +
                "ID : " + iD +
                ", Họ tên : '" + name + '\'' +
                ", Địa chỉ : " + adress +'\'' +
                ", SĐT : '" + phone + '\'' +
                ", Trình độ : '" + level + '\'' +
                '}';
    }
}