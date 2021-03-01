package com.taobao.service;

import com.taobao.domain.AjaxRes;
import com.taobao.domain.Menu;
import com.taobao.domain.PageListRes;
import com.taobao.domain.QueryVo;
import java.util.List;
public interface MenuService {
    PageListRes getMenuList(QueryVo vo);

    List<Menu> parentList();

    void saveMenu(Menu menu);

    AjaxRes updateMenu(Menu menu);

    AjaxRes deleteMenu(Long id);

    List<Menu> getTreeData();
}
