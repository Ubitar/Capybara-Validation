package com.ubitar.validator;

import androidx.annotation.NonNull;

import com.ubitar.validator.comparator.CComparator;
import com.ubitar.validator.comparator.IComparator;
import com.ubitar.validator.result.IResult;
import com.ubitar.validator.validation.IValidation;



public class CValidator {

    @NonNull
    public static <Raw> IResult<Raw> valid(@NonNull IValidation<Raw> validation) {
        return valid(validation, true);
    }

    @NonNull
    public static <Raw> IResult<Raw> valid(@NonNull IValidation<Raw> validation, boolean isQuickMode) {
        IComparator<Raw> comparator = new CComparator<Raw>(validation.getRaw(), isQuickMode);
        return validation.onValid(comparator);
    }

}
