package com.ubitar.validator.demo.demo2.validation;

import com.ubitar.validator.comparator.IComparator;
import com.ubitar.validator.demo.demo2.bean.RawBean2;
import com.ubitar.validator.demo.demo2.rule.Demo2Rule;
import com.ubitar.validator.result.IResult;
import com.ubitar.validator.validation.BaseValidation;

public class RawValidation2 extends BaseValidation<RawBean2> {
    public RawValidation2(RawBean2 rawBean2) {
        super(rawBean2);
    }

    @Override
    public IResult<RawBean2> onValid(IComparator<RawBean2> comparator) {
        RawBean2 rawBean=getRaw();
        return comparator
                .addItem(new Demo2Rule(rawBean.getInnerClass(),"内部类内的str变量不为123"))
                .validate();
    }
}
