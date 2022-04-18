package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner=new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        boolean continuation=true;
        do {
            System.out.print("Choose an option (1-Add product/2-List products/Any other to quit): ");
            int choice = scanner.nextInt();
            int i = 0;
            switch (choice) {
                case 1:
                    System.out.println("-----Product #" + (i + 1) + " data-----");
                    System.out.print("Common, used or imported (c/u/i)? ");
                    char type = scanner.next().toLowerCase().charAt(0);
                    if (type == 'u' || type == 'i' || type == 'c') {
                        System.out.print("Name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.print("Price: ");
                        Double price = scanner.nextDouble();
                        if (type == 'u') {
                            System.out.print("Manufacture date (DD/MM/YYYY): ");
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            scanner.nextLine();
                            Date date = sdf.parse(scanner.nextLine());
                            list.add(new UsedProduct(name, price, date));
                        } else if (type == 'i') {
                            System.out.print("Customs Fee: ");
                            Double customsFee = scanner.nextDouble();
                            list.add(new ImportedProduct(name, price, customsFee));
                        } else if (type == 'c') {
                            list.add(new Product(name, price));
                        }
                    }else {
                        System.out.println("Invalid option!");
                    }
                    break;
                case 2:
                    if (list.isEmpty()){
                        System.out.println("No product registered.");
                    }
                    for (Product p : list
                    ) {
                        System.out.println(p.priceTag());
                    }
                    break;
                default:
                    continuation=false;
            }

        }while (continuation);

    }
}
