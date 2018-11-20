package client.comment;

import client.monument.MonumentModel;
import client.user.UserModel;

public class CommentModel {

    private Integer id;
    private UserModel user;
    private MonumentModel monument;
    private Integer rate;
    private String description;

    public CommentModel() {
    }

    public CommentModel(UserModel user, MonumentModel monument, Integer rate, String description) {
        this.user = user;
        this.monument = monument;
        this.rate = rate;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public MonumentModel getMonument() {
        return monument;
    }

    public void setMonument(MonumentModel monument) {
        this.monument = monument;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
