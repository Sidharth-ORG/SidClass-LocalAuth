package com.learn.SidClasses.Service;

import com.learn.SidClasses.Customs_Constants.AppConstants;
import com.learn.SidClasses.Dto.CourseDto;
import com.learn.SidClasses.Dto.UserDto;
import com.learn.SidClasses.Entities.Role;
import com.learn.SidClasses.Entities.User;
import com.learn.SidClasses.Exception.ResourceAlreadyExistException;
import com.learn.SidClasses.Exception.ResourceNotFoundException;
import com.learn.SidClasses.Repository.RoleRepo;
import com.learn.SidClasses.Repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


import java.util.Date;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService{
    private UserRepo usrepo;
    private ModelMapper mmapper;
    private RoleRepo rrepo;
    private PasswordEncoder passwordencoder;

    public UserImpl(UserRepo usrepo, ModelMapper mmapper, RoleRepo rrepo, PasswordEncoder passwordencoder) {
        this.usrepo = usrepo;
        this.mmapper = mmapper;
        this.rrepo = rrepo;
        this.passwordencoder = passwordencoder;
    }

    public UserDto entityToDto(User user){
        return mmapper.map(user,UserDto.class);
    }
    public User dtoToEntity(UserDto usdt){
        return mmapper.map(usdt,User.class);
    }
    @Override
    public UserDto create(User user) {
       // Role guestRole=rrepo.findByRoleName(AppConstants.Default_Guest).orElseThrow(()->new ResourceNotFoundException("Role Guest not found"));
        Role adminRole=rrepo.findByRoleName(AppConstants.Default_Admin).orElseThrow(()->new ResourceNotFoundException("Role Admin not found"));
        User savedu=usrepo.findByEmail(user.getEmail()).orElseGet(()->{user.setCreatedAt(new Date());
                                                                       user.setEmailVerified(true);
                                                                       user.setActive(true);
                                                                       user.setPassword(passwordencoder.encode(user.getPassword()));
                                                                       //user.assignrole(guestRole);
                                                                       user.assignrole(adminRole);
                                                                       return usrepo.save(user);});
        return entityToDto(savedu);
    }

    @Override
    public List<UserDto> getall(int pno,int psize,String Sortby) {
        Sort sort=Sort.by(Sortby).ascending();
        PageRequest pr=PageRequest.of(pno,psize,sort);
        Page<User> userlist=usrepo.findAll(pr);
        List<UserDto> allcdto=userlist.stream().map(ul -> entityToDto(ul)).collect(Collectors.toList());
        return allcdto;
    }

}
