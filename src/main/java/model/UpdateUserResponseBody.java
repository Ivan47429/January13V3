package model;

public class UpdateUserResponseBody {
    String name;
    String job;
    String updatedAt;

    public String getName() {
        return name;
    }

    public UpdateUserResponseBody setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public UpdateUserResponseBody setJob(String job) {
        this.job = job;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public UpdateUserResponseBody setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
