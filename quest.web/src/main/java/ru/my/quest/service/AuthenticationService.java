package ru.my.quest.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.my.quest.dto.UserInfoDTO;
import ru.my.quest.repository.PersonRepository;

import java.util.Arrays;

/**
 * Created by maksim on 6/5/2016.
 */
@Service
@Log4j
public class AuthenticationService implements UserDetailsService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfoDTO  userInfoDTO = personRepository.getUserInfo(username);
        UserDetails userDetails;
        if(userInfoDTO != null) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userInfoDTO.role);
            userDetails = new User(userInfoDTO.getLogin(),
                    userInfoDTO.getPassword(), Arrays.asList(grantedAuthority));
        } else {
            log.error("Invalid login or password");
            throw new UsernameNotFoundException("User not found");
        }

        return userDetails;
    }
}
