package server.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUser(Integer userId) {
        if (!userRepository.exists(userId)) {
            throw new IllegalArgumentException("Uzytkownik nie istnieje");
        }
        return userRepository.findOne(userId);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void updateUser(Integer userId, UserEntity user) {
        if (!userRepository.exists(userId)) {
            throw new IllegalArgumentException("Uzytkownik nie istnieje!");
        }

        UserEntity dbUser = userRepository.findOne(userId);
        dbUser.setUsername(user.getUsername());
        dbUser.setEmail(user.getEmail());
        dbUser.setPassword(user.getPassword());
        dbUser.setRole(user.getRole());
        dbUser.setEnabled(user.getEnabled());
        userRepository.save(dbUser);
    }

    public void deleteUser(Integer userId) {
        if (!userRepository.exists(userId)) {
            throw new IllegalArgumentException("Uzytkownik nie istnieje!");
        }
        userRepository.delete(userId);
    }
}
