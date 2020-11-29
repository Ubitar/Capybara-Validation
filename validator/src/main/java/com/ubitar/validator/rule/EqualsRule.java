package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;

import org.jetbrains.annotations.NotNull;


public class EqualsRule extends BaseRule<Object> {

    private Object anotherValue;
    private String message;
    private String tag;


    public EqualsRule(@Nullable Object field, @NotNull Object anotherValue, String message, String tag) {
        this(field, anotherValue, message);
        this.tag = tag;
    }

    public EqualsRule(@Nullable Object field, @NotNull  Object anotherValue, String message) {
        super(field);
        this.anotherValue = anotherValue;
        this.message = message;
    }

    @Override
    public boolean onMatchField(Object field) {
        return field.equals(anotherValue);
    }

    @Nullable
    @Override
    public String getMessage() {
        return message;
    }

    @Nullable
    @Override
    public String getTag() {
        return tag;
    }
}
