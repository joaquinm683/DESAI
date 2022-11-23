package pe.isil.seguridad.user;

import java.util.List;

public interface UserService {

    void addUser(User user);
    User findByUserEmail(String email);
    List<User> findAll();
    void updateUser(User user, Long id);
    void deleteUser(Long id);

}
