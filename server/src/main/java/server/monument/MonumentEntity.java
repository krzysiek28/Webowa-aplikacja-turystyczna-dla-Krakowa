package server.monument;

import javax.persistence.*;

@Entity
@Table(name = "Monuments")
public class MonumentEntity {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;
    private String kind;
    private String description;
    private String coordinate;
    private Integer cost;
    private String openingHours;

    public MonumentEntity() {}

    public MonumentEntity(String name, String kind, String description, String coordinate, Integer cost, String openingHours) {
        this.name = name;
        this.kind = kind;
        this.description = description;
        this.coordinate = coordinate;
        this.cost = cost;
        this.openingHours = openingHours;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
}
