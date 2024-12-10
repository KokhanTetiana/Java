package com.education.ztu.Task2;


public class Main {
    public static void main(String[] args) {
        Car teacherCar = new Car("Nissan");
        Teacher teacher = new Teacher("Maria", "Svift", 30, Gender.FEMALE, Location.KIEV, "English", "KPI", teacherCar);

        Car employeeCar = new Car("Volkswagen");
        Employee employee = new Employee("Ivan", "Ivanenko", 26, Gender.MALE, Location.VINNYTSYA, "Lawyer", "Law firm", employeeCar);
        Student student = new Student("Denys", "Denysenko", 19, Gender.MALE, Location.ZHYTOMYR, "Software engineering", "Software Engineering", "Zhytomyr Polytechnic State University");

        System.out.println("===== Teacher =====");
        teacher.sayName();
        teacher.sayAge();
        teacher.sayLocation();
        teacher.sayGender();
        teacher.getOccupation();

        System.out.println("\n===== Employee =====");
        employee.sayName();
        employee.sayAge();
        employee.sayLocation();
        employee.sayGender();
        employee.getOccupation();

        System.out.println("\n===== Student =====");
        student.sayName();
        student.sayAge();
        student.sayLocation();
        student.sayGender();
        student.getOccupation();

        System.out.println("\n===== Teacher's car =====");
        System.out.println("Car: " + teacherCar.getBrand());
        System.out.println("Is the engine running? " + teacherCar.engineIsRunning());
        teacherCar.getEngine().startEngine();
        System.out.println("Does the engine run after starting? " + teacherCar.engineIsRunning());

        System.out.println("\n===== Count =====");
        Teacher.showCounter();
        Student.showCounter();
        Employee.showCounter();
        System.out.println("\n==========");
        if (teacher instanceof Person) {
            System.out.println("Teacher is a Person.");
        }
        if (employee instanceof Person) {
            System.out.println("Employee is a Person.");
        }
        if (student instanceof Person) {
            System.out.println("Student is a Person.");
        }
    }
}