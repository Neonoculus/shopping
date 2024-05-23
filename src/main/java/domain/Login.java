package domain;

public class Login {
    private int l_id;
    private String username;
    private String password;
    private int type;

    public Login(int l_id, String username, String password, int type) {
        this.l_id = l_id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public Login() {
    }

    @Override
    public String toString() {
        return "Login{" +
                "l_id=" + l_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
