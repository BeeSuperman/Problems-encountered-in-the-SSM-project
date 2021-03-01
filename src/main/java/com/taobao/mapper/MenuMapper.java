package com.taobao.mapper;

import com.taobao.domain.Menu;
import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

   /* int insert(Menu record);*/

    Menu selectByPrimaryKey(Long id);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);

    void saveMenu(Menu menu);

    Long selectParentId(Long id);

    void updateMenuRel(Long id);

    List<Menu> getTreeData();
    List<Menu> ChildMenu();


}