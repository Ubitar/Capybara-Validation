package com.ubitar.validator;

import com.ubitar.validator.comparator.CComparator;
import com.ubitar.validator.comparator.IComparator;
import com.ubitar.validator.result.IResult;
import com.ubitar.validator.validation.IValidation;

public class CValidator {

    public static <Raw> IResult<Raw> valid(IValidation<Raw> validation) {
        return valid(validation, true);
    }

    public static <Raw> IResult<Raw> valid(IValidation<Raw> validation, boolean isQuickMode) {
        IComparator<Raw> comparator = new CComparator<Raw>(validation.getRaw(), isQuickMode);
        return validation.onValid(comparator);
    }

}
