package server.user;

import org.jsoup.Jsoup;
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

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public UserEntity getUserByUsername(@PathVariable String username) {
        UserEntity user = userService.getUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Integer userId, @RequestBody UserEntity user){
        userService.updateUser(userId, user);
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}
