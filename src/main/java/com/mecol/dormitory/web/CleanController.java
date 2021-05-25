package com.mecol.dormitory.web;

import com.mecol.dormitory.dao.AdminDao;
import com.mecol.dormitory.dao.DormitoryDao;
import com.mecol.dormitory.dao.StudentDao;
import com.mecol.dormitory.entity.*;
import com.mecol.dormitory.service.CleanService;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clean")
public class CleanController {

    @Autowired
    private CleanService cleanService;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private DormitoryDao dormitoryDao;



    @RequestMapping("/myCleanList")
    public String myCleanList()
    {

        return "/jsp/clean/myCleanList";
    }


    @RequestMapping("/cleanList")
    public String cleanList()
    {

        return "/jsp/clean/cleanList";
    }
    @RequestMapping("/getCleanList")
    @ResponseBody
    public ResultUtil getCleanList(Integer page, Integer limit)
    {
        //这是带分页的查询
        return cleanService.getClassList(page,limit);
    }




    @RequestMapping("/addClean")
    public String addClass(HttpSession session)
    {

        List<Student> students=studentDao.getAllStudent();
        List<Dormitory> dormitories=dormitoryDao.getAllDormitories();
        session.setAttribute("dormitories",dormitories);
        session.setAttribute("students",students);
        return "/jsp/clean/addClean";
    }


    /*
    @RequestMapping("/getStudentsByDormitoryId/{val}")
    public void getDormitoriesByStudentId(@PathVariable("val")Integer val,
                                          HttpSession session){
        //val 就是前端选中的宿舍的id 然后根据宿舍id查询 其下的学生
        List<Student> students=studentDao.getStudentByDormitoryId(val);
        session.setAttribute("students",students);
    }
    */

    @RequestMapping("/updateClean")
    @ResponseBody
    public ResultUtil updateClean(Clean clean){
        Student student=studentDao.getStudentBySIdAndDId(clean.getStudentId(),clean.getDormitoryId());
        if(student==null){ //说明选择的宿舍下面没有这个学生
            return ResultUtil.error("此宿舍下没有该学生，请重新选择");
        }
        try {
            cleanService.updateClean(clean);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }


    @RequestMapping("/insertClean")
    @ResponseBody
    public ResultUtil insertClean(Clean clean)
    {

        Student student=studentDao.getStudentBySIdAndDId(clean.getStudentId(),clean.getDormitoryId());
        if(student==null){ //说明选择的宿舍下面没有这个学生
            return ResultUtil.error("此宿舍下没有该学生，请重新选择");
        }
        try {
            cleanService.insertClean(clean);
            return  ResultUtil.ok();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResultUtil(500,"数据库sql等错误，请检查输出");
        }

    }

    @RequestMapping("/editClean/{id}")
    public String editClass(@PathVariable("id")int id, HttpSession session)
    {
        Clean clean=cleanService.getCleanById(id);
        List<Student> students=studentDao.getAllStudent();
        List<Dormitory> dormitories=dormitoryDao.getAllDormitories();
        session.setAttribute("dormitories",dormitories);
        session.setAttribute("students",students);
        session.setAttribute("clean",clean);
        return "/jsp/clean/editClean";
    }

    @RequestMapping("/delClean/{id}")
    @ResponseBody
    public ResultUtil delClean(@PathVariable("id")int id){
        cleanService.delCleanById(id);
        return ResultUtil.ok();
    }

//这个是导出excel时的数据接口 因为我们后台传过去的数据是关联表查询的
    //所以 有些数据没法导出 这里用CleanExcel类做转换
    @RequestMapping("/getAllCleanList")
    @ResponseBody
    public List<Clean> getAllCleanList(){

        List<Clean> cleanList=cleanService.getCleanList();
        return cleanList;
    }


}
