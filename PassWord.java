package date;

public class PassWord {
    private String PassWord = "123456";
    private String User = "123456";
    final private String administrator = "admin";

    public void setUser(String user) {
        User = user;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getUser() {
        return User;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getAdministrator() {
        return administrator;
    }
}
