package com.taobao.service;

import com.taobao.domain.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> selectAll();
    List<Permission>  getPermissionByRid(Long rid);
}
