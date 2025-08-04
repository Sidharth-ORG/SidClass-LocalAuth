package com.learn.SidClasses.Service;

import com.learn.SidClasses.Dto.CustomUserDetails;
import com.learn.SidClasses.Entities.User;
import com.learn.SidClasses.Exception.CredentialNotFound;
import com.learn.SidClasses.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepo userrepo;
    public CustomUserDetailsService(UserRepo userrepo){
        this.userrepo=userrepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userrepo.findByEmail(username).orElseThrow(()->new CredentialNotFound(username+": entered email doesn't exist!!!!"));
        //CustomUserDetails cud=new CustomUserDetails(user); bellow we wrote in inline
        return new CustomUserDetails(user);

    }
}
