import java.util.*;
public class Patient {
    private static String hospitalName;
    private static int totalPatients =0;
    private String name;
    private int age;
    private String ailment;
    private final int patientID;
    public Patient(int patientID,String name, int age, String ailment){
        this.patientID = patientID;
        this.name =name;
        this.age=age;
        this.ailment =ailment;
        totalPatients++;
    }
    public static void getTotalPatients(){
        System.out.println("Total patients: " + totalPatients);
    }
    public void display() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("patient Name: " + name);
            System.out.println("Age: "+age);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Ailment: " + ailment);
        }
    }
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hospital name: ");
        hospitalName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter number of patients: ");
        int numPatients = scanner.nextInt();
        scanner.nextLine();
        Patient[] patients = new Patient[numPatients];
        for (int i = 0; i < numPatients; i++) {
            System.out.println("\nEnter details for patient " + (i + 1) + ":");
            System.out.print("Enter patient ID: ");
            int patientID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter ailment: ");
            String ailment = scanner.nextLine();
            patients[i] = new Patient(patientID,name,age,ailment);
            System.out.println();
        }
        for (Patient patient : patients) {
            patient.display();
            System.out.println();
        }
        Patient.getTotalPatients();
    }
}

