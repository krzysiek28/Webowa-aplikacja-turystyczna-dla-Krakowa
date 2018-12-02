package client.marker;

import client.user.UserModel;

public class MarkerModel {

    private Integer id;
    private String name;
    private String type;
    private String description;
    private String coordinate;
    private UserModel owner;

    public MarkerModel() {
    }

    public MarkerModel(String name, String type, String description, String coordinate, UserModel owner) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.coordinate = coordinate;
        this.owner = owner;
    }

    public MarkerModel(Integer id, String name, String type, String description, String coordinate, UserModel owner) {
        this.id = id;
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

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }
}
