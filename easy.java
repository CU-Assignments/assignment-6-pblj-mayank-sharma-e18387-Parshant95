import java.util.*;

class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 50000),
            new Employee("Bob", 25, 60000),
            new Employee("Charlie", 35, 55000)
        );

        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
        System.out.println();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
        System.out.println();
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
    }
}
