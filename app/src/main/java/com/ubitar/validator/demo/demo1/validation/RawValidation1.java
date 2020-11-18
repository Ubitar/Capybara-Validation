package com.ubitar.validator.demo.demo1.validation;

import android.content.Context;

import com.ubitar.validator.comparator.IComparator;
import com.ubitar.validator.demo.demo1.bean.RawBean1;
import com.ubitar.validator.result.IResult;
import com.ubitar.validator.rule.EmailRule;
import com.ubitar.validator.rule.EqualsRule;
import com.ubitar.validator.rule.LengthRule;
import com.ubitar.validator.rule.MaxLengthRule;
import com.ubitar.validator.rule.MaxRule;
import com.ubitar.validator.rule.MinLengthRule;
import com.ubitar.validator.rule.NotEmptyRule;
import com.ubitar.validator.rule.NotNullRule;
import com.ubitar.validator.rule.NotSpaceyRule;
import com.ubitar.validator.rule.UrlRule;
import com.ubitar.validator.validation.BaseValidation;

public class RawValidation1 extends BaseValidation<RawBean1> {

    public RawValidation1(RawBean1 rawBean1) {
        super(rawBean1);
    }

    @Override
    public IResult<RawBean1> onValid(IComparator<RawBean1> comparator) {
        RawBean1 rawBean1 = getRaw();
        Context context=getContext();
        return comparator

                //String
                .addItem(new NotNullRule(rawBean1.getStr(), "str can't not be null","tag1"))
                .addItem(new NotEmptyRule(rawBean1.getStr(), "str can't not be empty","tag2"))
                .addItem(new NotSpaceyRule(rawBean1.getStr(), "str can't not be space"))
                .addItem(new UrlRule(rawBean1.getStr(), "str isn't url"))
                .addItem(new EmailRule(rawBean1.getStr(), "str isn't email"))
                .addItem(new EqualsRule(rawBean1.getStr(), "xxx", "str isn't equals xxx"))
                .addItem(new LengthRule(rawBean1.getStr(),3,"the length of str must equals 3"))
                .addItem(new MaxLengthRule(rawBean1.getStr(), 3, false, "the length of str  must bigger than 3"))
                .addItem(new MinLengthRule(rawBean1.getStr(), 3, false, "the length of str  must smaller than 3"))

                //int
                .addItem(new MaxRule(rawBean1.getIntValue(), 30, false, "int must bigger than 30"))
                .addItem(new MaxRule(rawBean1.getIntValue(), 30, true, "int must bigger or equals 30"))
                .addItem(new EqualsRule(rawBean1.getIntValue(), 30, "int must equals 30"))

                //float
                .addItem(new MaxRule(rawBean1.getFloatValue(), 30f, false, "float must bigger than 30"))
                //...

                //collection
                .addItem(new NotNullRule(rawBean1.getList(), "list can't not be null"))
                .addItem(new NotEmptyRule(rawBean1.getList(), "list can't not be empty"))
                .addItem(new LengthRule(rawBean1.getList(),3,"the length of list must be 3"))
                .addItem(new MaxLengthRule(rawBean1.getList(), 3, false, "the length of list  must bigger than 3"))
                .addItem(new MinLengthRule(rawBean1.getList(), 3, false, "the length of list  must smaller than 3"))

                //map
                .addItem(new NotNullRule(rawBean1.getMap(), "map can't not be null"))
                .addItem(new NotEmptyRule(rawBean1.getMap(), "map can't not be empty"))
                .addItem(new LengthRule(rawBean1.getMap(),3,"the length of map must be 3"))
                //..

                .validate();
    }
}
