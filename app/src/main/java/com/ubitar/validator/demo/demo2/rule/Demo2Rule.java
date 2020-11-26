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

    /**
     * your custom valid
     *
     * @return true :pass valid    false:pass invalid
     */
    @Override
    public boolean onMatchField(RawBean2.RawBeanInner rawBeanInner) {
        if (rawBeanInner == null) return false;
        return rawBeanInner.getStr().equals("123");
    }

    /**
     * your can get the error message after the verification fails
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * your can get the tag after the verification fails
     */
    @Override
    public String getTag() {
        return tag;
    }
}
