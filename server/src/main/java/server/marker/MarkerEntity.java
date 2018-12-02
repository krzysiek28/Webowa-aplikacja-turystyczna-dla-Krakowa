package server.marker;

import server.user.UserEntity;

import javax.persistence.*;

@Entity
public class MarkerEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String type;
    private String description;
    private String coordinate;
    @ManyToOne
    private UserEntity owner;

    public MarkerEntity() {
    }

    public MarkerEntity(String name, String type, String description, String coordinate, UserEntity owner) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.coordinate = coordinate;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public boolean validate(){
        return !(this.getCoordinate().isEmpty() || this.getName().isEmpty() || this.getDescription().isEmpty()
                || this.getType().isEmpty() || this.getOwner() ==  null);
    }
}
