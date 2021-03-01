package com.taobao.service.imp;

import com.taobao.domain.Permission;
import com.taobao.mapper.PermissionMapper;
import com.taobao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> selectAll() {
        List<Permission> permissions = permissionMapper.selectAll();
        return permissions;
    }

    @Override
    public List<Permission> getPermissionByRid(Long rid) {
        List<Permission> permissionByRid = permissionMapper.getPermissionByRid(rid);
        return permissionByRid;
    }
}
