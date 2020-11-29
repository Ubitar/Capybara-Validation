package com.ubitar.validator.validation;

import androidx.annotation.NonNull;

import com.ubitar.validator.comparator.IComparator;
import com.ubitar.validator.result.IResult;

public interface IValidation<Raw> {

    @NonNull
    Raw getRaw();

    IResult<Raw> onValid(@NonNull IComparator<Raw> comparator);

}
