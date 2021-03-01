package com.taobao.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Department {
    private Long id;

    private String name;

    private String sn;

    private Long managerId;

    private Long parentId;

    private Boolean state;


}