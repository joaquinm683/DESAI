package pe.isil.seguridad.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSecuirtyRepository extends JpaRepository<UserSecurity, Long> {

   Optional<UserSecurity> findUserSecurityByEmailAndPassword(String email, String password);
   Optional<UserSecurity> findUserSecurityByEmail(String email);

}
