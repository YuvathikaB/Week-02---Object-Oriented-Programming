import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UniversitySystem {
    static class Student {
        private String name;
        private List<Course> courses;
        public Student(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }
        public String getName() {
            return name;
        }
        public void enrollCourse(Course course) {
            courses.add(course);
            course.addStudent(this);
        }
    }
    static class Professor {
        private String name;
        private List<Course> courses;
        public Professor(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }
        public String getName() {
            return name;
        }
        public void assignProfessor(Course course) {
            courses.add(course);
            course.setProfessor(this);
        }
    }
    static class Course {
        private String name;
        private Professor professor;
        private List<Student> students;
        public Course(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }
        public String getName() {
            return name;
        }
        public void addStudent(Student student) {
            students.add(student);
        }
        public void setProfessor(Professor professor) {
            this.professor = professor;
        }
        public void viewStudents() {
            System.out.println("The following students are enrolled in " + name + ":");
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
        public void viewProfessor() {
            if (professor != null) {
                System.out.println("Professor of " + name + " is " + professor.getName());
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        List<Student> studentList = new ArrayList<>();
        System.out.println();
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter Student " + (i + 1) + " name: ");
            String studentName = scanner.nextLine();
            studentList.add(new Student(studentName));
        }
        System.out.println();
        System.out.print("Enter number of professors: ");
        int numProfessors = scanner.nextInt();
        scanner.nextLine();
        List<Professor> professorList = new ArrayList<>();
        for (int i = 0; i < numProfessors; i++) {
            System.out.print("Enter Professor " + (i + 1) + " name: ");
            String professorName = scanner.nextLine();
            professorList.add(new Professor(professorName));
        }
        System.out.println();
        System.out.print("Enter number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter Course " + (i + 1) + " name: ");
            String courseName = scanner.nextLine();
            courseList.add(new Course(courseName));
        }
        System.out.println();
        for (Student student : studentList) {
            System.out.print("Enter number of courses for " + student.getName() + ": ");
            int numStudentCourses = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < numStudentCourses; j++) {
                System.out.print("Enter Course name for " + student.getName() + ": ");
                String courseName = scanner.nextLine();
                for (Course course : courseList) {
                    if (course.getName().equals(courseName)) {
                        student.enrollCourse(course);
                    }
                }
            }
            System.out.println();
        }
        for (Professor professor : professorList) {
            System.out.print("Enter number of courses for " + professor.getName() + ": ");
            int numProfessorCourses = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < numProfessorCourses; j++) {
                System.out.print("Enter Course name for " + professor.getName() + ": ");
                String courseName = scanner.nextLine();
                for (Course course : courseList) {
                    if (course.getName().equals(courseName)) {
                        professor.assignProfessor(course);
                    }
                }
            }
            System.out.println();
        }
        for (Course course : courseList) {
            course.viewProfessor();
            System.out.println();
            course.viewStudents();
            System.out.println();
        }
        System.out.println();
    }
}
