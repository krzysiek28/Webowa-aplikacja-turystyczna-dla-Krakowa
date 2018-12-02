package server.entities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import server.monument.MonumentEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MonumentEntityTest {

    private MonumentEntity testedObject;

    private final static String name = "testName";
    private final static String kind = "testKind";
    private final static String description = "testDescription";
    private final static String coordinate = "testCoordinate";
    private final static Integer cost = 10;
    private final static String openingHours = "testOpeningHours";

    @BeforeTest
    public void setValues(){
        testedObject = new MonumentEntity(name, kind, description, coordinate, cost, openingHours);
    }

    @Test
    public void checkCreatedObject(){
        assertThat(testedObject).isNotNull();
        assertThat(testedObject.getName()).isEqualTo(name);
        assertThat(testedObject.getKind()).isEqualTo(kind);
        assertThat(testedObject.getDescription()).isEqualTo(description);
        assertThat(testedObject.getCoordinate()).isEqualTo(coordinate);
        assertThat(testedObject.getCost()).isEqualTo(cost);
        assertThat(testedObject.getOpeningHours()).isEqualTo(openingHours);
    }
}
