package com.mecol.dormitory.service;

import com.mecol.dormitory.entity.Pay;
import com.mecol.dormitory.util.ResultUtil;

public interface PayService {
    ResultUtil getAdminNoPayList(Integer page, Integer limit);

    void delDoPay(int payId);

    void insPay(Pay pay);

    ResultUtil getAdminPayList(Integer page, Integer limit);

    ResultUtil getUserNoPayList(Integer page, Integer limit, Integer student_id);

    Pay getPayById(Integer payId);

    void updatePay(Pay pay1);


    ResultUtil getUserPayList(Integer page, Integer limit, Integer student_id);

    ResultUtil getWPayList(Integer page, Integer limit);

    void delWPay(int payId);

    ResultUtil getStuWPayList(Integer page, Integer limit, Integer dormitoryId);

    ResultUtil getEPayList(Integer page, Integer limit);

    ResultUtil getStuEPayList(Integer page, Integer limit, Integer dormitoryId);
}
