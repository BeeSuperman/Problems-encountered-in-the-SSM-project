package com.taobao.mapper;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.taobao.domain.Permission;
import com.taobao.domain.QueryVo;
import com.taobao.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {//这里面的方法都是imp里用到的.
   void deleteByPrimaryKey(Long rid);

    int insert(Role record);

    Role selectByPrimaryKey(Long rid);
    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
    void insertRoleAndPermissionRel (@Param("rid") long rid, @Param("pid") long pid);
    void deleteRolePermissionRel(@Param("rid") Long rid);


    List<Long> getRoleWithId(Long id);
}