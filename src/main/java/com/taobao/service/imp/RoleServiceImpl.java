package com.taobao.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taobao.domain.PageListRes;
import com.taobao.domain.Permission;
import com.taobao.domain.QueryVo;
import com.taobao.domain.Role;
import com.taobao.mapper.RoleMapper;
import com.taobao.service.RoleService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public  PageListRes selectAll(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        List<Role> roleList = roleMapper.selectAll();
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(roleList);
        return pageListRes;
    }

    @Override
    public void saverole(Role roles) {
        //       1.保存角色
        roleMapper.insert(roles);
        //       2.保存角色与权限的关系
        for(Permission permission:roles.getPermissionArrayList()){
            roleMapper.insertRoleAndPermissionRel(roles.getRid(),permission.getPid());
        }
    }
    public void updateRole(Role roles){
//        1.打破原来的关系：
        roleMapper.deleteRolePermissionRel(roles.getRid());
//            2.更新角色
        roleMapper.updateByPrimaryKey(roles);
//            3.重新建立关系
        for(Permission permission : roles.getPermissionArrayList()){
            roleMapper.insertRoleAndPermissionRel(roles.getRid(),permission.getPid());
        }
    }

    @Override
    public void deleteRole(Long rid){
//        1.删除角色与权限的关系
        roleMapper.deleteRolePermissionRel(rid);
//        2.删除角色表里的角色
        roleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public List<Role> selectAllList() {
        return roleMapper.selectAll();
    }
    /*根据用户id查询对应的角色*/
    @Override
    public List<Long> getRoleByEid(Long id) {

        return  roleMapper.getRoleWithId(id);
    }


}
