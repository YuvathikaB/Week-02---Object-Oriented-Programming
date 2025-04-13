import java.util.Scanner;
class Product {
    String productName;
    double price;
    static int  totalProducts;
    Product(String productName,double price){
        this.productName=productName;
        this.price=price;
        totalProducts++;
    }
    void displayProductDetails(){
        System.out.println("Product Name : "+productName);
        System.out.println("Product price : "+price);
    }
    static void  displayTotalProducts(){
        System.out.println("Total products : "+totalProducts);
    }
    public static void main(String[] args){
            Scanner scanner=new Scanner(System.in);
            System.out.print("How many products do you want to create? ");
            int numProducts = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numProducts; i++) {
                System.out.print("Enter the name of product " + (i + 1) + ": ");
                String name = scanner.nextLine();
                System.out.print("Enter the price of product " + (i + 1) + ": ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                Product product = new Product(name, price);
                product.displayProductDetails();
                System.out.println();
            }
            Product.displayTotalProducts();
    }
}

