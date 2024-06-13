import java.util.Arrays;

public class Block{
    private int previousHash;
    private Transactions[] transactions;
    private int blockHash;


    /* A block of a blockchain should contain the hash of the previous block, the transaction details and the hash of the said block */
    public Block(int previousHash, Transactions[] transactions) {
        this.previousHash=previousHash;
        this.transactions=transactions;
        
        Object[] recipient = {Arrays.hashCode(transactions), previousHash};
        this.blockHash= Arrays.hashCode(recipient);
        
    }

    public int getPreviousHash(){
        return this.previousHash;
    }

    public Transactions[] getTransactions(){
        return this.transactions;
    }

    public int getBlockHash(){
        return this.blockHash;
    }

}