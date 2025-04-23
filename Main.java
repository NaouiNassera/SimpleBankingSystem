import java.util.Scanner;

public class Main {

    private static String accountName;
    private static double balance = 0.0;
    private static Scanner scanner  = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to simpleBank !");
        System.out.println("Enter your account name:");
        accountName = scanner.nextLine();

        System.out.println("\nHello, " + accountName + "!");

        boolean running = true;
        while(running){
            showMenu();
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Goodbye, " + accountName + "!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    public static void showMenu(){
        System.out.println("\n Choose an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("> ");
    }

    public static void deposit(){
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        if(amount > 0){
            balance += amount;
            System.out.printf("Deposit successful. New balance $%.2f%n",balance);
        }else{
            System.out.println("Amount must be greater than 0.");
        }
    }

    public static void withdraw(){
        System.out.print("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.printf("Withdrawal successful. New balance: $%.2f%n", balance);
        } else if(amount > balance) {
            System.out.println("Insufficient balance.");
        }else{
            System.out.println("Amount must be greater than 0.");
        }
    }

    public static void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", balance);
    }
}
