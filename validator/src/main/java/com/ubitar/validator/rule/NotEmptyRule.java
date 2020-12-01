package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.ICollectionRule;
import com.ubitar.validator.rule.base.IMapRule;
import com.ubitar.validator.rule.base.IStringRule;

import java.util.Collection;
import java.util.Map;

public class NotEmptyRule extends BaseRule<Object> implements ICollectionRule, IMapRule, IStringRule {

    private String message;
    private String tag;

    public NotEmptyRule(@Nullable Collection field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public NotEmptyRule(@Nullable Map field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public NotEmptyRule(@Nullable String field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public NotEmptyRule(@Nullable Collection field, String message) {
        super(field);
        this.message = message;
    }

    public NotEmptyRule(@Nullable Map field, String message) {
        super(field);
        this.message = message;
    }

    public NotEmptyRule(@Nullable String field, String message) {
        super(field);
        this.message = message;
    }

    @Override
    public boolean onMatchCollection(Collection field) {
        if (field == null) return false;
        return !field.isEmpty();
    }

    @Override
    public boolean onMatchMap(Map field) {
        if (field == null) return false;
        return !field.isEmpty();
    }

    @Override
    public boolean onMatchString(String field) {
        return !(field == null || field.length() == 0);
    }

    @Override
    public boolean onMatchField(Object o) {
        if (field == null) return false;
        message = "NotEmptyRule only support Collection/Map/String Type";
        return false;
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
