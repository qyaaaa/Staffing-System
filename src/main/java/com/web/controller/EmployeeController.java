package com.web.controller;

import com.web.pojo.Department;
import com.web.pojo.Employee;
import com.web.service.DepartmentService;
import com.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取所有员工数据，并在model中添加emps属性，将获取到的员工集合放进去
     *
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeService.getEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    /**
     * 获取"添加员工"页面
     *
     * @return
     */
    @GetMapping("/add")
    public String getAddPage(Model model) {
        //获取所有部门信息
        Collection<Department> departments = departmentService.getDepartments();
        //将部门信息添加到model中
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    /**
     * 执行添加员工操作
     *
     * @param employee
     * @return
     */
    @PostMapping("/add")
    public String addMethod(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    /**
     * 获取员工修改页面，返回通过ID获取到的员工信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String getUpdatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("emp", employee);
        //获取到所有部门信息
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @PostMapping("/update")
    public String updateMethod(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    /**
     * 通过员工id删除员工
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteMethod(@PathVariable("id")Integer id){
        employeeService.removeEmployee(id);
        return "redirect:/emps";
    }
}
