
import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    private int holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(int holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public int getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

class RiskAssessment {
    private int holderId;
    private String name;
    private double riskScore;

    public RiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public int getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public double getRiskScore() {
        return riskScore;
    }

    @Override
    public String toString() {
        return "ID: " + holderId + ", Name: " + name + ", Risk Score: " + riskScore;
    }
}

class RiskAssessmentProcessor {

    public static Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> holders) {
        return holders.stream()

                .filter(h -> "Life".equalsIgnoreCase(h.getPolicyType()) && h.getAge() > 60)

                .map(h -> new RiskAssessment(h.getHolderId(), h.getName(), h.getPremiumAmount() / h.getAge()))

                .sorted((r1, r2) -> Double.compare(r2.getRiskScore(), r1.getRiskScore()))

                .collect(Collectors.groupingBy(r -> r.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder(1, "Alice", 65, "Life", 40000),
                new PolicyHolder(2, "Bob", 70, "Life", 20000),
                new PolicyHolder(3, "Charlie", 68, "Health", 25000),
                new PolicyHolder(4, "Diana", 75, "Life", 10000),
                new PolicyHolder(5, "Ethan", 62, "Life", 5000),
                new PolicyHolder(6, "Fiona", 80, "Life", 60000)
        );

        Map<String, List<RiskAssessment>> categorized = assessRisk(holders);

        categorized.forEach((category, assessments) -> {
            System.out.println("\n" + category + ":");
            assessments.forEach(System.out::println);
        });
    }
}
