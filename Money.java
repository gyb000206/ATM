package date;

/**
 * @author 高宇博
 * @ID 2503190213
 */


public class Money {
    private static double Balance = 10000;

    public static void setBalance(double balance) {
        Balance = balance;
    }

    public static double getBalance() {
        return Balance;
    }

    public static void setAddBalance(double money) {
        Balance += money;
    }
    public static  void setWithdrawalsBalance(double withdrawals){
        Balance-=withdrawals;
    }


}
