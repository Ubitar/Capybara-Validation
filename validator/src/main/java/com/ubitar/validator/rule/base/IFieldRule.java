package com.ubitar.validator.rule.base;

import androidx.annotation.NonNull;

public interface IFieldRule<Field> extends IRule {
    Field getField();

    boolean onMatchField(Field field);
}
