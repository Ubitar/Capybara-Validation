package com.ubitar.validator.result;


import androidx.annotation.NonNull;

import com.ubitar.validator.reason.IReason;

import java.util.List;

public interface IResult<Raw> {

    @NonNull
    Raw getRaw();

    boolean hasError();

    @NonNull
    IReason getReasonAtFirst();

    @NonNull
    List<IReason> getAllReason();

}
