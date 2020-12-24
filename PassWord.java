package date;
/**
 * @author 高宇博
 * @ID 2503190213
 */
public class PassWord {
    private static String PassWord = "123456";
    private static final String User = "123456";
    private final String administrator = "admin";

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public static String getPassWord() {
        return PassWord;
    }

    public String getAdministrator() {
        return administrator;
    }

    public static String getUser() {
        return User;
    }
}
