package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.Role;

import java.util.List;

public interface RoleDao {
    List<Role> selRoles();

    Role getRoleById(Long roleId);

    void delRole(Long roleId);

    Role getRoleByRoleName(String roleName);

    void updateByKey(Role role);

    void insertRole(Role role);

    Role selectRoleByRoleName(String roleName);
}
