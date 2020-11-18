package com.ubitar.validator.comparator;

import com.ubitar.validator.result.IResult;
import com.ubitar.validator.rule.base.IRule;

public interface IComparator<Raw> {

    IComparator<Raw> addItem(IRule rule);

    IResult<Raw> validate();

}