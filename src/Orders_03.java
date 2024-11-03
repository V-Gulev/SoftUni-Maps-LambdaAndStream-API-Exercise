import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> productQuantity = new LinkedHashMap<>();
        Map<String, Double> productPrice = new LinkedHashMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("buy")) {
                break;
            }
            String[] parts = input.split(" ");
            String product = parts[0];
            double price = Double.parseDouble(parts[1]);
            int quantity = Integer.parseInt(parts[2]);

            if (!productQuantity.containsKey(product)) {
                productQuantity.put(product, quantity);
            } else {
                productQuantity.put(product, productQuantity.get(product) + quantity);
            }

            productPrice.put(product, price);
        }

        for (Map.Entry<String, Integer> entry : productQuantity.entrySet()) {
            double totalPrice = entry.getValue() * productPrice.get(entry.getKey());
            System.out.printf("%s -> %.2f\n", entry.getKey(), totalPrice);
        }

    }
}
