//package com.smartentry.backend.security;
//
//import com.smartentry.backend.domain.User;
//import com.smartentry.backend.repositories.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl {
//
//    @Autowired
//    RoleRepository roleRepository;
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User user = roleRepository.findByNomeUsuario(username).orElseThrow(() -> new UsernameNotFoundException("User not Found with usarname: " + username));
////        return user;
////    }
//}
