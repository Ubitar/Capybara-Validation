package com.ubitar.validator.comparator;

import androidx.annotation.NonNull;

import com.ubitar.validator.result.IResult;
import com.ubitar.validator.rule.base.IRule;

public interface IComparator<Raw> {

    @NonNull
    IComparator<Raw> addItem(@NonNull IRule rule);

    @NonNull
    IResult<Raw> validate();

}