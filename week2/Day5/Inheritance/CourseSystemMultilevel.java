import java.util.Scanner;
class Course{
    String courseName;
    String duration;
    public Course(String courseName,String duration){
        this.courseName=courseName;
        this.duration=duration;
    }
    public void displayCourseDetails(){
        System.out.println("Course Name: "+courseName);
        System.out.println("Duration: "+duration+" months");
    }
}
class OnlineCourse extends Course{
    String platform;
    boolean isRecorded;
    public OnlineCourse(String courseName,String duration,String platform,boolean isRecorded){
        super(courseName,duration);
        this.platform=platform;
        this.isRecorded=isRecorded;
    }
    @Override
    public void displayCourseDetails(){
        super.displayCourseDetails();
        System.out.println("Platform: "+platform);
        System.out.println("Recorded: "+(isRecorded?"Yes":"No"));
    }
}
class PaidOnlineCourse extends OnlineCourse{
    double fee;
    double discount;
    public PaidOnlineCourse(String courseName,String duration,String platform,boolean isRecorded,double fee,double discount){
        super(courseName,duration,platform,isRecorded);
        this.fee=fee;
        this.discount=discount;
    }
    @Override
    public void displayCourseDetails(){
        super.displayCourseDetails();
        System.out.println("Fee: "+fee);
        System.out.println("Discount: "+discount+"%");
        System.out.println("Final Fee after Discount: "+(fee-(fee*discount/100)));
    }
}
public class CourseSystemMultilevel {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter details for Online Course:");
        System.out.print("Enter Course Name: ");
        String onlineCourseName=scanner.nextLine();
        System.out.print("Enter Duration (months): ");
        String onlineDuration=scanner.nextLine();
        System.out.print("Enter Platform: ");
        String onlinePlatform=scanner.nextLine();
        System.out.print("Is the course recorded (true/false): ");
        boolean isOnlineRecorded=scanner.nextBoolean();
        scanner.nextLine();
        OnlineCourse onlineCourse=new OnlineCourse(onlineCourseName,onlineDuration,onlinePlatform,isOnlineRecorded);
        System.out.println("\nEnter details for Paid Online Course:");
        System.out.print("Enter Course Name: ");
        String paidCourseName=scanner.nextLine();
        System.out.print("Enter Duration (months): ");
        String paidDuration=scanner.nextLine();
        System.out.print("Enter Platform: ");
        String paidPlatform=scanner.nextLine();
        System.out.print("Is the course recorded (true/false): ");
        boolean isPaidRecorded=scanner.nextBoolean();
        System.out.print("Enter Fee: ");
        double fee=scanner.nextDouble();
        System.out.print("Enter Discount Percentage: ");
        double discount=scanner.nextDouble();
        PaidOnlineCourse paidOnlineCourse=new PaidOnlineCourse(paidCourseName,paidDuration,paidPlatform,isPaidRecorded,fee,discount);
        System.out.println("\nCourse Details (Online Course):");
        onlineCourse.displayCourseDetails();
        System.out.println("\nCourse Details (Paid Online Course):");
        paidOnlineCourse.displayCourseDetails();
        scanner.close();
    }
}
