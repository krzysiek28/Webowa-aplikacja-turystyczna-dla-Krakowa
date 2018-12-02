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
    private String descripiton;
    private String coordinate;
    @ManyToOne
    private UserEntity owner;

    public MarkerEntity() {
    }

    public MarkerEntity(String name, String type, String descripiton, String coordinate, UserEntity owner) {
        this.name = name;
        this.type = type;
        this.descripiton = descripiton;
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

    public String getDescripiton() {
        return descripiton;
    }

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
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
}
