import java.util.*;
public class University {
    String uniName;
    List<Faculty> faculties;
    List<Departments> departments;

    public University(String uniname){
        this.uniName=uniname;
        this.faculties=new ArrayList<>();
        this.departments=new ArrayList<>();
        System.out.println("university "+uniname+" created");
    }
    public void addDepartment(Departments dept) {
        this.departments.add(dept);
        System.out.println("Department '" + dept.getDeptName() + "' added to '" + this.uniName + "'.");
        System.out.println();
    }
    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
        System.out.println("Faculty '" + faculty.getFacName() + "' added to '" + this.uniName + "'.");
        System.out.println();
    }
    public List<Departments> getDepartments(){
        return departments;
    }
    public List<Faculty> getFaculties(){
        return faculties;
    }

    public class Faculty{
        String facName;
        String facId;
        static List<Faculty> allFaculties = new ArrayList<>();  // ✅ Fix: Initialize only once

        public Faculty(String facName,String facId){
            this.facId=facId;
            this.facName=facName;
            System.out.println("Faculty name "+this.facName+"  with id : "+this.facId+" created");
        }
        public void addFac(Faculty f){
            allFaculties.add(f);
        }
        public String getFacName(){
            return facName;
        }
        public String getFacId(){
            return facId;
        }
    }

    public class Departments{
        String deptName;
        String deptId;
        List<Faculty> faculty;

        public Departments(String deptName,String deptId){
            this.deptName=deptName;
            this.deptId=deptId;
            faculty=new ArrayList<>();
        }
        public String getDeptName(){
            return  deptName;
        }
        public String getDeptId(){
            return  deptId;
        }
        public void addFacultyToDept(Faculty f){
            this.faculty.add(f);
            System.out.println("Added "+f.facName+" to Dept "+this.deptId);
            System.out.println();
        }
        public List<Faculty> getFacultyInDept(){
            return this.faculty;
        }
        public void clearFaculty(){
            System.out.println("removing all faculty from dept");
            this.faculty.clear();
        }
    }

    public void deleteUni(){
        if(this.getDepartments()!=null){
            for(Departments d:this.getDepartments()){
                System.out.println(d.getDeptName()+" dept deleted.");
            }
            this.departments.clear();
            this.departments=null;
        }
        else{
            System.out.println(" dept list is empty.");
        }
        System.out.println("University and it's departments deleted.");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter university name: ");
        String uniName = sc.nextLine();
        University uni = new University(uniName);
        System.out.print("Enter number of departments: ");
        int numDepartments = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numDepartments; i++) {
            System.out.print("Enter department name: ");
            String deptName = sc.nextLine();
            System.out.print("Enter department id: ");
            String deptId = sc.nextLine();
            University.Departments dept = uni.new Departments(deptName, deptId);
            uni.addDepartment(dept);
            System.out.println();
        }
        System.out.print("Enter number of faculties: ");
        int numFaculties = sc.nextInt();
        sc.nextLine();
        List<Faculty> allFacs = new ArrayList<>();
        System.out.println();
        for (int i = 0; i < numFaculties; i++) {
            System.out.print("Enter faculty name: ");
            String facName = sc.nextLine();
            System.out.print("Enter faculty id: ");
            String facId = sc.nextLine();
            Faculty fac = uni.new Faculty(facName, facId);
            allFacs.add(fac);
            Faculty.allFaculties.add(fac);
            uni.addFaculty(fac);
            System.out.println();
        }
        for (Departments dept : uni.getDepartments()) {
            System.out.println("Assigning faculty to department: " + dept.getDeptName());
            System.out.print("Enter number of faculties to assign to this department: ");
            int count = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < count; j++) {
                System.out.print("Enter faculty id to add: ");
                String fid = sc.nextLine();
                for (Faculty f : allFacs) {
                    if (f.getFacId().equals(fid)) {
                        dept.addFacultyToDept(f);
                        break;
                    }
                }
            }
        }
        System.out.println("Displaying faculty list");
        for(Faculty f: Faculty.allFaculties){
            System.out.println("Faculty name: "+f.getFacName()+"\nid: "+f.getFacId());
        }
        System.out.println(" \nDisplaying dept list");
        for(Departments d: uni.getDepartments()){
            System.out.println("Dept name: "+d.getDeptName()+"\nid: "+d.getDeptId());
        }
        System.out.println(" \nDisplaying list of faculty in dept: ");
        System.out.println();
        for(Departments d:uni.getDepartments()){
            System.out.println(d.getDeptName());
            for(Faculty f:d.getFacultyInDept()){
                System.out.println("Faculty name: "+f.getFacName()+" \nfaculty id : "+f.facId);
            }
            System.out.println();
        }
        System.out.println(" \nDeleting the university ");
        uni.deleteUni();
        System.out.println("\nDisplaying faculty list after deletion");
        System.out.println();
        for(Faculty f:Faculty.allFaculties){
            if(f!=null){
                System.out.println("Faculty name: "+f.getFacName()+" \nid: "+f.getFacId());
            }
            else {
                System.out.println("Found a null Faculty object in the list.");
            }
        }
        sc.close();
    }
}
