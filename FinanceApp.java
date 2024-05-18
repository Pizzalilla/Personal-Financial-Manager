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
            System.out.println("5. Set Budget Limit");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = getInputOption(scanner);;

            switch (option) {
                case 1:
                    addTransaction(manager, scanner);
                    break;
                case 2:
                    manager.listTransactions();
                    break;
                case 3:
                    manager.displaySummaryByCategory();
                    break;
                case 4:
                    System.out.print("Enter month (YYYY-MM): ");
                    String month = scanner.nextLine();
                    manager.displayMonthlyReport(month);
                    break;
                case 5:
                    System.out.print("Enter new budget limit or 'exit' to cancel: ");
                    double newLimit = getValidAmount(scanner);
                    if (newLimit != null) {
                        manager.setBudgetLimit(newLimit);
                        System.out.println("New budget limit set to $" + newLimit);
                    } else {
                        System.out.println("Setting budget limit cancelled.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
    private static int getInputOption(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input, please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addTransaction(FinanceManager manager, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter type (Income/Expense): ");
        String type = getValidType(scanner);
        System.out.print("Enter amount: ");
        double amount = getValidAmount(scanner);
        scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = getValidDate(scanner);
        System.out.print("Enter category: ");
        String category = scanner.nextLine().toLowerCase();
        manager.addTransaction(new Transaction(type, amount, description, date, category));
    }

    private static String getValidType(Scanner scanner) {
        String type = scanner.nextLine().trim();
        while (!type.equalsIgnoreCase("Income") && !type.equalsIgnoreCase("Expense")) {
            System.out.println("Invalid type. Please enter 'Income' or 'Expense':");
            type = scanner.nextLine().trim();
        }
        return type;
    }

    private static double getValidAmount(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount:");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static String getValidDate(Scanner scanner) {
        String date = scanner.nextLine().trim();
        while (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format:");
            date = scanner.nextLine().trim();
        }
        return date;
    }
}
