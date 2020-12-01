package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.IStringRule;

public class NotSpaceRule extends BaseRule<Object> implements IStringRule {

    private String message;
    private String tag;

    public NotSpaceRule(@Nullable String field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public NotSpaceRule(@Nullable String field, String message) {
        super(field);
        this.message = message;
    }

    @Override
    public boolean onMatchString(String field) {
        if (field == null) return false;
        for (int i = 0, len = field.length(); i < len; ++i) {
            if (!Character.isWhitespace(field.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onMatchField(Object o) {
        if (field == null) return false;
        else{
            message = "NotSpaceRule only support String Type";
            return false;
        }
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
