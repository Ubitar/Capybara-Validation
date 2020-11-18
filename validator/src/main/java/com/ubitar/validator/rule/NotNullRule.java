package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;

public class NotNullRule extends BaseRule<Object> {

    private String message;
    private String tag;

    public NotNullRule(@Nullable Object field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public NotNullRule(@Nullable Object field, String message) {
        super(field);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public boolean onMatchField(Object field) {
        return field!=null;
    }

}
