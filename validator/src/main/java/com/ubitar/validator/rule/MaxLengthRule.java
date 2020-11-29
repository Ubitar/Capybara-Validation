package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.ICollectionRule;
import com.ubitar.validator.rule.base.IMapRule;
import com.ubitar.validator.rule.base.IStringRule;

import java.util.Collection;
import java.util.Map;

public class MaxLengthRule extends BaseRule<Object> implements ICollectionRule, IMapRule, IStringRule {


    /**
     * Is the case equal to the comparison value included
     */
    private boolean isEquals;
    private int length;
    private String message;
    private String tag;

    public MaxLengthRule(@Nullable Collection field, int length, boolean isEquals, String message, String tag) {
        this(field, length, isEquals, message);
        this.tag = tag;
    }

    public MaxLengthRule(@Nullable Map field, int length, boolean isEquals, String message, String tag) {
        this(field, length, isEquals, message);
        this.tag = tag;
    }

    public MaxLengthRule(@Nullable String field, int length, boolean isEquals, String message, String tag) {
        this(field, length, isEquals, message);
        this.tag = tag;
    }

    public MaxLengthRule(@Nullable Collection field, int length, boolean isEquals, String message) {
        super(field);
        this.length = length;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MaxLengthRule(@Nullable Map field, int length, boolean isEquals, String message) {
        super(field);
        this.length = length;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MaxLengthRule(@Nullable String field, int length, boolean isEquals, String message) {
        super(field);
        this.length = length;
        this.isEquals = isEquals;
        this.message = message;
    }

    @Override
    public boolean onMatchCollection(Collection field) {
        if (field == null) return false;
        else if (isEquals) return field.size() <= length;
        else return field.size() < length;
    }

    @Override
    public boolean onMatchMap(Map field) {
        if (field == null) return false;
        else if (isEquals) return field.size() <= length;
        else return field.size() < length;
    }

    @Override
    public boolean onMatchString(String field) {
        if (field == null) return false;
        else if (isEquals) return field.length() <= length;
        else return field.length() < length;
    }

    @Override
    public boolean onMatchField(Object o) {
        message = "MaxLengthRule only support Collection/Map/String Type";
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
