package model;

public class PostLoginUserRequestBody {
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public PostLoginUserRequestBody setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PostLoginUserRequestBody setPassword(String password) {
        this.password = password;
        return this;
    }
}
