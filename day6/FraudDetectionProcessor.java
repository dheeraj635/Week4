
import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private String transactionId;
    private String policyNumber;
    private double amount;
    private Date transactionDate;
    private boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}

class FraudStats {
    private int fraudCount;
    private double totalFraudAmount;

    public FraudStats(int fraudCount, double totalFraudAmount) {
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    public int getFraudCount() {
        return fraudCount;
    }

    public double getTotalFraudAmount() {
        return totalFraudAmount;
    }

    @Override
    public String toString() {
        return "Fraud Count: " + fraudCount + ", Total Fraud Amount: $" + totalFraudAmount;
    }
}

class FraudDetectionProcessor {

    public static Map<String, FraudStats> detectFraud(List<Transaction> transactions) {
        Map<String, List<Transaction>> groupedFraud = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        Map<String, FraudStats> fraudStatsMap = new HashMap<>();
        for (Map.Entry<String, List<Transaction>> entry : groupedFraud.entrySet()) {
            int count = entry.getValue().size();
            double total = entry.getValue().stream().mapToDouble(Transaction::getAmount).sum();
            fraudStatsMap.put(entry.getKey(), new FraudStats(count, total));
        }

        return fraudStatsMap;
    }

    public static void generateAlerts(Map<String, FraudStats> fraudStatsMap) {
        System.out.println("🚨 Fraud Alerts:");
        fraudStatsMap.forEach((policyNumber, stats) -> {
            if (stats.getFraudCount() > 5 || stats.getTotalFraudAmount() > 50000) {
                System.out.println("Policy: " + policyNumber + " => " + stats);
            }
        });
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P123", 15000, new Date(), true),
                new Transaction("T002", "P123", 20000, new Date(), true),
                new Transaction("T003", "P123", 18000, new Date(), true),
                new Transaction("T004", "P123", 22000, new Date(), true),
                new Transaction("T005", "P123", 25000, new Date(), true),
                new Transaction("T006", "P123", 30000, new Date(), true),
                new Transaction("T007", "P456", 12000, new Date(), true),
                new Transaction("T008", "P456", 11000, new Date(), true),
                new Transaction("T009", "P789", 9000, new Date(), true),  
                new Transaction("T010", "P456", 60000, new Date(), false)
        );

        Map<String, FraudStats> fraudResults = detectFraud(transactions);
        generateAlerts(fraudResults);
    }
}
