package com.taobao.controller;

import com.taobao.domain.AjaxRes;
import com.taobao.domain.Menu;
import com.taobao.domain.PageListRes;
import com.taobao.domain.QueryVo;
import com.taobao.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;


    @RequestMapping("/menu")
    public String employee(){
        return "menu";
    }

    @RequestMapping("/menuList")
    @ResponseBody
    public PageListRes menuList(QueryVo vo){
        /*调用业务层查询菜单*/
        PageListRes pageListRes = menuService.getMenuList(vo);
        System.out.println(pageListRes);
        return pageListRes;
    }

    /*加载对话框的父菜单下拉列表，即查询所有的菜单展示出来（提供选择）*/
    @RequestMapping("/parentList")
    @ResponseBody
    public List<Menu>parentList(){
        return  menuService.parentList();
    }

    /*保存菜单*/
    @RequestMapping("/saveMenu")
    @ResponseBody
    public AjaxRes saveMenu(Menu menu){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存菜单*/
            menuService.saveMenu(menu);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setSuccess(false);
            ajaxRes.setMsg("保存失败");
            System.out.println(e);
        }
        return ajaxRes;
    }
    /*更新菜单*/
    @RequestMapping("/updateMenu")
    @ResponseBody
    public AjaxRes updateMenu(Menu menu){
        return menuService.updateMenu(menu);
    }


    /*删除菜单*/
    @RequestMapping("/deleteMenu")
    @ResponseBody
    public AjaxRes deleteMenu(Long id){
        return menuService.deleteMenu(id);
    }

    /*获取树形菜单数据*/
    @RequestMapping("/getTreeData")
    @ResponseBody
    public List<Menu> getTreeData(){
        return menuService.getTreeData();
    }


}
