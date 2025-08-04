package com.learn.SidClasses.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleDto {
    private UUID roleId;
    private String roleName;
}
