package model;

public class UpdateUserRequestBody {
    String name;
    String job;
    ///dali za post i update e ok da imam eden pojo model

    public String getName() {
        return name;
    }

    public UpdateUserRequestBody setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public UpdateUserRequestBody setJob(String job) {
        this.job = job;
        return this;
    }
}
