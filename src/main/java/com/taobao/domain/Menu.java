package com.taobao.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter@ToString
public class Menu {
        private Long id;

        private String text;

        private String url;

        private Menu parent;
        private Permission permission;
       /* 将树形菜单从数据库中取出，不再是tree.json此静态文件中取出，
       每一个子菜单类型都是Menu，最外层的菜单也是Menu类型，这一点可以从也可以从tree.json文件有什么字段看出*/
        private List<Menu> children = new ArrayList<>();

    }
