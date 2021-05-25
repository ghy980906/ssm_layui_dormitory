package com.mecol.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mecol.dormitory.dao.MenuDao;
import com.mecol.dormitory.dao.RoleMenuDao;
import com.mecol.dormitory.dao.StudentDao;
import com.mecol.dormitory.entity.Menu;
import com.mecol.dormitory.entity.RoleMenu;
import com.mecol.dormitory.entity.Student;
import com.mecol.dormitory.entity.StudentSearch;
import com.mecol.dormitory.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private MenuDao menuDao;
    @Override
    public ResultUtil getAllStudentList(Integer page, Integer limit, StudentSearch search) {
        PageHelper.startPage(page,limit);
        List<Student> students=studentDao.getAllStudentList(search);
        PageInfo<Student> pageInfo=new PageInfo<>(students);
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public Student selStudentByStudentname(String username) {
        return studentDao.selStudentByStudentname(username);
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public ResultUtil deleteStudentById(int id) {
        studentDao.deleteStudentById(id);
        return ResultUtil.ok();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public ResultUtil updateStudent(Student student) {
        studentDao.updateStudent(student);
        return ResultUtil.ok();
    }

    @Override
    public Student login(String username, String encrypt) {
        return studentDao.login(username,encrypt);
    }

    @Override
    public List<Menu> getMenus(Student student1) {

        List<Menu> menuList=new ArrayList<>();
        Integer roleId=student1.getRoleId();
        List<RoleMenu> roleMenus=roleMenuDao.selMenusByRoleId(Long.valueOf(roleId));
        //rolemenu里面就是一个中间表 两个字段 roleId menuId 关联起来
        if(roleMenus!=null&&roleMenus.size()>0)
        {
            List<Menu> noChildrenMenus=new ArrayList<>();
            for(int i=0;i<roleMenus.size();i++)
            {
                Menu menu=menuDao.getMenuById(roleMenus.get(i).getMenuId()); //获取rolemenu中的menuId
                noChildrenMenus.add(menu); //就是根据这个登陆者的roleid 所拥有的菜单取出来
            }
            for(int i=0;i<noChildrenMenus.size();i++)
            {
                if(noChildrenMenus.get(i).getParentId()==0)
                //说明这个菜单是一级菜单 没有上一级菜单
                //如果这里不为0 表示这个菜单是二级菜单 或者三级菜单 ParentId对应了属于哪个上级菜单
                {
                    Menu menu=new Menu();
                    menu=noChildrenMenus.get(i); //把这个一级菜单取出来
                    List<Menu> menus=new ArrayList<>();
                    for(int j=0;j<noChildrenMenus.size();j++) //把所有菜单过一遍
                    {
                        //如果有菜单属于这个一级菜单
                        if(noChildrenMenus.get(j).getParentId()==noChildrenMenus.get(i).getMenuId())
                        {
                            Menu menu2=new Menu();
                            menu2=noChildrenMenus.get(j);//取出这个二级菜单
                            menus.add(menu2);
                        }
                    }
                    menu.setChildren(menus); //存放了属于这个一级菜单的所有二级菜单
                    menuList.add(menu);//存放了所有的一级菜单和其对应的所有二级菜单
                }
            }

        }
        //下面是根据menu的sorting进行排序 升序排列 这样左侧菜单就会按照升序排列
        Collections.sort(menuList, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {

                return o1.getSorting().compareTo(o2.getSorting());
            }
        });

        return menuList;
    }

    @Override
    public Student getStudentByUsername(String username) {
        return studentDao.getStudentByUsername(username);
    }
}
