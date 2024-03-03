import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class InvoiceItem {
    private Product product;
    private int quantity;

    public InvoiceItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-20s %d x $%.2f = $%.2f", product.getName(), quantity, product.getPrice(), getTotal());
    }
}

class Invoice {
    private ArrayList<InvoiceItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        items.add(new InvoiceItem(product, quantity));
    }

    public double getTotal() {
        double total = 0;
        for (InvoiceItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice:\n");
        for (InvoiceItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}

public class InvoiceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some sample products
        Product product1 = new Product("Item 1", 10.0);
        Product product2 = new Product("Item 2", 20.0);
        Product product3 = new Product("Item 3", 30.0);

        // Create an invoice
        Invoice invoice = new Invoice();

        // Add products to the invoice
        System.out.println("Enter the quantity for each item:");
        System.out.print("Item 1: ");
        int quantity1 = scanner.nextInt();
        System.out.print("Item 2: ");
        int quantity2 = scanner.nextInt();
        System.out.print("Item 3: ");
        int quantity3 = scanner.nextInt();

        invoice.addProduct(product1, quantity1);
        invoice.addProduct(product2, quantity2);
        invoice.addProduct(product3, quantity3);

        // Display the invoice
        System.out.println("\n" + invoice);
    }
}
