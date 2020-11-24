package model;

public class AccountModel {
    private final String Username;
    private final String Password;

    public AccountModel(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

    public String getUsername() {return Username;}

    public String getPassword() {return Password;}


}
