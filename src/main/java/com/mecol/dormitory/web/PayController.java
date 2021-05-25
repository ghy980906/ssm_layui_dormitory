package com.mecol.dormitory.web;


import com.mecol.dormitory.entity.Dormitory;
import com.mecol.dormitory.entity.Pay;
import com.mecol.dormitory.entity.Student;
import com.mecol.dormitory.service.DormitoryService;
import com.mecol.dormitory.service.PayService;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/pay")
public class PayController {


    @Autowired
    private PayService payService;

    @Autowired
    private DormitoryService dormitoryService;





    @RequestMapping("/ePayList")
    public String ePayList()
    {

        return "/jsp/pay/ePayList";
    }


    @RequestMapping("/getEPayList")
    @ResponseBody
    public ResultUtil getEPayList(Integer page, Integer limit)
    {
        return payService.getEPayList(page,limit);
    }

    @RequestMapping("/addEPay")
    public String addEPay(HttpSession session)
    {
        List<Dormitory> dormitories=dormitoryService.getAllDormitories();
        session.setAttribute("dormitories",dormitories);

        return "/jsp/pay/addEPay";
    }

    @RequestMapping("/insEPay")
    @ResponseBody
    public ResultUtil insEPay(Pay pay)
    {

        pay.setPayStatus(0);
        pay.setPayName(2);  //2是电费
        pay.setPayType(5); //未交费
        try
        {

            payService.insPay(pay);
            return ResultUtil.ok();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResultUtil.error("sql错误 请检查");
        }
    }


    @RequestMapping("/payStuEPayList")
    public String payStuEPayList()
    {

        return "/jsp/pay/payStuEPayList";
    }


    @RequestMapping("/getStuEPayList")
    @ResponseBody
    public ResultUtil getStuEPayList(Integer page, Integer limit,HttpSession session)
    {
        Student student= (Student) session.getAttribute("hotel_user");

        return payService.getStuEPayList(page,limit,student.getDormitoryId());
    }
    @RequestMapping("/stuEPay/{payId}")
    public String stuEPay(@PathVariable("payId")int payId, HttpSession session)
    {

        session.setAttribute("payId",payId);

        return "/jsp/pay/stuEPay";
    }

    @RequestMapping("/insertStuEPay")
    @ResponseBody
    public ResultUtil insertStuEPay(Pay pay) throws ParseException {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime=simpleDateFormat.format(date);
        Date create_time=simpleDateFormat.parse(nowTime);

        //现根据这个id读出来pay 设置付款方式 在写入
        //  System.out.println(pay);
        Pay pay1=payService.getPayById(pay.getPayId());
        pay1.setPayTime(create_time);
        pay1.setPayStatus(1);
        pay1.setPayType(pay.getPayType());

        payService.updatePay(pay1);

        return ResultUtil.ok();
    }




    @RequestMapping("/insertStuWPay")
    @ResponseBody
    public ResultUtil insertStuWPay(Pay pay) throws ParseException {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime=simpleDateFormat.format(date);
        Date create_time=simpleDateFormat.parse(nowTime);

        //现根据这个id读出来pay 设置付款方式 在写入
        //  System.out.println(pay);
        Pay pay1=payService.getPayById(pay.getPayId());
        pay1.setPayTime(create_time);
        pay1.setPayStatus(1);
        pay1.setPayType(pay.getPayType());

        payService.updatePay(pay1);

        return ResultUtil.ok();
    }


    @RequestMapping("/stuWPay/{payId}")
    public String stuWPay(@PathVariable("payId")int payId, HttpSession session)
    {

        session.setAttribute("payId",payId);

        return "/jsp/pay/stuWPay";
    }

    @RequestMapping("/payStuWPayList")
    public String payStuWPayList()
    {

        return "/jsp/pay/payStuWPayList";
    }


    @RequestMapping("/getStuWPayList")
    @ResponseBody
    public ResultUtil getStuWPayList(Integer page, Integer limit,HttpSession session)
    {
        Student student= (Student) session.getAttribute("hotel_user");

        return payService.getStuWPayList(page,limit,student.getDormitoryId());
    }

    @RequestMapping("/wPayList")
    public String wPayList()
    {

        return "/jsp/pay/wPayList";
    }


    @RequestMapping("/getWPayList")
    @ResponseBody
    public ResultUtil getWPayList(Integer page, Integer limit)
    {
        return payService.getWPayList(page,limit);
    }

    @RequestMapping("/addWPay")
    public String addPay(HttpSession session)
    {
        List<Dormitory> dormitories=dormitoryService.getAllDormitories();
        session.setAttribute("dormitories",dormitories);

        return "/jsp/pay/addWPay";
    }

    @RequestMapping("/insWPay")
    @ResponseBody
    public ResultUtil insPay(Pay pay)
    {

        pay.setPayStatus(0);
        pay.setPayName(1);  //1是水费
        pay.setPayType(5); //未交费
        try
        {

            payService.insPay(pay);
            return ResultUtil.ok();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResultUtil.error("sql错误 请检查");
        }
    }

    @RequestMapping("/delWPay/{payId}")
    @ResponseBody
    public ResultUtil delWPay(@PathVariable("payId")int payId){
        payService.delWPay(payId);
        return ResultUtil.ok();
    }

/*
    @RequestMapping("/getUserNoPayList")
    @ResponseBody
    public ResultUtil getUserNoPayList(Integer page, Integer limit,HttpSession session)
    {
        User user= (User) session.getAttribute("hotel_user");
        return payService.getUserNoPayList(page,limit,user.getUser_id());
    }

    @RequestMapping("/getAdminNoPayList")
    @ResponseBody
    public ResultUtil getAdminNoPayList(Integer page, Integer limit)
    {
        return payService.getAdminNoPayList(page,limit);
    }


    @RequestMapping("/getUserPayList")
    @ResponseBody
    public ResultUtil getUserPayList(Integer page, Integer limit,HttpSession session)
    {
        User user= (User) session.getAttribute("hotel_user");
        return payService.getUserPayList(page,limit,user.getUser_id());
    }

    @RequestMapping("/getAdminPayList")
    @ResponseBody
    public ResultUtil getAdminPayList(Integer page, Integer limit)
    {
        return payService.getAdminPayList(page,limit);
    }

    @RequestMapping("/userNoPayList")
    public String userNoPayList()
    {

        return "/jsp/pay/userNoPayList";
    }

    @RequestMapping("/userPayList")
    public String userPayList()
    {

        return "/jsp/pay/userPayList";
    }

    @RequestMapping("/adminPayList")
    public String adminPayList()
    {

        return "/jsp/pay/adminPayList";
    }


    @RequestMapping("/delDoPay/{payId}")
    @ResponseBody
    public ResultUtil delDoPay(@PathVariable("payId")int payId){
        payService.delDoPay(payId);
        return ResultUtil.ok();
    }

    @RequestMapping("/addPay")
    public String addPay(HttpSession session)
    {
        List<Room> rooms=roomDao.getAllRooms();
        session.setAttribute("rooms",rooms);

        return "/jsp/pay/addPay";
    }

    @RequestMapping("/insertUserPay")
    @ResponseBody
    public ResultUtil insertUserPay(Pay pay) throws ParseException {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime=simpleDateFormat.format(date);
        Date create_time=simpleDateFormat.parse(nowTime);

        //现根据这个id读出来pay 设置付款方式 在写入
      //  System.out.println(pay);
        Pay pay1=payService.getPayById(pay.getPayId());
        pay1.setPayTime(create_time);
        pay1.setPayStatus(1);
        pay1.setPayType(pay.getPayType());

        payService.updatePay(pay1);

        return ResultUtil.ok();
    }


    @RequestMapping("/insPay")
    @ResponseBody
    public ResultUtil insPay(Pay pay)
    {

       // System.out.println(pay);
        User user=userDao.getUserByRoomId(pay.getRoomId());
        if (user==null)
        {
            return new ResultUtil(500,"此房间下没有业主");
        }
        user.setPayId(pay.getPayId());
        userDao.updateUser(user);  //更新下user中的payid

        pay.setUser_id(user.getUser_id());
        pay.setPayStatus(0); //未交费状态
        try
        {

            payService.insPay(pay);
            return ResultUtil.ok();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResultUtil.error("此房间下没有业主");
        }
    }

    @RequestMapping("/userPay/{payId}")
    public String editFix(@PathVariable("payId")int payId, HttpSession session)
    {

        session.setAttribute("payId",payId);

        return "/jsp/pay/userPay";
    }

*/

}
