package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.Menu;

import java.util.List;

public interface MenuDao {
    Menu getMenuById(Long menuId);

    List<Menu> getAllMenus();
}
