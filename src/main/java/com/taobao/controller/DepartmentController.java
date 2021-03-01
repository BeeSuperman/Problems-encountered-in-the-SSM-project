package com.taobao.controller;

import com.taobao.domain.Department;
import com.taobao.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

        @Autowired
        private DepartService departServiceImp;
        @RequestMapping("/departList")
        @ResponseBody
        public List<Department>  departList(){
            List<Department> departments = departServiceImp.selectAll();
            return departments;

        }
}
