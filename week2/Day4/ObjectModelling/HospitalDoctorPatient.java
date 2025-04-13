import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class HospitalDoctorPatient {
    static class Doctor {
        private String name;
        private List<Patient> patients;
        public Doctor(String name) {
            this.name = name;
            this.patients = new ArrayList<>();
        }
        public String getName() {
            return name;
        }
        public void consult(Patient patient) {
            patients.add(patient);
        }
        public void showPatients() {
            System.out.println("Doctor " + name + " has the following patients:");
            for (Patient patient : patients) {
                System.out.println(patient.getName());
            }
        }
    }
    static class Patient {
        private String name;
        private List<Doctor> doctors;
        public Patient(String name) {
            this.name = name;
            this.doctors = new ArrayList<>();
        }
        public String getName() {
            return name;
        }
        public void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }
        public void showDoctors() {
            System.out.println("Patient " + name + " has consulted the following doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getName());
            }
        }
    }
    static class Hospital {
        private String name;
        private List<Doctor> doctors;
        private List<Patient> patients;
        public Hospital(String name) {
            this.name = name;
            this.doctors = new ArrayList<>();
            this.patients = new ArrayList<>();
        }
        public void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }
        public void addPatient(Patient patient) {
            patients.add(patient);
        }
        public void showDoctors() {
            System.out.println("Doctors in " + name + " Hospital:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getName());
            }
        }
        public void showPatients() {
            System.out.println("Patients in " + name + " Hospital:");
            for (Patient patient : patients) {
                System.out.println(patient.getName());
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Hospital name: ");
        String hospitalName = scanner.nextLine();
        Hospital hospital = new Hospital(hospitalName);
        System.out.print("Enter number of doctors: ");
        int numDoctors = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        for (int i = 0; i < numDoctors; i++) {
            System.out.print("Enter Doctor " + (i + 1) + " name: ");
            String doctorName = scanner.nextLine();
            Doctor doctor = new Doctor(doctorName);
            hospital.addDoctor(doctor);
        }
        System.out.println();
        System.out.print("Enter number of patients: ");
        int numPatients = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numPatients; i++) {
            System.out.print("Enter Patient " + (i + 1) + " name: ");
            String patientName = scanner.nextLine();
            Patient patient = new Patient(patientName);
            hospital.addPatient(patient);
        }
        System.out.println();
        for (Doctor doctor : hospital.doctors) {
            System.out.print("Enter number of patients for Doctor " + doctor.getName() + ": ");
            int numConsultations = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numConsultations; i++) {
                System.out.print("Enter Patient name for consultation: ");
                String patientName = scanner.nextLine();
                for (Patient patient : hospital.patients) {
                    if (patient.getName().equals(patientName)) {
                        doctor.consult(patient);
                        patient.addDoctor(doctor);
                    }
                }
            }
        }
        System.out.println("\nConsultation Details:");
        hospital.showDoctors();
        System.out.println();
        for (Doctor doctor : hospital.doctors) {
            doctor.showPatients();
            System.out.println();
        }
        for (Patient patient : hospital.patients) {
            patient.showDoctors();
            System.out.println();
        }
    }
}
