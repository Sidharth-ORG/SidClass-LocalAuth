package com.learn.SidClasses.Dto;

import com.learn.SidClasses.Entities.Role;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;

    private String name;

    private String email;

    private String password;

    private boolean emailVerified;

    private String phoneNumber;

    private String recentOtp;

    private boolean smsVerified;

    private String about;

    private boolean isActive;

    private Date createdAt;

    private String profilePath;

    private Set<Role> roles=new HashSet<>();


}
