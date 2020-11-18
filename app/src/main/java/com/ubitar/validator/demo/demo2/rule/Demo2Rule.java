package com.ubitar.validator.demo.demo2.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.demo.demo2.bean.RawBean2;
import com.ubitar.validator.rule.base.BaseRule;

public class Demo2Rule extends BaseRule<RawBean2.RawBeanInner> {

    private String message;
    private String tag;

    public Demo2Rule(@Nullable RawBean2.RawBeanInner field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public Demo2Rule(@Nullable RawBean2.RawBeanInner field, String message) {
        super(field);
        this.message = message;
    }

    /** 自定义内容校验过程  */
    @Override
    public boolean onMatchField(RawBean2.RawBeanInner rawBeanInner) {
        if(rawBeanInner==null) return false;
        return rawBeanInner.getStr().equals("123");
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getTag() {
        return tag;
    }
}
