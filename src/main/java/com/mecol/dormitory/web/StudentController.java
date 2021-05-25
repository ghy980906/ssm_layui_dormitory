package com.mecol.dormitory.web;

import com.mecol.dormitory.entity.*;

import com.mecol.dormitory.service.DormitoryService;
import com.mecol.dormitory.service.StudentService;
import com.mecol.dormitory.util.EncryptUtil;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;








    @RequestMapping("/login")
    @ResponseBody
    public ResultUtil login(String username, String password, HttpServletRequest request, HttpSession session)
    {
        Student student=studentService.login(username, EncryptUtil.encrypt(password));

        if(student!=null)
        {

            Admin admin=new Admin();
            session.setAttribute("user",admin); //拦截器中用 跳过拦截器
            session.setAttribute("hotel_user",student);
//            session.setAttribute("student",student);
            session.setAttribute("usertype",2);//代表学生登陆
            session.setAttribute("hotel_user_id",student.getId());
//            session.setAttribute("student_id",student.getId());

            return ResultUtil.ok();
        }
        else
        {
            return ResultUtil.error("用户名或者密码错误，请重新输入");
        }

    }

    @RequestMapping("/getMenus")
    @ResponseBody
    public List<Menu> getMenus(HttpSession session)
    {
        //System.out.println("学生获取菜单进来了");
        List<Menu> menus=null;
        Student student= (Student) session.getAttribute("hotel_user");
//        Student student= (Student) session.getAttribute("student");
        Student student1=studentService.getStudentById(student.getId());
        if(student1!=null)
        {
            menus=studentService.getMenus(student1);
        }
        return menus;
    }

    @RequestMapping("/logOut")
    public ModelAndView logOut(ModelAndView modelAndView, HttpSession session)
    {
        session.invalidate();
        modelAndView.setViewName("redirect:/index.jsp");
        return modelAndView;
    }



    @RequestMapping("/info")
    public String info(HttpSession session)
    {
        //覆盖一下之前的hotel_user 不然显示的还是之前的hotel_user
        Integer student_id= (Integer) session.getAttribute("hotel_user_id");
//        Integer student_id= (Integer) session.getAttribute("student_id");
        Student student=studentService.getStudentById(student_id);
        session.setAttribute("hotel_user",student);
//        session.setAttribute("student",student);
        return "/jsp/student/editStudent";
    }


    @RequestMapping("/changePassword")
    public  String changePassword()
    {
        return "/jsp/student/changePassword";
    }
    @RequestMapping("/changeStudentPassword")
    @ResponseBody
    public ResultUtil changeStudentPassword(String oldPassword,String newPassword1,String username)
    {
        Student student=studentService.getStudentByUsername(username);
        if(student!=null)
        {
            if(student.getPassword().equals(EncryptUtil.encrypt(oldPassword)))
            {
                student.setPassword(EncryptUtil.encrypt(newPassword1));
                studentService.updateStudent(student);
                return ResultUtil.ok();
            }
            else
            {
                return ResultUtil.error("旧密码错误，请重新填写");
            }
        }
        return ResultUtil.error("请求出错！！");

    }



    @RequestMapping("/studentList")
    public String studentList(HttpSession session)
    {

        List<Dormitory> dormitories=dormitoryService.getAllDormitories();
        session.setAttribute("dormitories",dormitories);
        return "/jsp/student/studentList";
    }
    @RequestMapping("/getAllStudentList")
    @ResponseBody
    public ResultUtil getAllStudentList(Integer page, Integer limit, StudentSearch search)
    {
        //这是带分页的查询
        return studentService.getAllStudentList(page,limit,search);
    }


    @RequestMapping("/deleteStudentById")
    @ResponseBody
    public ResultUtil deleteStudentById(int id)
    {
        return studentService.deleteStudentById(id);
    }


    @RequestMapping("/editStudent/{id}")
    public String editStudent(@PathVariable("id")int id, HttpSession session)
    {
        Student student=studentService.getStudentById(id);
        session.setAttribute("hotel_user",student);
        return "/jsp/student/editStudent";
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public ResultUtil updateStudent(Student student)throws ParseException
    {
        return studentService.updateStudent(student);
    }


    @RequestMapping("/addStudent")
    public String addStudent()
    {
        return "/jsp/student/addStudent";
    }
    @RequestMapping("/checkStudentByStudentname/{username}")
    @ResponseBody
    public ResultUtil checkStudentByStudentname(@PathVariable("username")String username)
    {
        Student student=studentService.selStudentByStudentname(username);
        if(student!=null)
        {
            return new ResultUtil(500,"学生姓名已经存在，请做标记");
        }
        return new ResultUtil(0);
    }

    @RequestMapping("/insertStudent")
    @ResponseBody
    public ResultUtil insStudent(Student student)
    {
        student.setPassword(EncryptUtil.encrypt("123456"));
        student.setRoleId(2);
        try {
            studentService.insertStudent(student);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }

}
