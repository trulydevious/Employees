package Employees;

public class Employee {

    private final String name;
    private final String gender;
    private int age;
    private double height;
    private double mass;

    public Employee(String name, String gender, int age, double height, double mass) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.mass = mass;
    }

    public void setHeight(int height) {
        if (height > 0) this.height = height;
    }

    public void setMass(int mass) {
        if (mass > 0) this.mass = mass;
    }

    public void setAge(int age) {
        if (age > 0) this.age = age;
    }

    public int getAge() {
        return age;
    }

    public double salary() {
        return 0;
    }

    public double employeesBMI() {
        this.mass = 0.45359 * mass;
        this.height = 0.0254 * height;
        double bmi = this.mass / Math.pow(this.height, 2);
        return bmi;
    }

    @Override
    public String toString() {
        return "Employees.Employee{" +
                "name = '" + name + '\'' +
                ", gender = '" + gender + '\'' +
                ", age = " + age +
                ", height = " + height +
                ", mass = " + mass +
                '}';
    }


}
