class Student {
    String name;
    int id;
    String grade;

    Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(Student s) {
        System.out.println(s.name + " " + s.id + " " + s.grade);
    }
}

class StudentController {
    private Student student;
    private StudentView view;

    StudentController(Student s, StudentView v) {
        this.student = s;
        this.view = v;
    }

    public void updateView() {
        view.displayStudentDetails(student);
    }
}

public class MVCTest {
    public static void main(String[] args) {
        Student s = new Student("Alice", 1, "A");
        StudentView v = new StudentView();
        StudentController c = new StudentController(s, v);
        c.updateView();
    }
}
