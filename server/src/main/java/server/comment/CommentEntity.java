package server.comment;

import server.monument.MonumentEntity;
import server.user.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private UserEntity user;
    @ManyToOne
    private MonumentEntity monument;
    private Integer rate;
    private String description;

    public CommentEntity() {
    }

    public CommentEntity(UserEntity user, MonumentEntity monument, Integer rate, String description) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public MonumentEntity getMonument() {
        return monument;
    }

    public void setMonument(MonumentEntity monument) {
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

    public boolean validate(){
        return !(this.getDescription().isEmpty() || this.getMonument()==null || (this.getRate()<0 && this.getRate()>5) || this.getUser()==null);
    }
}
