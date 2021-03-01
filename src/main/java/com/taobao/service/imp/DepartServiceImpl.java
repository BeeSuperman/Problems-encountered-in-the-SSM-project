package com.taobao.service.imp;

import com.taobao.domain.Department;
import com.taobao.mapper.DepartmentMapper;
import com.taobao.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartServiceImpl implements DepartService {
    @Autowired
     private  DepartmentMapper departmentMapper;


    @Override
    public  List<Department>  selectAll() {
       List<Department> departments = departmentMapper.selectAll();
        return  departments;
    }
}
