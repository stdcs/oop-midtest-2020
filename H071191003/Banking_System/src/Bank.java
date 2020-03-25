import java.util.ArrayList;
import java.io.Console;
import java.util.HashMap;
import java.util.HashSet;

public class Bank {
    private String bankName;
    private int bankCode;
    private HashMap<Integer, Customer> customers ;
    private HashSet<Integer> registeredKTP;

    public Bank(String bankName, int bankCode, HashMap<Integer, Customer> customers, HashSet<Integer> registeredKTP) {
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.customers = customers;
        this.registeredKTP = registeredKTP;
    }
    private void addCustomer(String username, char[] password, int accountNumber, int KTPNumber) {
        customers.put(accountNumber ,new Customer(username, password, accountNumber, KTPNumber));
    }

    public void registerCustomer() {
        Console input = System.console();
        int KTPNumber= Integer.parseInt(input.readLine("Input KTP number : "));
        if (registeredKTP.contains(KTPNumber)){
            System.out.println("KTP number has already been registered!");
            return;
        }
        String username = input.readLine("Input full name : ");
        char[] password = input.readPassword("Input Password : ");
        System.out.println(new String(password));
        int accountNumber = Integer.parseInt( String.format("%d%05d", bankCode, customers.size()) );
        addCustomer(username, password, accountNumber, KTPNumber);
        java.util.Arrays.fill(password, ' ');
    }

    public String getBankName() {
        return bankName;
    }

    public int getBankCode() {
        return bankCode;
    }

    public Customer getCustomer(int accountNumber) {
        return customers.get(accountNumber);
    }
}
