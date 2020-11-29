package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.ICollectionRule;
import com.ubitar.validator.rule.base.IMapRule;
import com.ubitar.validator.rule.base.IStringRule;

import java.util.Collection;
import java.util.Map;

public class LengthRule extends BaseRule<Object> implements ICollectionRule, IMapRule, IStringRule {

    private int length;
    private String message;
    private String tag;

    public LengthRule(@Nullable Collection field, int length, String message, String tag) {
        this(field, length,  message);
        this.tag = tag;
    }

    public LengthRule(@Nullable Map field, int length,  String message, String tag) {
        this(field, length,  message);
        this.tag = tag;
    }

    public LengthRule(@Nullable String field, int length,  String message, String tag) {
        this(field, length,  message);
        this.tag = tag;
    }

    public LengthRule(@Nullable Collection field, int length,  String message) {
        super(field);
        this.length = length;
        this.message = message;
    }

    public LengthRule(@Nullable Map field, int length,  String message) {
        super(field);
        this.length = length;
        this.message = message;
    }

    public LengthRule(@Nullable String field, int length,  String message) {
        super(field);
        this.length = length;
        this.message = message;
    }

    @Override
    public boolean onMatchCollection(Collection field) {
        if (field == null) return false;
        else return field.size() == length;
    }

    @Override
    public boolean onMatchMap(Map field) {
        if (field == null) return false;
        else return field.size() == length;
    }

    @Override
    public boolean onMatchString(String field) {
        if (field == null) return false;
        else return field.length() == length;
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
