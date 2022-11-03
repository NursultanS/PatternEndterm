import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.println("Strategy pattern: ");
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PayPal" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = reader.readLine();
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }
            order.processOrder(strategy);

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
        System.out.println(" ");
        System.out.println("State pattern: ");
        DeliveryContext ctx = new DeliveryContext(null, "Memory");

        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
        System.out.println(" ");
        System.out.println("Singleton pattern: ");
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();
        System.out.println("Hashcode of first user is "
                + x.hashCode());
        System.out.println("Hashcode of second user is "
                + y.hashCode());
        System.out.println("Hashcode of third user is "
                + z.hashCode());

        System.out.println(" ");
        System.out.println("Observer pattern: ");

        Subject subject = new MaillingObject(new ArrayList<Observer>(), "the newsletter receipt of goods");
        Observer observer = new SMSUsers(subject, "John");
        observer.subscribe();
        System.out.println();
        Observer observer2 = new SMSUsers(subject, "Tim");
        observer2.subscribe();
        Mailling cObject = ((Mailling)subject);
        cObject.setDesc("Welcome to subscribing online store");
        System.out.println();
        observer2.unSubscribe();
        System.out.println();
        cObject.setDesc("New products have arrived!");
        System.out.println();
        Observer observer3 = new SMSUsers(subject, "Fibi");
        observer3.subscribe();
        System.out.println(" ");
        System.out.println("Decorator pattern: ");
        String salaryRecords = "Name,Email\nJohn,John@mail.ru \nFibi,Fibi@mail.ru";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/OutputMain.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/OutputMain.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }

}


