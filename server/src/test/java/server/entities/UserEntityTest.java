package server.entities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import server.user.UserEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class UserEntityTest {

    private UserEntity testedObject;

    private final static String email = "test@email.com";
    private final static String username = "testUsername";
    private final static String password = "testPassword";
    private final static String role = "USER_ROLE";
    private final static Boolean enabled = true;

    @BeforeTest
    public void setValues(){
        testedObject = new UserEntity(username, password, email, role, enabled);
    }

    @Test
    public void checkCreatedObject(){
        assertThat(testedObject).isNotNull();
        assertThat(testedObject.getEmail()).isEqualTo(email);
        assertThat(testedObject.getUsername()).isEqualTo(username);
        assertThat(testedObject.getPassword()).isEqualTo(password);
        assertThat(testedObject.getRole()).isEqualTo(role);
        assertThat(testedObject.getEnabled()).isEqualTo(enabled);
    }
}
