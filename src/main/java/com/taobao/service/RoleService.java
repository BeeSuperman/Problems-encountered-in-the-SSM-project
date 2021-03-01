package com.taobao.service;

import com.taobao.domain.PageListRes;
import com.taobao.domain.Permission;
import com.taobao.domain.QueryVo;
import com.taobao.domain.Role;

import java.util.List;

public interface RoleService {

    PageListRes selectAll(QueryVo vo);
    /*保存角色和权限*/
    void saverole(Role roles);

    void updateRole(Role roles);

    void deleteRole(Long rid);
    List<Role> selectAllList();

    List<Long> getRoleByEid(Long id);
}
