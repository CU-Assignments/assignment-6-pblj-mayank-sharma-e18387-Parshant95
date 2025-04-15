import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.Entry;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + category + "): $" + price;
    }
}

class hard {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("Shirt", "Clothing", 50),
            new Product("Jeans", "Clothing", 70),
            new Product("Refrigerator", "Appliances", 1500),
            new Product("Microwave", "Appliances", 300)
        );

        Map<String, List<Product>> grouped = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println();

        Map<String, Optional<Product>> mostExpensive = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));
        mostExpensive.forEach((k, v) -> System.out.println(k + " -> " + v.get()));

        System.out.println();

        double avg = products.stream().mapToDouble(Product::getPrice).average().orElse(0.0);
        System.out.println("Average Price: $" + avg);
    }
}
