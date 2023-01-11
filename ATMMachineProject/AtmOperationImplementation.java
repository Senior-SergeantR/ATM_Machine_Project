package ATMMachineProject;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImplementation implements AtmOperationInterface{

    ATM atm = new ATM();

    Map<Double,String> ministatement = new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is: "+atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
       if (withdrawAmount%500==0){
            if(withdrawAmount<=atm.getBalance()){
                ministatement.put(withdrawAmount,"Amount withdrawn");
                System.out.println(withdrawAmount+ " has been withdrawn Successfully");
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            }else{
                System.out.println("insufficient Balance!!!");
            }
       }else {
           System.out.println("Please enter the amount in multiples of 500");
       }
    }

    @Override
    public void depositAmount(double depositAmount) {
        System.out.println(depositAmount +" Deposited Successfully!!!");
        ministatement.put(depositAmount,"Amount deposited");

        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for (Map.Entry<Double,String>m: ministatement.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
