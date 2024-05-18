import java.util.*;
import java.io.*;
import java.nio.file.*;

public class FinanceManager {
    private List<Transaction> transactions;
    private final String dataFile = "transactions.txt";
    private double budgetLimit = 10000;

    public FinanceManager() {
        this.transactions = new ArrayList<>();
        loadTransactions();
    }

    public double getBudgetLimit() {
        return budgetLimit;
    }

    public void setBudgetLimit(double newLimit) {
        budgetLimit = newLimit;
    }

    private void loadTransactions() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            for (String line : lines) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    addTransaction(new Transaction(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading transactions from file.");
        }
    }

    public void saveTransactions() {
        try (PrintWriter out = new PrintWriter(new FileWriter(dataFile))) {
            for (Transaction transaction : transactions) {
                out.println(transaction.getType() + "," + transaction.getAmount() + "," + transaction.getDescription() + "," + transaction.getDate() + "," + transaction.getCategory());
            }
        } catch (IOException e) {
            System.out.println("Error saving transactions to file.");
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        checkOverspending();
        saveTransactions();
    }

    public void listTransactions() {
        transactions.forEach(System.out::println);
    }

    public void displaySummaryByCategory() {
        Map<String, Double> summary = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Transaction t : transactions) {
            summary.merge(t.getCategory(), t.getAmount(), Double::sum);
        }
        summary.forEach((k, v) -> System.out.println("Total for " + k + ": $" + v));
    }

    public void checkOverspending() {

        double totalExpense = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
        if (totalExpense > budgetLimit) {
            System.out.println("Alert: You have exceeded your budget limit of $" + budgetLimit);
        }
    }

    public void displayMonthlyReport(String month) {
        System.out.println("Report for " + month);
        transactions.stream()
                .filter(t -> t.getDate().startsWith(month))
                .forEach(System.out::println);
    }

}
