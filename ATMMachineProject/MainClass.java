package ATMMachineProject;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        AtmOperationInterface op = new AtmOperationImplementation();

        int accountNumber = 123456;
        int atmpin = 123;

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Atm Machine!!!");

        System.out.println("Enter Account Number: ");
        int accNumber = in.nextInt();

        System.out.println("Enter Pin: ");
        int pin = in.nextInt();

        if ((accNumber == accountNumber) && (atmpin==pin)){
            System.out.println("Validation Successful");
            while (true){
                System.out.println("\n1.View Available Balance" +
                        "\n2.Withdraw Amount" +
                        "\n3.Deposit Amount" +
                        "\n4.View MiniStatement" +
                        "\n5.Exit ");

                System.out.println("Enter your choice: ");
                int choice = in.nextInt();
                if(choice ==1){
                    op.viewBalance();

                }else if(choice ==2){

                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = in.nextDouble();
                    op.withdrawAmount(withdrawAmount);

                }else if (choice ==3){
                    System.out.println("Enter the amount to Deposit: ");
                    double depositAmount = in.nextDouble();
                    op.depositAmount(depositAmount);

                }else if (choice ==4){

                    op.viewMiniStatement();

                }else if(choice == 5) {
                    System.out.println("Please collect your ATM card!!!");
                    System.out.println("Thank you for using the Atm Machine");
                    System.exit(0);
                }else {
                    System.out.println("Please Enter a valid Choice");
                }

                }

        }
        System.out.println("Incorrect account number Or Pin");
        System.exit(0);
    }
}
