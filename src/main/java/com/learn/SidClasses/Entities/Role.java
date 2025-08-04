package com.learn.SidClasses.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Role {
   @Id
   @GeneratedValue(strategy=GenerationType.UUID)
   private UUID roleId;
   private String roleName;

   @ManyToMany
   @JsonIgnore
   @JoinTable(name="roles users")
   private Set<User> users=new HashSet<>();
}
