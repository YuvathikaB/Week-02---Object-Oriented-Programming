import java.util.Scanner;
class Device {
    String deviceId;
    String status;
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
class Thermostat extends Device {
    int temperatureSetting;
    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
public class SmartHomeSystemSingle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Thermostat Device ID: ");
        String deviceId = scanner.nextLine();
        System.out.print("Enter Thermostat status : ");
        String status = scanner.nextLine();
        System.out.print("Enter Temperature Setting (°C): ");
        int temperatureSetting = scanner.nextInt();
        Thermostat thermostat = new Thermostat(deviceId, status, temperatureSetting);
        System.out.println();
        thermostat.displayStatus();
        scanner.close();
    }
}
