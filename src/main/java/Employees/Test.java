package Employees;

import Employees.Employee;
import Employees.RegularWorker;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class Test {

    public Test() {
    }

    public static ArrayList importData(String path){
        ArrayList<Employee> employees = new ArrayList<Employee>();

        try {
            FileReader filereader = new FileReader(path);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    String[] row = cell.split(String.valueOf(';'));
                    if (row[5].contains("Employees.Student")){
                        Student student = new Student(row[0], row[1],Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));
                        employees.add(student);
                    }
                    else if (row[5].contains("Worker")){
                        RegularWorker regularWorker = new RegularWorker (row[0], row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));
                        employees.add(regularWorker);
                    }
                }
            }
            csvReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }


    public static double employeesAverageAge(ArrayList<Employee> employees){

        double avgAge = 0;
        for (Employee employee : employees){
            avgAge += employee.getAge();
        }
        double result = avgAge / employees.size();
        return Math.round(result * 10) / 10.0;
    }


    public static double studentPercentage(ArrayList<Employee> employees) {

        double students = 0;
        for (Employee employee : employees){
            if (employee instanceof Student) students += 1;
        }
        double result = students / employees.size() * 100.0;
        return Math.round(result * 10) / 10.0;
    }


    public static double highestSalary(ArrayList<Employee> employees) {

        double highestSalary = 0;
        for (Employee employee : employees){
            if (highestSalary < employee.salary()) highestSalary = employee.salary();
        }
        return highestSalary;
    }


    public static int checkEmployeesBMI(ArrayList<Employee> employees) {

        int correctWeight = 0;
        for (Employee employee : employees){
            if (employee.employeesBMI() > 18.5 && employee.employeesBMI() < 24.9) correctWeight += 1;
        }
        return correctWeight;
    }


    public static void main(String[] args) {
        String path = "C:/Users/weran/IdeaProjects/ZPO_lab_7/src/main/java/Employees/Lab7_biostats.csv";
        ArrayList<Employee> employees = importData(path);
        for (Employee employee : employees){
            System.out.println(employee.toString());
        }

        System.out.println("Średnia wieku wszystkich pracowników: " + employeesAverageAge(employees));
        System.out.println("Procent pracowników, którzy są studentami: " + studentPercentage(employees));
        System.out.println("Najwyższa pensja pracownika: " + highestSalary(employees));
        System.out.println("Liczba osób, których BMI wskazuje na prawidłową wagę: " + checkEmployeesBMI(employees));

    }


}
