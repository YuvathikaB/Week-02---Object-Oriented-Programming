import java.util.*;
public class PalindromeChecker {
    String text;
    PalindromeChecker(String text){
        this.text=text;
    }
    public boolean palindrome(){
        String reverse=new StringBuilder(text).reverse().toString();
        if(reverse.equalsIgnoreCase(text)){
            return true;
        }
        return false;
    }
    public void display(){
        if(palindrome()){ System.out.println("Palindrome");
        }else{
            System.out.println("Not a palindrome");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string : ");
        String text=sc.next();
        PalindromeChecker pal= new PalindromeChecker(text);
        pal.display();
    }
}
