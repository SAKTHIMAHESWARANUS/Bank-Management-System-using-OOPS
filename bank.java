import java.util.*;

class bank {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name :");
        String str = sc.nextLine();
        System.out.println("Enter Your Num :");
        String num = sc.nextLine();
        System.out.println("Enter Existing Amount :");
        Double existing_amount = sc.nextDouble();
        Customer customer = new Customer(str, num);
        customer.display();
        Account account = new Account(existing_amount);
        System.out.println("\nEnter 1 to withdraw and 2 to deposit");
        Double wa = 0.0;
        Double da = 0.0;
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Enter Amount to be withdrawn :");
            double with_amount = sc.nextDouble();
            account.withdraw(with_amount);
            wa = with_amount;
        } else {
            System.out.println("Enter Amount to be deposited :");
            double dep_amount = sc.nextDouble();
            account.deposit(dep_amount);
            da = dep_amount;
        }
        System.out.println("balance : \n" + account.getaccount_balance());
        String date = sc.nextLine();
        Transaction trans = new Transaction(date);
        trans.findchoice(choice, wa, da);

    }
}

class Customer {
    private String customer_name;
    private String contact_number;

    public Customer(String customer_name, String contact_number) {

        this.customer_name = customer_name;
        this.contact_number = contact_number;

    }

    public String getCustomer_name() {
        return this.customer_name;
    }

    public String getContact_number() {
        return this.contact_number;
    }

    public void setCustomer_name() {
        this.customer_name = customer_name;
    }

    public void setContact_number() {
        this.contact_number = contact_number;
    }

    public void display() {
        System.out.println();
        System.out.println("Customer : " + this.customer_name);
        System.out.println();
        System.out.println("Contact: " + this.contact_number);

    }

}

class Account {
    private double acc_balance = 0.0;

    public Account(double acc_balance) {
        this.acc_balance = acc_balance;
    }

    public double getaccount_balance() {
        return this.acc_balance;
    }

    public void setaccount_balance() {
        this.acc_balance = acc_balance;
    }

    public void withdraw(double amount) {
        if (amount > this.acc_balance) {
            System.out.println("Insuffcient Balance");
            return;
        }
        this.acc_balance -= amount;
        System.out.println("Amount withdrawn : " + amount);
        System.out.println();
    }

    public void deposit(double amount) {
        this.acc_balance += amount;
        System.out.println("Amount deposited : " + amount);
        System.out.println();
    }
}

class Transaction {
    private String date;

    public Transaction(String date) {
        this.date = date;
    }

    public String gettrans_date() {
        return this.date;
    }

    public void settrans_date() {
        this.date = date;
    }

    public void findchoice(int choice, double with_rate, double dep_rate) {
        System.out.println("Last Transaction\n");
        if (choice == 1) {
            System.out.println("Ruppees " + with_rate + " was withdrawn Recently");
        } else {
            System.out.println("Ruppees " + dep_rate + " was deposited recently");
        }
    }
}
