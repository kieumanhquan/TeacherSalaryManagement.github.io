package teacherSalaryManagement.entity;

import java.util.Scanner;

public class Person {
    private static int iDAuto = 100;
    int iD;
    String name;
    String adress;
    String phone;

    public Person(){

    }

    public Person(int iD, String name, String adress, String phone) {
        this.iD = iD;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }

    public static int getiDAuto() {
        return iDAuto;
    }

    public static void setiDAuto(int iDAuto) {
        Person.iDAuto = iDAuto;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void Input(){
        Scanner sc = new Scanner(System.in);
        this.setiD(iDAuto);
        System.out.println("Nhập họ tên: ");
        this.setName(sc.nextLine());
        System.out.println("Địa chỉ: ");
        this.setAdress(sc.nextLine());
        System.out.println("SĐT: ");
        this.setPhone(sc.nextLine());
    }

    @Override
    public String toString(){
        return "Person{" +
                "ID : " + iD +
                ", Họ tên : '" + name + '\'' +
                ", Địa chỉ : " + adress +
                ", SĐT : '" + phone + '\'' +
                '}';
    }
}