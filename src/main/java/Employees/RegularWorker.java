package Employees;

import Employees.Employee;

import java.util.concurrent.ThreadLocalRandom;

public class RegularWorker extends Employee {

    private double workingTime;
    private double basicSalary;

    public RegularWorker(String name, String gender, int age, int height, int mass) {
        super(name, gender, age, height, mass);
        this.workingTime = ThreadLocalRandom.current().nextInt(0, 160);
        this.basicSalary = ThreadLocalRandom.current().nextInt(2800, 10000);
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary > 0) this.basicSalary = basicSalary;
    }

    public void setWorkingTime(double workingTime) {
        if (workingTime > 0) this.workingTime = workingTime;
    }

    public double getWorkingTime() {
        return workingTime;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double salary(){
        double salary = (this.workingTime/160) * this.basicSalary;
        return salary;
    }

    public String toString() {
        String oldPart = super.toString();
        oldPart = oldPart.substring(0, oldPart.length() - 1);
        String newPart = ", working time = " + this.workingTime + ", basic salary = " + this.basicSalary + "}";
        return oldPart.concat(newPart);
    }


}
