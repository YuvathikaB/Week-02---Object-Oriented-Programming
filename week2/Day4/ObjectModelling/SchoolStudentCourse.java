import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SchoolStudentCourse {
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
        public void enrollInCourse(Course course) {
            if (!courses.contains(course)) {
                courses.add(course);
                course.addStudent(this);
            }
        }
        public void viewCourses() {
            System.out.println(name + " is enrolled in :");
            for (Course course : courses) {
                System.out.println(course.getName());
            }
        }
    }
    static class Course {
        private String name;
        private List<Student> students;
        public Course(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }
        public String getName() {
            return name;
        }
        public void addStudent(Student student) {
            if (!students.contains(student)) {
                students.add(student);
            }
        }
        public void viewStudents() {
            System.out.println("Students enrolled in " + name + ":");
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }
    static class School {
        private String name;
        private List<Student> students;
        public School(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }
        public void addStudent(Student student) {
            students.add(student);
        }
        public void displayStudents() {
            System.out.println("Students enrolled at " + name + ":");
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
        public List<Course> getAllUniqueCourses() {
            List<Course> allCourses = new ArrayList<>();
            for (Student student : students) {
                for (Course course : student.courses) {
                    if (!allCourses.contains(course)) {
                        allCourses.add(course);
                    }
                }
            }
            return allCourses;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter School name: ");
        String schoolName = scanner.nextLine();
        School school = new School(schoolName);
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        List<Course> allCourses = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter Student " + (i + 1) + " name: ");
            String studentName = scanner.nextLine();
            Student student = new Student(studentName);
            school.addStudent(student);
            System.out.print("Enter number of courses for " + studentName + ": ");
            int numCourses = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            for (int j = 0; j < numCourses; j++) {
                System.out.print("Enter Course " + (j + 1) + " name: ");
                String courseName = scanner.nextLine();
                Course course = getCourseByName(allCourses, courseName);
                if (course == null) {
                    course = new Course(courseName);
                    allCourses.add(course);
                }
                student.enrollInCourse(course);
            }
            System.out.println();
        }
        school.displayStudents();
        for (Student student : school.students) {
            student.viewCourses();
            System.out.println();
        }
        for (Course course : allCourses) {
            course.viewStudents();
            System.out.println();
        }
    }
    private static Course getCourseByName(List<Course> courses, String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }
}
