package com.mecol.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mecol.dormitory.dao.PayDao;
import com.mecol.dormitory.entity.Fix;
import com.mecol.dormitory.entity.Pay;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PayServiceImpl implements PayService{

    @Autowired
    private PayDao payDao;


    @Override
    public ResultUtil getAdminNoPayList(Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<Pay> pays=payDao.getAdminNoPayList();
        PageInfo<Pay> payPageInfo=new PageInfo<>(pays);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(payPageInfo.getTotal());

        resultUtil.setData(payPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public void delDoPay(int payId) {
        payDao.delNoPay(payId);
    }

    @Override
    public void insPay(Pay pay) {
        payDao.insPay(pay);
    }

    @Override
    public ResultUtil getAdminPayList(Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<Pay> pays=payDao.getAdminPayList();
        PageInfo<Pay> payPageInfo=new PageInfo<>(pays);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(payPageInfo.getTotal());

        resultUtil.setData(payPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public ResultUtil getUserNoPayList(Integer page, Integer limit, Integer student_id) {
        PageHelper.startPage(page,limit);
        List<Pay> pays=payDao.getUserNoPayList(student_id);
        PageInfo<Pay> payPageInfo=new PageInfo<>(pays);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(payPageInfo.getTotal());

        resultUtil.setData(payPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public Pay getPayById(Integer payId) {
        return payDao.getPayById(payId);
    }

    @Override
    public void updatePay(Pay pay1) {
        payDao.updatePay(pay1);
    }

    @Override
    public ResultUtil getUserPayList(Integer page, Integer limit, Integer student_id) {
        PageHelper.startPage(page,limit);
        List<Pay> pays=payDao.getUserPayList(student_id);
        PageInfo<Pay> payPageInfo=new PageInfo<>(pays);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(payPageInfo.getTotal());

        resultUtil.setData(payPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public ResultUtil getWPayList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Pay> pays=payDao.getWPayList();
        PageInfo<Pay> payPageInfo=new PageInfo<>(pays);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(payPageInfo.getTotal());

        resultUtil.setData(payPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public void delWPay(int payId) {
        payDao.delWPay(payId);
    }

    @Override
    public ResultUtil getStuWPayList(Integer page, Integer limit, Integer dormitoryId) {
        PageHelper.startPage(page,limit);
        List<Pay> pays=payDao.getStuWPayList(dormitoryId);
        PageInfo<Pay> payPageInfo=new PageInfo<>(pays);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(payPageInfo.getTotal());

        resultUtil.setData(payPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public ResultUtil getEPayList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Pay> pays=payDao.getEPayList();
        PageInfo<Pay> payPageInfo=new PageInfo<>(pays);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(payPageInfo.getTotal());

        resultUtil.setData(payPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }

    @Override
    public ResultUtil getStuEPayList(Integer page, Integer limit, Integer dormitoryId) {
        PageHelper.startPage(page,limit);
        List<Pay> pays=payDao.getStuEPayList(dormitoryId);
        PageInfo<Pay> payPageInfo=new PageInfo<>(pays);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(payPageInfo.getTotal());

        resultUtil.setData(payPageInfo.getList());
        //虽然 我存在一对多关系 但不会无限循环查下去 看mapper中的解释
        //所以@ResponseBody就不会存在双向引用导致的死递归问题
        return resultUtil;
    }


}
