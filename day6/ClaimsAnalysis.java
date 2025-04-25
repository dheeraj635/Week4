
import java.util.*;
import java.util.stream.Collectors;

class Claim {
    private int claimId;
    private String policyNumber;
    private double claimAmount;
    private Date claimDate;
    private String status;

    public Claim(int claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public int getClaimId() {
        return claimId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public String getStatus() {
        return status;
    }
}

class ClaimAggregate {
    private double totalClaimAmount;
    private double averageClaimAmount;

    public ClaimAggregate(double totalClaimAmount, double averageClaimAmount) {
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }

    public double getTotalClaimAmount() {
        return totalClaimAmount;
    }

    public double getAverageClaimAmount() {
        return averageClaimAmount;
    }

    @Override
    public String toString() {
        return "Total: " + totalClaimAmount + ", Average: " + averageClaimAmount;
    }
}

class ClaimsAnalysis {

    public static List<Map.Entry<String, ClaimAggregate>> getTopPolicies(List<Claim> claims) {
        return claims.stream() 
                .filter(c -> "Approved".equalsIgnoreCase(c.getStatus()) && c.getClaimAmount() > 5000)
                
                .collect(Collectors.groupingBy(
                        Claim::getPolicyNumber, 
                        Collectors.summarizingDouble(Claim::getClaimAmount))) 

                .entrySet().stream()
                .map(entry -> {
                    String policyNumber = entry.getKey();
                    DoubleSummaryStatistics stats = entry.getValue();
                    ClaimAggregate aggregate = new ClaimAggregate(stats.getSum(), stats.getAverage());
                    return new AbstractMap.SimpleEntry<>(policyNumber, aggregate);
                })

                .sorted((e1, e2) -> Double.compare(e2.getValue().getTotalClaimAmount(), e1.getValue().getTotalClaimAmount()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim(1, "P123", 7000, new Date(), "Approved"),
                new Claim(2, "P123", 2000, new Date(), "Denied"),
                new Claim(3, "P124", 15000, new Date(), "Approved"),
                new Claim(4, "P125", 8000, new Date(), "Approved"),
                new Claim(5, "P124", 5000, new Date(), "Approved"),
                new Claim(6, "P126", 12000, new Date(), "Approved"),
                new Claim(7, "P125", 6000, new Date(), "Approved")
        );

        List<Map.Entry<String, ClaimAggregate>> topPolicies = getTopPolicies(claims);

        System.out.println("Top 3 Policies with Highest Total Claim Amounts:");
        topPolicies.forEach(entry -> {
            System.out.println("Policy: " + entry.getKey() + ", " + entry.getValue());
        });
    }
}
