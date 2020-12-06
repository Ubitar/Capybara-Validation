package com.ubitar.validator.demo.demo2.validation;

import com.ubitar.validator.comparator.IComparator;
import com.ubitar.validator.demo.demo2.bean.RawBean2;
import com.ubitar.validator.demo.demo2.rule.PhoneRule;
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
                .addItem(new PhoneRule(rawBean.getPhone(),"Wrong phone number format"))
                .validate();
    }
}
