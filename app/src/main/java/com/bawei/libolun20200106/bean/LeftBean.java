package com.bawei.libolun20200106.bean;

import java.util.List;

/**
 * @author 李博伦
 * @createTime 2020/1/6 9:01
 * @description 左侧列表的Bean类
 */
public class LeftBean {

    public String message;
    public String status;
    public List<Left> result;

    public static class Left {
        public String id;
        public String name;
        public List<Category> secondCategoryVo;

        public static class Category {
            public String id;
            public String name;
        }
    }
}
