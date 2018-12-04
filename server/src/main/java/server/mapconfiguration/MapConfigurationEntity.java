package server.mapconfiguration;

import server.user.UserEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "mapConfiguration")
public class MapConfigurationEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToOne
    private UserEntity owner;
    @OneToMany/*(mappedBy="allowedUser")*/
    private Set<UserEntity> allowedUsers = new HashSet<>();
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<MonumentEntity> monuments;
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<MarkerEntity> markers;

    public MapConfigurationEntity() {
    }
//
//    public MapConfigurationEntity(UserEntity owner, List<UserEntity> allowedUsers, List<MonumentEntity> monuments, List<MarkerEntity> markers) {
//        this.owner = owner;
//        this.allowedUsers = allowedUsers;
//        this.monuments = monuments;
//        this.markers = markers;
//    }
//
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public Set<UserEntity> getAllowedUsers() {
        return allowedUsers;
    }

    public void setAllowedUsers(Set<UserEntity> allowedUsers) {
        this.allowedUsers = allowedUsers;
    }

//    public List<MonumentEntity> getMonuments() {
//        return monuments;
//    }
//
//    public void setMonuments(List<MonumentEntity> monuments) {
//        this.monuments = monuments;
//    }
//
//    public List<MarkerEntity> getMarkers() {
//        return markers;
//    }
//
//    public void setMarkers(List<MarkerEntity> markers) {
//        this.markers = markers;
//    }
}
