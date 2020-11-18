package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.ICollectionRule;
import com.ubitar.validator.rule.base.IMapRule;
import com.ubitar.validator.rule.base.IStringRule;

import java.util.Collection;
import java.util.Map;

public class NotSpaceyRule extends BaseRule<Object> implements IStringRule {

    private String message;
    private String tag;

    public NotSpaceyRule(@Nullable String field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public NotSpaceyRule(@Nullable String field, String message) {
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
        message = "NoteEmptyRule only support String Type";
        return false;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getTag() {
        return tag;
    }
}
