public class Transactions {
    private double amount;
    private String senderName;
    private String receiverName;


    public Transactions(double amount, String senderName, String receiverName){
        this.amount=amount;
        this.senderName=senderName;
        this.receiverName=receiverName;
    }

    public String toString() {
        return senderName + " -> " + receiverName + ": " + amount;
    }

}
