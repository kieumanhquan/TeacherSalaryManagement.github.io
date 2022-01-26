package teacherSalaryManagement.entity;

import teacherSalaryManagement.entity.Person;

import java.util.Scanner;

public class Teacher extends Person {
    private String level;

    public final static String TYPE_1 = "GS_TS";
    public final static String TYPE_2 = "PGS";
    public final static String TYPE_3 = "Giảng viên chính";
    public final static String TYPE_4 = "Th.S";

    public Teacher() {
    }

    public Teacher(int iD, String name, String adress, String phone, String level) {
        super(iD, name, adress, phone);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void Input(){
        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.println("Trình độ: ");

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
                    this.setLevel(TYPE_1);
                    break;
                case 2:
                    this.setLevel(TYPE_2);
                    break;
                case 3:
                    this.setLevel(TYPE_3);
                    break;
                case 4:
                    this.setLevel(TYPE_4);
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