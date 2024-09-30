package StudentController;

import Person.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentController {
    private static List<Student> students;
    public StudentController(List<Student> students) {
        this.students = students;
    }
    public Optional<Student> getYoungest() {
        Optional<Student> minAge =  students.stream()
                .min(Comparator.comparing(Student::getAge));
        return minAge;
    }
    public static List<Student> searchStudentByName(String name) {
        List<Student> filteredName = students.stream()
                .filter(student -> student.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
        return filteredName;
    }

}
