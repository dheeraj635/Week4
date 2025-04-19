
import java.util.*;

class VotingSystem {
    private HashMap<String, Integer> voteMap = new HashMap<>();
    private LinkedHashMap<String, Integer> linkedVoteMap = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVoteMap = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        linkedVoteMap.put(candidate, voteMap.get(candidate));
        sortedVoteMap.put(candidate, voteMap.get(candidate));
    }

    public void displayVotesInsertionOrder() {
        for (Map.Entry<String, Integer> entry : linkedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayVotesSortedOrder() {
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayVotes() {
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class VotingSystemDemo {
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Cast Vote");
            System.out.println("2. Display Votes (Insertion Order)");
            System.out.println("3. Display Votes (Sorted Order)");
            System.out.println("4. Display All Votes (Unordered)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Candidate Name: ");
                    String candidate = scanner.nextLine();
                    system.castVote(candidate);
                    System.out.println("Vote Casted.");
                    break;
                case 2:
                    system.displayVotesInsertionOrder();
                    break;
                case 3:
                    system.displayVotesSortedOrder();
                    break;
                case 4:
                    system.displayVotes();
                    break;
                case 5:
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



