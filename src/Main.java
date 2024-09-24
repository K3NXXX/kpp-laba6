import java.util.HashMap;

class Student {
    String name;
    String surname;
    int age;
    int course;
    double averageMark;

    public Student(String name, String surname, int age, int course, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.course = course;
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name: " + name + '\'' +
                ", surname: " + surname + '\'' +
                ", age: " + age +
                ", course: " + course +
                ", averageMark: " + averageMark +
                '}';
    }
}

class StudentDatabase {
    private HashMap<String, Student> students;

    public StudentDatabase() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.surname, student);
    }

    public void removeStudentBySurname(String surname) {
        students.remove(surname);
    }

    public Student findStudentBySurname(String surname) {
        return students.get(surname);
    }

    public void printAllStudents() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        db.addStudent(new Student("John", "Doe", 20, 3, 85.5));
        db.addStudent(new Student("Jane", "Smith", 21, 4, 90.0));
        db.addStudent(new Student("Tom", "Brown", 19, 2, 78.3));

        System.out.println("Список всіх студентів:");
        db.printAllStudents();

        System.out.println("\nПошук студента з прізвищем Doe:");
        Student foundStudent = db.findStudentBySurname("Doe");
        if (foundStudent != null) {
            System.out.println(foundStudent);
        } else {
            System.out.println("Студента не знайдено.");
        }

        System.out.println("\nВидалення студента з прізвищем Smith:");
        db.removeStudentBySurname("Smith");

        System.out.println("Список всіх студентів після видалення:");
        db.printAllStudents();
    }
}
