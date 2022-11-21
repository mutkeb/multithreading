public class BankTest {
    public static void main(String[] args) {
        Depositor depositor1 = new Depositor();
        depositor1.setName("徐文昌");
        depositor1.setGender("男");
        depositor1.setId("1");
        depositor1.setBalance(9200);
        //  第二个储户
        Depositor depositor2 = new Depositor();
        depositor2.setName("楼山关");
        depositor2.setId("2");
        depositor2.setGender("男");
        depositor2.setBalance(6700);

        Bank bank = Bank.getBank();
        bank.drawMoney(depositor1,1000);
        System.out.println(depositor1.getName()+"取出1000元，余额"+depositor1.getBalance()+"元");
        bank.drawMoney(depositor2,420);
        System.out.println(depositor2.getName()+"取出420元，余额"+depositor2.getBalance()+"元");
    }
}
