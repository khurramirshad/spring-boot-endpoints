
package com.solance.services;

import com.solance.entities.User;
import com.solance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.List;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

   // PasswordEncoder encoder = new BCryptPasswordEncoder();

    public String saveUser(User user) {
        // encode password and set back to entity
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setRoles(Arrays.asList("CREATE"));

        User save = userRepository.save(user);
        return "User saved successfully : " + save;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
