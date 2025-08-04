package com.learn.SidClasses.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable=false)
    private String name;

    //this is our username
    @Column(nullable=false,unique = true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private boolean emailVerified;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String recentOtp;

    @Column()
    private boolean smsVerified;

    @Column(nullable=false)
    private String about;

    @Column(nullable=false)
    private boolean isActive;

    @Column(nullable=false)
    private Date createdAt;


    private String profilePath;


    @ManyToMany(mappedBy="users",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Role> roles=new HashSet<>();

    public void assignrole(Role role){
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removerole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }




}
