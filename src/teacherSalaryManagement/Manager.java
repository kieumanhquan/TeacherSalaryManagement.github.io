package teacherSalaryManagement;

import java.util.Scanner;

public class Manager {
    public static Subject[] subjects;
    public static Teacher[] teachers;
    public static Teaching[] teachings;

    public void run(){
        while (true) {
            System.out.println("Danh sách chức năng: ");
            System.out.println("1. Thêm giáo viên");
            System.out.println("2. In ra danh sách giáo viên");
            System.out.println("3. Thêm môn học");
            System.out.println("4. In ra danh sách môn học");
            System.out.println("5. Nhập chương trình giảng dạy");
            System.out.println("6. In danh sách giảng dạy");
            System.out.println("7. Sắp xếp theo tên GV");
            System.out.println("8. Sắp xếp theo số tiết giảng dạy mỗi môn (Giảm dần)");
            System.out.println("9. Tổng tiền công của GV");
            boolean flag = true;
            do {
                flag = true;
                int chosse = 0;
                Scanner scanner = new Scanner(System.in);
                System.out.print("Chọn chức năng: ");
                chosse = scanner.nextInt();
                switch (chosse) {
                    case 1:
                        CreateTeacher();
                        break;
                    case 2:
                        DisplayTeacher();
                        break;
                    case 3:
                        CreateSubject();
                        break;
                    case 4:
                        DisplaySubject();
                        break;
                    case 5:
                        CreateTeaching();
                        break;
                    case 6:
                        DisplayTeaching();
                        break;
                    case 7:
                        SortNameTeacher();
                        DisplayTeaching();
                        break;
                    case 8:
                        SortQuantity();
                        DisplayTeaching();
                        break;
                    case 9:
                        Salary();
                        break;
                    default:
                        System.out.println("Không có danh mục vừa nhập, vui lòng nhập lại!");
                        flag = false;
                        break;
                }
            }
            while (!flag);
        }
    }

    public void CreateTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng giảng viên");
        int a = scanner.nextInt();
        teachers = new Teacher[a];
        for(int i = 0; i < a; i++){
            Teacher teacher = new Teacher();
            teacher.Input();
            teachers[i] = teacher;
        }
    }

    public void DisplayTeacher(){
        System.out.println("Danh sách giáo viên: ");
        for(Teacher teacher: teachers)
        {
            System.out.println(teacher);
        }
    }

    public void CreateSubject(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng môn học: ");
        int a = scanner.nextInt();
        subjects = new Subject[a];
        for(int i = 0; i < a; i++){
            Subject subject = new Subject();
            subject.InputSubject();
            subjects[i] = subject;
        }
    }

    public void DisplaySubject(){
        System.out.println("Danh sách môn học:");
        for(Subject subject: subjects)
        {
            System.out.println(subject);
        }
    }

    public void CreateTeaching(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số GV giảng dạy: ");
        boolean flag = false;
        int a;
        do {
            a = sc.nextInt();
            if (a > teachers.length) {
                System.out.println("Nhập lại số GV: ");
                flag = true;
            }
            else flag = false;
        }while (flag);
        teachings = new Teaching[a];
        int sum = 0;
        for(int i = 0; i < a; i++){
            System.out.print("Nhập ID GV: ");
            int d;
            Teacher teacher;
            boolean check = false;
            do{
                d = sc.nextInt();
                teacher = SearchTeacher(d);
                if(teacher == null){
                    System.out.print("Nhập lại ID: ");
                    check = true;
                }
                else
                    check = false;
            }while (check);
            System.out.println(teacher);

            System.out.print("Nhập số lượng môn giảng dạy: ");
            int b;
            do {
                b = sc.nextInt();
                if( b > subjects.length){
                    System.out.print("Nhập lại số lượng môn giảng dạy: ");
                    flag = true;
                }
                else
                    flag = false;
            }while (flag);
            Subject[] subjects = new Subject[b];
            int []ListQuantity = new int [b];
            check = true;
            do{
                sum = 0;
                for(int j = 0; j < b; j++){
                    System.out.print("Nhập ID môn học: ");
                    int id;
                    Subject subject;
                    do {
                        id = sc.nextInt();
                        subject = SearchSubject(id);
                        if(subject == null){
                            System.out.print("Nhập lại ID: ");
                            flag = true;
                        }
                        else
                            flag=false;
                    }while (flag);

                    int c;
                    System.out.print("Nhập số lớp dạy: ");
                    c = sc.nextInt();
                    sum = sum + c * subject.getTotal();
                    if(sum > 200){
                        System.out.println("GV đã dạy quá số tiết quy định! ");
                        check = true;
                    }
                    else check = false;
                    ListQuantity[j] = c;
                    subjects[j] = subject;
                }
            }while (check);

            Teaching teaching = new Teaching(teacher, subjects, ListQuantity);
            teachings[i] = teaching;
        }
        for(int i = 0; i < a; i++)
        {
            System.out.println(teachings[i]);
        }
    }

    public void DisplayTeaching(){
        for(Teaching teaching:teachings) {
            System.out.println(teaching);
        }
    }

    public Teacher SearchTeacher(int id){
        for(Teacher teacher:teachers){
            if(teacher.getiD() == id)
                return teacher;
        }
        return null;
    }

    public Subject SearchSubject(int id){
        for(Subject subject:subjects){
            if(subject.getiD() == id)
                return subject;
        }
        return null;
    }

    public void SortNameTeacher(){
        Teaching tam = new Teaching();
        for(int i = 0; i < teachings.length - 1; i++){
            for(int j = i + 1; j < teachings.length; j++)
            {
                if(teachings[i].getTeacher().getName().compareTo(teachings[j].getTeacher().getName()) > 0)
                {
                    tam = teachings[i];
                    teachings[i] = teachings[j];
                    teachings[j] = tam;
                }
            }
        }
    }

    public void SortQuantity(){
        for(int i = 0; i < teachings.length; i++){
            subjects = teachings[i].getSubjects();
            Subject tg = new Subject();
            for(int j = 0; j < teachings[i].getSubjects().length - 1; j++ ){
                for(int k = j + 1; k < teachings[i].getSubjects().length; k++){
                    if(subjects[j].getTotal() < subjects[k].getTotal())
                    {
                        tg = subjects[j];
                        subjects[j] = subjects[k];
                        subjects[k] = tg;
                    }
                }
            }
        }
    }

    public void Salary(){
        for(int i = 0; i < teachings.length; i++){
            System.out.println(teachings[i].teacher);
            subjects= teachings[i].getSubjects();
            int[] quantity = teachings[i].getQuantity();
            double total = 0.0;
            for(int j = 0; j < teachings[i].getSubjects().length; j++ ){
                total = total + (subjects[j].getTotal() - subjects[j].getTheory()) * subjects[j].getPrice() * 0.7 + subjects[j].getTheory() * subjects[j].getPrice() * quantity[j];
            }
            System.out.println("Lương: " + total + " đồng.");
        }
    }
}