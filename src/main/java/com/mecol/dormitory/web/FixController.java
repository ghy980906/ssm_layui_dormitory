package com.mecol.dormitory.web;

import com.mecol.dormitory.dao.AdminDao;
import com.mecol.dormitory.dao.DormitoryDao;
import com.mecol.dormitory.entity.Admin;
import com.mecol.dormitory.entity.Dormitory;
import com.mecol.dormitory.entity.Fix;
import com.mecol.dormitory.entity.Student;
import com.mecol.dormitory.service.DormitoryService;
import com.mecol.dormitory.service.FixService;
import com.mecol.dormitory.service.StudentService;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/fix")
public class FixController {

    @Autowired
    private FixService fixService;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private DormitoryDao dormitoryDao;
    @Autowired
    private StudentService studentService;
    @Autowired
    private DormitoryService dormitoryService;


    @RequestMapping("/myFixList")
    public String myFixList()
    {

        return "/jsp/fix/myFixList";
    }
    @RequestMapping("/getMyFixList")
    @ResponseBody
    public ResultUtil getMyFixList(Integer page, Integer limit,HttpSession session)
    {
        Integer student_id= (Integer) session.getAttribute("hotel_user_id");

        //这是带分页的查询
        return fixService.getMyFixList(page,limit,student_id);
    }


    @RequestMapping("/fixList")
    public String fixList()
    {

        return "/jsp/fix/fixList";
    }
    @RequestMapping("/getFixList")
    @ResponseBody
    public ResultUtil getFixList(Integer page, Integer limit)
    {
        //这是带分页的查询
        return fixService.getFixList(page,limit);
    }

    @RequestMapping("/addFix")
    public String addFix(HttpSession session)
    {

       // List<Admin> fixPeoples=adminDao.getAdminByRoleId(4); //4表示 角色是维修人员

       // List<Dormitory> dormitories=dormitoryDao.getAllDormitories();
        //session.setAttribute("fixPeoples",fixPeoples);
      //  session.setAttribute("dormitories",dormitories);
        return "/jsp/fix/addFix";
    }

    @RequestMapping("/insertFix")
    @ResponseBody
    public ResultUtil insertFix(Fix fix,HttpSession session)
    {


        Integer student_id= (Integer) session.getAttribute("hotel_user_id");
        Student student=studentService.getStudentById(student_id);

        fix.setDormitoryId(student.getDormitoryId());
        fix.setStudent_id(student_id);
        fix.setFixStatus(1); //新添加的为正在维修状态

        try {
            fixService.insertFix(fix);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }

    @RequestMapping("/editFix/{id}")
    public String editFix(@PathVariable("id")int id, HttpSession session)
    {
      //  Fix  fix1=fixService.getFixById(id);
     //   List<Admin> fixPeoples=adminDao.getAdminByRoleId(4); //4表示 角色是维修人员
      //  List<Dormitory> dormitories=dormitoryDao.getAllDormitories();
      //  session.setAttribute("fixPeoples",fixPeoples);
      //  session.setAttribute("dormitories",dormitories);
        session.setAttribute("fix_id",id);
        return "/jsp/fix/editFix";
    }

    @RequestMapping("/updateFix")
    @ResponseBody
    public ResultUtil updateFix(Fix fix,HttpSession session){
       // System.out.println(fix);
        Integer fix_id= (Integer) session.getAttribute("fix_id");
        fix.setId(fix_id);
        fix.setFixStatus(0); //维修完毕

        try {
            fixService.updateFix(fix);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }

    @RequestMapping("/delFix/{id}")
    @ResponseBody
    public ResultUtil delFix(@PathVariable("id")int id){
        fixService.delFixById(id);
        return ResultUtil.ok();
    }

}
