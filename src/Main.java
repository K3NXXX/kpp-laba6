import java.util.LinkedList;

class Student {
    int id;
    String name;
    String surname;
    int age;
    int course;
    double averageMark;

    public Student(int id, String name, String surname, int age, int course, double averageMark) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.course = course;
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id: " + id +
                ", name: " + name + '\'' +
                ", surname: " + surname + '\'' +
                ", age: " + age +
                ", course: " + course +
                ", averageMark: " + averageMark +
                '}';
    }
}

class StudentDatabase {
    private LinkedList<Student> students;

    public StudentDatabase() {
        students = new LinkedList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudentAtFirst(Student student) {
        students.addFirst(student);
    }

    public void removeStudentById(int id) {
        students.removeIf(student -> student.id == id);
    }

    public void removeFirstStudent() {
        if (!students.isEmpty()) {
            students.removeFirst();
        } else {
            System.out.println("Список порожній.");
        }
    }

    public void removeLastStudent() {
        if (!students.isEmpty()) {
            students.removeLast();
        } else {
            System.out.println("Список порожній.");
        }
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    public void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        db.addStudent(new Student(1, "John", "Doe", 20, 3, 85.5));
        db.addStudent(new Student(2, "Jane", "Smith", 21, 4, 90.0));
        db.addStudentAtFirst(new Student(3, "Tom", "Brown", 19, 2, 78.3)); // додаємо на початок списку

        System.out.println("Список всіх студентів:");
        db.printAllStudents();

        System.out.println("\nВидалення першого студента:");
        db.removeFirstStudent();
        db.printAllStudents();

        System.out.println("\nВидалення останнього студента:");
        db.removeLastStudent();
        db.printAllStudents();

        System.out.println("\nПошук студента з id 1:");
        Student foundStudent = db.findStudentById(1);
        if (foundStudent != null) {
            System.out.println(foundStudent);
        } else {
            System.out.println("Студента не знайдено.");
        }
    }
}
