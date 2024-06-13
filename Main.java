import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Block> blockchain= new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Transactions genesisTransaction = new Transactions( 5000, "MajorLeagueHacking", "Ashley");
        Transactions[] genesisTransactions = {genesisTransaction};

        //why cant it instanciate from the class Block nor use its defined method??
        Block genesisBlock = new Block(0, genesisTransactions);

         // Add Genesis Block to Blockchain
         Blockchain.add(genesisBlock);
         System.out.println("Genesis Block created and added to the blockchain.");

         while (true) {
            System.out.println("\nWould you like to create a new block? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }

            System.out.println("Enter sender name:");
            String sender = scanner.nextLine();

            System.out.println("Enter receiver name:");
            String receiver = scanner.nextLine();

            System.out.println("Enter amount:");
            double amount = scanner.nextDouble();
            scanner.nextLine(); 

            Transactions newTransaction = new Transactions(amount, sender, receiver);
            Transactions[] newTransactions = {newTransaction};
            Block previousBlock = blockchain.get(blockchain.size() - 1);
            Block newBlock = new Block(previousBlock.getBlockHash(), newTransactions);
            blockchain.add(newBlock);

            System.out.println("New block created and added to the blockchain.");

            System.out.println("\nWould you like to see the details of this new block? (yes/no)");
            String viewResponse = scanner.nextLine();
            if (viewResponse.equalsIgnoreCase("yes")) {
                 // Print details of the genesis block
                System.out.println("Block Hash: " + newBlock.getBlockHash());
                System.out.println("Previous Hash: " + newBlock.getPreviousHash());
                for (Transactions transaction : newBlock.getTransactions()) {
                    System.out.println("Transaction: " + transaction);
                }
            }
        }

        scanner.close();
    
    }
}


