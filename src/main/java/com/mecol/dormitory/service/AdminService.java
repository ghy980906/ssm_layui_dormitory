package com.mecol.dormitory.service;

import com.mecol.dormitory.entity.Admin;
import com.mecol.dormitory.entity.AdminLog;
import com.mecol.dormitory.entity.Menu;
import com.mecol.dormitory.entity.Role;
import com.mecol.dormitory.util.ResultUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface AdminService {
    Admin login(String username, String encrypt);

    void insAdminLog(String username, String loginIp, Date loginTime, Date logoutTime, Integer isSafeExit);

    Admin getAdminById(Integer admin_id);

    List<Menu> getMenus(Admin admin1);

    AdminLog getAdminLogByLoginTime(Date loginTime);

    void updateAdminLog(AdminLog adminLog);

    void updAdmin(Admin admin);

    Admin getAdminByUsername(String username);

    ResultUtil getAdminLogList(Integer page, Integer limit) throws ParseException;

    ResultUtil getAdminList(Integer page, Integer limit);

    List<Role> getRoles();

    Role getRoleById(Long roleId);

    void insAdmin(Admin admin);

    void delAdminById(Long admin_id);
    ResultUtil getRoles(Integer page,Integer limit);

    void delRole(Long roleId);

    List<Menu> getXtreeData(Long  roleId);

    Role getRoleByRoleName(String roleName);

    void updRole(Role role, String m);

    void insRole(Role role, String m);
}
