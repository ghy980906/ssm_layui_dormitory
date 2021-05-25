package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.Admin;
import com.mecol.dormitory.entity.AdminLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminDao {
    Admin login(@Param("username") String username, @Param("password") String password);

    void insAdminLog(@Param("adminUsername")String username, @Param("loginIp")String loginIp,
                     @Param("loginTime")Date loginTime,@Param("logoutTime")Date logoutTime,
                     @Param("isSafeExit")Integer isSafeExit);

    Admin getAdminById(Integer admin_id);

    AdminLog getAdminLogByLoginTime(Date loginTime);

    void updateAdminLog(AdminLog adminLog);

    void updAdmin(Admin admin);

    Admin getAdminByUsername(String username);

    List<AdminLog> getAdminLogsList();

    List<Admin> getAdminsList();

    void insAdmin(Admin admin);

    void delAdminById(Long admin_id);

    List<Admin> getAdminByRoleId(int roleId);
}
