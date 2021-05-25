package com.mecol.dormitory.dao;

import com.mecol.dormitory.entity.Pay;
import com.mecol.dormitory.util.ResultUtil;

import java.util.List;

public interface PayDao {
    List<Pay> getAdminNoPayList();

    void delNoPay(int payId);

    void insPay(Pay pay);

    List<Pay> getAdminPayList();

    List<Pay> getUserNoPayList(Integer student_id);

    Pay getPayById(Integer payId);

    void updatePay(Pay pay1);

    List<Pay> getUserPayList(Integer student_id);

    List<Pay> getWPayList();

    void delWPay(int payId);

    List<Pay> getStuWPayList(Integer dormitoryId);

    List<Pay> getEPayList();

    List<Pay> getStuEPayList(Integer dormitoryId);
}
