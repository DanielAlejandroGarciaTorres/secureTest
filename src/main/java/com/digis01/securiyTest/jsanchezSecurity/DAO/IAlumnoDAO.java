package com.digis01.securiyTest.jsanchezSecurity.DAO;

import com.digis01.securiyTest.jsanchezSecurity.JPA.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoDAO extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByUserName(String userName);
}
