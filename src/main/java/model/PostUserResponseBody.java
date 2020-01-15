package model;

public class PostUserResponseBody {
    String name;
    String job;
    String id;
    String createdAt;

    public String getName() {
        return name;
    }

    public PostUserResponseBody setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public PostUserResponseBody setJob(String job) {
        this.job = job;
        return this;
    }

    public String getId() {
        return id;
    }

    public PostUserResponseBody setId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public PostUserResponseBody setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
