package teacherSalaryManagement.entity.teaching;

import teacherSalaryManagement.entity.Subject;
import teacherSalaryManagement.entity.Teacher;

import java.util.Arrays;

public class Teaching {
    public Teacher teacher;
    private  Subject[] subjects;
    private  int[] quantity;

    public Teaching() {
    }

    public Teaching(Teacher teacher, Subject[] subjects, int []quantity) {
        this.teacher = teacher;
        this.subjects = subjects;
        this.quantity = quantity;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Teaching{" + " " + teacher +
                ", " + Arrays.toString(subjects) +
                ", Số lượng : " + Arrays.toString(quantity) +
                "}";
    }
}