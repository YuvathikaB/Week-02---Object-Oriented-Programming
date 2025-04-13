import java.util.Scanner;
public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean booked;
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.booked = false;
    }
    public void bookTicket(String seatNumber, double price) {
        if (!booked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.booked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("This seat is already booked.");
        }
    }
    public void display() {
        if (booked) {
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("No ticket booked yet.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the movie name:");
        String movieName = sc.nextLine();
        MovieTicket ticket = new MovieTicket(movieName);
        ticket.display();
        while (true) {
            System.out.print("Enter the seat number you want to book: ");
            String seatNumber = sc.nextLine();
            System.out.print("Enter the price of the ticket:");
            double price = sc.nextDouble();
            sc.nextLine();
            ticket.bookTicket(seatNumber, price);
            ticket.display();
            System.out.print("Do you want to book another ticket? (y/n): ");
            String choice = sc.nextLine().toLowerCase();
            if (choice.equals("n")) {
                break;
            }
        }
    }
}