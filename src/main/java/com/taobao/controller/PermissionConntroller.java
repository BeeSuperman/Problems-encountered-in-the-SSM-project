package com.taobao.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.taobao.domain.Permission;
import com.taobao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PermissionConntroller {
    @Autowired
    private PermissionService permissionServiceimp;
    @RequestMapping("/permissionList")
    @ResponseBody
    public List<Permission> getpermissionList() {
        List<Permission> permissionlist = permissionServiceimp.selectAll();
        return permissionlist;
    }
    @RequestMapping("/getPermissionByRid")
        @ResponseBody
        public List<Permission> getPermissionByRid(Long rid){
            List<Permission> permissionByRid = permissionServiceimp.getPermissionByRid(rid);
            return  permissionByRid;
    }
}
