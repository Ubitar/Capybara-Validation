package com.ubitar.validator.validation;

import com.ubitar.validator.comparator.IComparator;
import com.ubitar.validator.result.IResult;

public interface IValidation<Raw> {

     Raw getRaw();

      IResult<Raw> onValid(IComparator<Raw> comparator);

}
