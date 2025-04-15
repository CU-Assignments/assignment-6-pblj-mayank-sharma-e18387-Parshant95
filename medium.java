import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }
}

class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Anu", 82),
            new Student("Ravi", 74),
            new Student("Meera", 91),
            new Student("Raj", 68)
        );

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
