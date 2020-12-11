package com.ubitar.validator.reason;

import androidx.annotation.NonNull;

import com.ubitar.validator.rule.base.IRule;

public interface IReason {
    @NonNull
    String getMessage();

    @NonNull
    IRule getRule();
}
