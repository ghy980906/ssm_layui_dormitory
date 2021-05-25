package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.RoleMenu;

import java.util.List;

public interface RoleMenuDao {
    List<RoleMenu> selMenusByRoleId(Long roleId);

    void deleteMenusByRoleId(Long roleId);

    void insert(RoleMenu roleMenu);
}
