package model;

public class PostLoginUserResponse {
    String token;

    public String getToken() {
        return token;
    }

    public PostLoginUserResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
