package assignments.day15.task2;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    private String name;
    private int rollno;
    private LocalDate dob;

    public Student(String name, int rollno, LocalDate dob) {
        this.name = name;
        this.rollno = rollno;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
