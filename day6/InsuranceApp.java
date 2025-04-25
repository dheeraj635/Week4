
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class InsurancePolicy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", HolderName: " + holderName + ", Premium: $" + premiumAmount;
    }
}

public class InsuranceApp {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P1001", "Alice Smith", 1300),
            new InsurancePolicy("P1002", "Bob Brown", 900),
            new InsurancePolicy("P1003", "Charlie Smith", 1800),
            new InsurancePolicy("P1004", "Diana Prince", 2200),
            new InsurancePolicy("P1005", "Evan Davis", 1000),
            new InsurancePolicy("P1006", "Alice Johnson", 1800),
            new InsurancePolicy("P1007", "Frank Castle", 2500)
        );

        System.out.println("1. Policies with Premium > $1200:");
        policies.stream()
            .filter(p -> p.getPremiumAmount() > 1200)
            .forEach(System.out::println);

        System.out.println("\n2. Policies Sorted by Holder Name:");
        policies.stream()
            .sorted(Comparator.comparing(InsurancePolicy::getHolderName))
            .forEach(System.out::println);

        System.out.println("\n3. Total Premium Amount:");
        double totalPremium = policies.stream()
            .mapToDouble(InsurancePolicy::getPremiumAmount)
            .sum();
        System.out.println("Total Premium: $" + totalPremium);

        System.out.println("\n4. Print Policy Details:");
        policies.forEach(p -> System.out.println(p));

        System.out.println("\n5. Premiums between $1000 and $2000:");
        policies.stream()
            .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
            .forEach(System.out::println);

        System.out.println("\n6. Policy with Highest Premium:");
        policies.stream()
            .max(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
            .ifPresent(System.out::println);

        System.out.println("\n7. Group Policies by Holder Name Initial:");
        Map<Character, List<InsurancePolicy>> grouped = policies.stream()
            .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));
        grouped.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach(System.out::println);
        });

        System.out.println("\n8. Average Premium:");
        policies.stream()
            .mapToDouble(InsurancePolicy::getPremiumAmount)
            .average()
            .ifPresent(avg -> System.out.println("Average Premium: $" + avg));

        System.out.println("\n9. Sorted by Premium (Ascending):");
        policies.stream()
            .sorted(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
            .forEach(System.out::println);

        System.out.println("\n10. Any Policy with Premium > $2000:");
        boolean hasExpensivePolicy = policies.stream()
            .anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("Exists: " + hasExpensivePolicy);

        System.out.println("\n11. Count Policies in Premium Ranges:");
        Map<String, Long> premiumRanges = policies.stream()
            .collect(Collectors.groupingBy(p -> {
                double amt = p.getPremiumAmount();
                if (amt <= 1000) return "$0-$1000";
                else if (amt <= 2000) return "$1001-$2000";
                else return ">$2000";
            }, Collectors.counting()));
        premiumRanges.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n12. Unique Holder Names:");
        policies.stream()
            .map(InsurancePolicy::getHolderName)
            .distinct()
            .forEach(System.out::println);

        System.out.println("\n13. Holder Name contains 'Smith':");
        policies.stream()
            .filter(p -> p.getHolderName().toLowerCase().contains("smith"))
            .forEach(System.out::println);

        System.out.println("\n14. Map of Policy Number to Premium:");
        Map<String, Double> policyMap = policies.stream()
            .collect(Collectors.toMap(InsurancePolicy::getPolicyNumber, InsurancePolicy::getPremiumAmount));
        policyMap.forEach((k, v) -> System.out.println(k + " -> $" + v));

        System.out.println("\n15. Most Frequent Words in Text Corpus:");
        String text = "The quick brown fox jumps over the lazy dog. The fox was quick and the dog was lazy.";
        List<String> words = Arrays.stream(text.toLowerCase().replaceAll("[^a-z ]", "").split(" "))
            .collect(Collectors.toList());

        Map<String, Long> wordFreq = words.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordFreq.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(5)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("\n16. Second Most Frequent Word:");
        wordFreq.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .skip(1)
            .limit(1)
            .forEach(entry -> System.out.println("Second Most Frequent Word: " + entry.getKey() + " -> " + entry.getValue()));
    }
}
