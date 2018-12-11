package client.monument;

public class MonumentModel {

    private Integer id;
    private String name;
    private String kind; //translate or change to string
    private String description;
    private String coordinate; //translate or change to string
    private Double cost;
    private String openingHours;

    public MonumentModel() {
    }

    public MonumentModel(String name, String kind, String description, String coordinate, Double cost, String openingHours) {
        this.name = name;
        this.kind = kind;
        this.description = description;
        this.coordinate = coordinate;
        this.cost = cost;
        this.openingHours = openingHours;
    }

    public MonumentModel(Integer id, String name, String kind, String description, String coordinate, Double cost, String openingHours) {
        this.id = id;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
}
