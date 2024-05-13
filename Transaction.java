public class Transaction {
    private String type;
    private double amount;
    private String description;
    private String date;
    private String category;

    public Transaction(String type, double amount, String description, String date, String category) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return type + ": $" + amount + " on " + date + " for " + description + " [" + category + "]";
    }
}
