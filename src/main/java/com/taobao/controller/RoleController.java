package com.taobao.controller;

import com.taobao.domain.*;
import com.taobao.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class RoleController {
    /*注入业务层*/
    @Autowired
    private RoleService roleServiceimpl;
    @RequestMapping("/role")
    @RequiresPermissions("role:index")
    public String employee() {
        return "role";
    }

    /*接收 请求角色列表 请求*/
    @RequestMapping("/roleList")
    @ResponseBody
    public PageListRes getrolelist(QueryVo vo) {
        /*调用业务层, 查询角色列表*/
        PageListRes role = roleServiceimpl.selectAll(vo);
        return role;

    }

    /*接收  保存角色请求地址*/
    AjaxRes ajaxRes = new AjaxRes();

    @RequestMapping("saveRole")
    @ResponseBody
    public AjaxRes saveRole(Role role) {

        try {
            roleServiceimpl.saverole(role);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("保存成功");

        } catch (Exception e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");

        }
        return ajaxRes;
    }

    @RequestMapping("updateRole")
    @ResponseBody
    public AjaxRes updateRole(Role role) {
        try {
            roleServiceimpl.updateRole(role);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("更新成功");
        } catch (Exception e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("更新失败");

        }
        return ajaxRes;
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public AjaxRes deleteRole(Long rid) {
        try {
            roleServiceimpl.deleteRole(rid);
            ajaxRes.setSuccess(true);
            ajaxRes.setMsg("删除角色成功");

        } catch (Exception e) {
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("删除角色失败");
        }
        return ajaxRes;
    }

    @RequestMapping("/roleAllList")
    @ResponseBody
    public  List<Role> getroleAlllist() {
        /*调用业务层, 查询角色列表*/
        List<Role>  role = roleServiceimpl.selectAllList();
        return role;

    }

    /*根据用户id查询对应的角色*/
    @RequestMapping("/getRoleByEid")
    @ResponseBody
    public List<Long>getRoleByEid(Long id){
        /*查询对应的角色*/
        return roleServiceimpl.getRoleByEid(id);
    }
    }







