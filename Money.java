package date;
/**
 * @author 高宇博
 * @ID 2503190213
 * 余额类
 */
public class Money {
    private double Balance = 10000;

    public void setBalance(double money) {
        this.Balance = money;
    }

    public double getBalance() {
        return Balance;
    }

    public void setAddBalance(double money) {
        this.Balance = getBalance() + money;
    }

    public void setWithdrawalsBalance(double money) {
        this.Balance = getBalance() - money;
    }
}
