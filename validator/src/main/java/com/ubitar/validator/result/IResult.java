package com.ubitar.validator.result;


import com.ubitar.validator.reason.IReason;

import java.util.List;

public interface IResult<Raw> {

    Raw getRaw();

    boolean isValid();

    IReason getReasonAtFirst();

    List<IReason> getAllReason();

}
