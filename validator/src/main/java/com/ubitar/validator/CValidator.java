package com.ubitar.validator;

import com.ubitar.validator.comparator.CComparator;
import com.ubitar.validator.comparator.IComparator;
import com.ubitar.validator.result.IResult;
import com.ubitar.validator.validation.IValidation;

public class CValidator {

    public static <Raw> IResult<Raw> valid(IValidation<Raw> validation) {
        IComparator<Raw> comparator = new CComparator<Raw>(validation.getRaw());
        return validation.onValid(comparator);
    }

}
