package serialization;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
	private String name;
	private int roll;
	private LocalDate dob;
	
	public Student(String name, int roll, LocalDate dob) {
		this.name = name;
		this.roll = roll;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
	
}
