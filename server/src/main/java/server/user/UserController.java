package server.user;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import server.security.SecurityUtils;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserController(UserService userService, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping(value = "/sign-up")
    public void signUp(@RequestBody UserEntity user, HttpServletResponse response) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists!");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with provided email already exists!");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUsername(Jsoup.parse(user.getUsername()).text());
        user.setEmail(Jsoup.parse(user.getEmail()).text());
        user.setRole(user.getRole());
        user.setEnabled(user.getEnabled());
        userRepository.save(user);
        response.addHeader(SecurityUtils.HEADER_STRING, SecurityUtils.TOKEN_PREFIX + " " + SecurityUtils.generateToken(user.getUsername()));
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public UserEntity getUserByUsername(@PathVariable String userName, @RequestHeader("Authorization") String token) {
        return userService.getUserByUsername(userName);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Integer userName, @RequestBody UserEntity user){
        String userId = jdbcTemplate.queryForObject("SELECT id from users where username=" + "\'" + userName + "\'" + ";", String.class);
        userService.updateUser(Integer.parseInt(userId), user);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer userName) {
        String userId = jdbcTemplate.queryForObject("SELECT id from users where username=" + "\'" + userName + "\'" + ";", String.class);
        userService.deleteUser(Integer.parseInt(userId));
    }
}
