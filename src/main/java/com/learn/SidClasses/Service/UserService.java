package com.learn.SidClasses.Service;

import com.learn.SidClasses.Dto.UserDto;
import com.learn.SidClasses.Entities.User;

import java.util.List;

public interface UserService {
     UserDto create(User user);
     List<UserDto> getall(int pno,int psize,String Sortby);

}
