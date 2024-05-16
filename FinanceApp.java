import java.util.*;

public class FinanceApp {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Personal Finance Manager ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. List Transactions");
            System.out.println("3. Display Summary by Category");
            System.out.println("4. Display Monthly Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter type (Income/Expense): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    manager.addTransaction(new Transaction(type, amount, description, date, category));
                    break;
                case 2:
                    manager.listTransactions();
                    break;
                case 3:
                    manager.displaySummaryByCategory();
                    break;
                case 4:
                    System.out.print("Enter month (YYYY-MM): ");
                    String month = scanner.nextLine();gitr
                    manager.displayMonthlyReport(month);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
