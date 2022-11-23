package pe.isil.seguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityServiceImpl implements UserSecurityService{

    @Autowired
    private UserSecuirtyRepository userSecuirtyRepository;

    @Override
    public UserSecurity findUserSecurity(String email, String password) {

       Optional<UserSecurity> userToFind = userSecuirtyRepository.findUserSecurityByEmailAndPassword(email,password);
       if(userToFind.isPresent()){
           return userToFind.get();
       }else{
           return null;
       }

//       return userToFind.isPresent() ? userToFind.get() : null;


    }

    @Override
    public UserSecurity findUserSecurityByMail(String email) {
        Optional<UserSecurity> userToFind = userSecuirtyRepository.findUserSecurityByEmail(email);
        if(userToFind.isPresent()){
            return userToFind.get();
        }else{
            return null;
        }
    }


    @Override
    public UserSecurity registerUserSecurity(UserSecurity user) {
        userSecuirtyRepository.save(user);
        return user;
    }

    @Override
    public UserSecurity addUserSecurity(UserSecurity user) {
        userSecuirtyRepository.save(user);

        return null;
    }

    @Override
    public UserSecurity updateSecurity(UserSecurity user) {
        userSecuirtyRepository.save(user);
        return null;
    }
}
