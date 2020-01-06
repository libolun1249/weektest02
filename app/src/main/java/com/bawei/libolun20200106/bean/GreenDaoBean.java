package com.bawei.libolun20200106.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:01
 * @description GreenDao的类
 */
@Entity
public class GreenDaoBean {

    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String json;
    @Generated(hash = 1097208545)
    public GreenDaoBean(Long id, String name, String json) {
        this.id = id;
        this.name = name;
        this.json = json;
    }
    @Generated(hash = 826843181)
    public GreenDaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
}
