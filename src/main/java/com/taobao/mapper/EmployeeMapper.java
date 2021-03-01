package com.taobao.mapper;

import com.taobao.domain.Employee;
import com.taobao.domain.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    void insert(Employee employee);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(QueryVo vo);

    int updateByPrimaryKey(Employee record);
    void updateState(Long id);
    void insertEmployeeAndRoleRel ( @Param("id") Long eid, @Param("rid") Long rid);

    void deleteRoleRel(@Param("id") Long id);
    /*根据用户名当中查询有没有当前用户*/
    Employee getEmployeeWithUserName(String username);

    List<String> getRolesById(Long id);

    List<String> getPermissionById(Long id);
}