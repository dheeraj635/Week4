
import java.util.*;
import java.time.*;

class Policy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolderName + ", Expiry: " + expiryDate;
    }
}

class InsurancePolicyManagementSystem {
    private HashMap<String, Policy> hashMap = new HashMap<>();
    private LinkedHashMap<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        treeMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public List<Policy> listPoliciesExpiringInNext30Days() {
        LocalDate today = LocalDate.now();
        LocalDate in30Days = today.plusDays(30);
        List<Policy> expiringPolicies = new ArrayList<>();
        treeMap.subMap(today, true, in30Days, true).values().forEach(expiringPolicies::addAll);
        return expiringPolicies;
    }

    public List<Policy> listPoliciesByPolicyHolder(String policyHolderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : linkedHashMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(entry.getKey());
                List<Policy> policies = treeMap.get(entry.getValue().getExpiryDate());
                if (policies != null) {
                    policies.removeIf(p -> p.getPolicyNumber().equals(entry.getKey()));
                    if (policies.isEmpty()) {
                        treeMap.remove(entry.getValue().getExpiryDate());
                    }
                }
            }
        }
    }
}

public class InsurancePolicy {
    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Policy");
            System.out.println("2. Retrieve Policy by Number");
            System.out.println("3. List Policies Expiring in 30 Days");
            System.out.println("4. List Policies by Policyholder");
            System.out.println("5. Remove Expired Policies");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Policy Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter Policy Holder Name: ");
                    String holder = scanner.nextLine();
                    System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();
                    system.addPolicy(new Policy(number, holder, LocalDate.parse(date)));
                    System.out.println("Policy Added.");
                    break;
                case 2:
                    System.out.print("Enter Policy Number: ");
                    String searchNumber = scanner.nextLine();
                    Policy policy = system.getPolicyByNumber(searchNumber);
                    if (policy != null) {
                        System.out.println(policy);
                    } else {
                        System.out.println("Policy Not Found.");
                    }
                    break;
                case 3:
                    List<Policy> expiring = system.listPoliciesExpiringInNext30Days();
                    if (expiring.isEmpty()) {
                        System.out.println("No Policies Expiring in Next 30 Days.");
                    } else {
                        expiring.forEach(System.out::println);
                    }
                    break;
                case 4:
                    System.out.print("Enter Policy Holder Name: ");
                    String searchHolder = scanner.nextLine();
                    List<Policy> policies = system.listPoliciesByPolicyHolder(searchHolder);
                    if (policies.isEmpty()) {
                        System.out.println("No Policies Found for Policyholder.");
                    } else {
                        policies.forEach(System.out::println);
                    }
                    break;
                case 5:
                    system.removeExpiredPolicies();
                    System.out.println("Expired Policies Removed.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}



