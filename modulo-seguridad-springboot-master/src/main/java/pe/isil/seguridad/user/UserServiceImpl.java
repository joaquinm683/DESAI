package pe.isil.seguridad.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private  UserRepository userRepository;


    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUserEmail(String email) {

        Optional<User> userToFind = userRepository.findByEmail(email);

        return userToFind.isPresent() ? userToFind.get() : null;



    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }



    @Transactional
    @Override
    public void updateUser(User user, Long id) {
        Optional <User> usertoUpdate = userRepository.findById(id);

       if(usertoUpdate.isPresent()){
           usertoUpdate.get().setName(user.getName() != null ? user.getName() : usertoUpdate.get().getName());

           usertoUpdate.get().setLastname(user.getLastname() != null ? user.getLastname() : usertoUpdate.get().getLastname());
           usertoUpdate.get().setEmail(user.getEmail() != null ? user.getEmail() : usertoUpdate.get().getEmail());
           usertoUpdate.get().setUrlPhoto(user.getUrlPhoto() != null ? user.getUrlPhoto() : usertoUpdate.get().getUrlPhoto());

       }
    }

    @Override
    public void deleteUser(Long id) {
        Optional <User> usertoDelete = userRepository.findById(id);

        if(usertoDelete.isPresent()){
            userRepository.delete(usertoDelete.get());
        }

    }
}
