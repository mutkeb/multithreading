public class Bank {


    private static Bank bank = new Bank();

    private Bank(){

    }
    public void drawMoney(Depositor depositor,int amount){
        if(depositor.getBalance() < amount){
            System.out.println("余额不足");
        }
        depositor.setBalance(depositor.getBalance() - amount);
    }
    public static Bank getBank(){
        return bank;
    }

}
