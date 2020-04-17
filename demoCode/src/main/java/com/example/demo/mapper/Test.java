package com.example.demo.mapper;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/4/16 17:55
 */
@TableName("test1")
public class Test extends Model<Test> {

    @TableId(value = "test")
    private String test;

    private String test1;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    @Override
    protected Serializable pkVal() {
        return this.test;
    }
}
