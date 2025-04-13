import java.util.*;
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    public abstract double calculateBill();
    public String getPatientDetails() {
        return "Patient ID: " + patientId + "\nName: " + name + "\nAge: " + age;
    }
    public String getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> medicalHistory;
    private String diagnosis;
    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate, String diagnosis) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.diagnosis = diagnosis;
        this.medicalHistory = new ArrayList<>();
    }
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(medicalHistory);
    }
    public String getDiagnosis() {
        return diagnosis;
    }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalHistory;
    private String diagnosis;
    public OutPatient(String patientId, String name, int age, double consultationFee, String diagnosis) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.diagnosis = diagnosis;
        this.medicalHistory = new ArrayList<>();
    }
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(medicalHistory);
    }
    public String getDiagnosis() {
        return diagnosis;
    }
}
public class HospitalManagementSystem {
    public static void processPatient(Patient patient) {
        System.out.println("\nPatient Summary : ");
        System.out.println();
        System.out.println(patient.getPatientDetails());
        System.out.println("Total Bill: " + patient.calculateBill());
        if (patient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) patient;
            System.out.println("Medical Records:");
            for (String entry : record.viewRecords()) {
                System.out.println(" - " + entry);
            }
            if (patient instanceof InPatient) {
                System.out.println("Diagnosis: " + ((InPatient) patient).getDiagnosis());
            } else if (patient instanceof OutPatient) {
                System.out.println("Diagnosis: " + ((OutPatient) patient).getDiagnosis());
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter patient type (InPatient/OutPatient): ");
        String type = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        Patient patient = null;
        if (type.equalsIgnoreCase("InPatient")) {
            System.out.print("Enter days admitted: ");
            int days = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter daily rate: ");
            double rate = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter diagnosis: ");
            String diagnosis = scanner.nextLine();
            InPatient inPatient = new InPatient(id, name, age, days, rate, diagnosis);
            inPatient.addRecord("Admitted for observation");
            inPatient.addRecord("Received IV treatment");
            patient = inPatient;
        } else if (type.equalsIgnoreCase("OutPatient")) {
            System.out.print("Enter consultation fee: ");
            double fee = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter diagnosis: ");
            String diagnosis = scanner.nextLine();
            OutPatient outPatient = new OutPatient(id, name, age, fee, diagnosis);
            outPatient.addRecord("Visited for routine checkup");
            outPatient.addRecord("Prescribed vitamins");
            patient = outPatient;
        } else {
            System.out.println("Invalid patient type.");
        }
        if (patient != null) {
            processPatient(patient);
        }
        scanner.close();
    }
}
