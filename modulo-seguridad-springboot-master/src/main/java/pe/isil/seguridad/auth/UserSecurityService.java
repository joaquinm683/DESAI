package pe.isil.seguridad.auth;

import org.apache.catalina.User;

public interface UserSecurityService {

    UserSecurity findUserSecurity(String email, String password);

    UserSecurity findUserSecurityByMail(String email);

    UserSecurity registerUserSecurity(UserSecurity user);

    UserSecurity addUserSecurity(UserSecurity user);

    UserSecurity updateSecurity(UserSecurity user);




}
