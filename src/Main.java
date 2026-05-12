public class Main {
    public static void main(String[] args) {
        System.out.println("--- Exercise 1 ---");
        UserValidator validator = new UserValidator();
        validator.addRule(form -> form.email().contains("@"));
        validator.addRule(form -> form.password().length() >= 8);
        validator.addRule(form -> form.age() >= 18);

        UserForm form = new UserForm("anna@example.com", "secure123", 20);
        System.out.println("Form is valid: " + validator.isValid(form));
        System.out.println();

        System.out.println("--- Exercise 2 ---");
        ServiceOrder serviceOrder = new ServiceOrder("Alpha Company", 10, 120.0);
        PriceCalculator calculator = new PriceCalculator();

        PriceStrategy standard = o -> o.hours() * o.hourRate();
        PriceStrategy discount = o -> o.hours() * o.hourRate() * 0.90;
        PriceStrategy weekend = o -> o.hours() * o.hourRate() * 1.25;

        System.out.println("Standard price: " + calculator.calculate(serviceOrder, standard));
        System.out.println("Discount price: " + calculator.calculate(serviceOrder, discount));
        System.out.println("Weekend price: " + calculator.calculate(serviceOrder, weekend));
        System.out.println();

        System.out.println("--- Exercise 3 ---");
        Order order = new Order("ORD-100", "Anna Kowalska");
        order.addItem(new Order.OrderItem("Keyboard", 249.99, 1));
        order.addItem(new Order.OrderItem("Mouse", 99.99, 2));

        OrderSummary summary = new OrderSummary(
                order.getOrderNumber(),
                order.getCustomerName(),
                order.total()
        );
        System.out.println(summary);
        System.out.println();

        System.out.println("--- Exercise 4 ---");
        LibraryAccount account = new LibraryAccount("John Smith", 3, 5);
        LibraryAccount.FineCalculator fineCalculator = account.new FineCalculator();
        double fine = fineCalculator.calculate();

        MessagePrinter printer = message -> System.out.println("[LIBRARY] " + message);
        printer.print("Reader: " + account.getReaderName() + ", fine: " + fine + " PLN");
    }
}
