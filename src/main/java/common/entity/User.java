package common.entity;

public class User {

    private int id;
    private String account;
    private String nickname;

    public User(String account, String nickname) {
        this.account = account;
        this.nickname = nickname;
    }

}
