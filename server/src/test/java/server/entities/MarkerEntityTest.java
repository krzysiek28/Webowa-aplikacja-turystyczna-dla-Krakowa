package server.entities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import server.marker.MarkerEntity;
import server.user.UserEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MarkerEntityTest {

    private MarkerEntity testedObject;

    private final static String name = "testName";
    private final static String type = "testType";
    private final static String description = "testDescription";
    private final static String coordinate = "testCoordinate";
    private final static UserEntity owner = new UserEntity("test@email.com", "testUsername", "testPassword", "USER_ROLE", true);

    @BeforeTest
    public void setValues(){
        testedObject = new MarkerEntity(name, type, description, coordinate, owner);
    }

    @Test
    public void checkCreatedObject(){
        assertThat(testedObject).isNotNull();
        assertThat(testedObject.getName()).isEqualTo(name);
        assertThat(testedObject.getType()).isEqualTo(type);
        assertThat(testedObject.getDescription()).isEqualTo(description);
        assertThat(testedObject.getCoordinate()).isEqualTo(coordinate);
        assertThat(testedObject.getOwner()).isEqualTo(owner);
    }
}
