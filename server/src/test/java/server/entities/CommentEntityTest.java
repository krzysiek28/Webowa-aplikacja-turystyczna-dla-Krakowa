package server.entities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import server.comment.CommentEntity;
import server.monument.MonumentEntity;
import server.user.UserEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CommentEntityTest {

    private CommentEntity testedObject;

    private final static UserEntity user = new UserEntity("test@email.com", "testUsername", "testPassword", "USER_ROLE", true);
    private final static MonumentEntity monument = new MonumentEntity("testName", "testKind", "testDescription", "testCoordinate", 10, "testOpeningHours");
    private final static Integer rate = 1;
    private final static String description = "testDescription";

    @BeforeTest
    public void setValues(){
        testedObject = new CommentEntity(user, monument, rate, description);
    }

    @Test
    public void checkCreatedObject(){
        assertThat(testedObject).isNotNull();
        assertThat(testedObject.getUser()).isEqualTo(user);
        assertThat(testedObject.getMonument()).isEqualTo(monument);
        assertThat(testedObject.getRate()).isEqualTo(rate);
        assertThat(testedObject.getDescription()).isEqualTo(description);
    }
}
