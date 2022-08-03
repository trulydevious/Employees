package Employees;

import Employees.Employee;

import java.util.concurrent.ThreadLocalRandom;

public class Student extends Employee {

    public double workingHours;
    public double hourlyRate;

    public Student(String name, String gender, int age, int height, int mass) {
        super(name, gender, age, height, mass);
        this.workingHours = ThreadLocalRandom.current().nextInt(0, 160);
        this.hourlyRate = ThreadLocalRandom.current().nextInt(1, 30);
    }

    public void setWorkingHours(double workingHours) {
        if (workingHours >= 0) this.workingHours = workingHours;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate > 0) this.hourlyRate = hourlyRate;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double salary(){
        double salary = this.workingHours * this.hourlyRate;
        return salary;
    }

    public String toString() {
        String oldPart = super.toString();
        oldPart = oldPart.substring(0, oldPart.length() - 1);
        String newPart = ", working hours = " + this.workingHours + ", hourly rate = " + this.hourlyRate + "}";
        return oldPart.concat(newPart);
    }

}
