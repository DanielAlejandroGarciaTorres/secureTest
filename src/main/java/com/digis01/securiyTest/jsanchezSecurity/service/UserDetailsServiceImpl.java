
package com.digis01.securiyTest.jsanchezSecurity.service;

import com.digis01.securiyTest.jsanchezSecurity.DAO.IAlumnoDAO;
import com.digis01.securiyTest.jsanchezSecurity.JPA.Usuario;
import com.digis01.securiyTest.jsanchezSecurity.util.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IAlumnoDAO iAlumnoDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iAlumnoDAO.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new UserDetailsImpl(usuario);
    }
}
