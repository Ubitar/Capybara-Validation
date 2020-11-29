package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.IDoubleRule;
import com.ubitar.validator.rule.base.IFloatRule;
import com.ubitar.validator.rule.base.IIntRule;
import com.ubitar.validator.rule.base.ILongRule;
import com.ubitar.validator.rule.base.IShortRule;

public class MaxRule extends BaseRule<Object> implements IIntRule, IShortRule, ILongRule, IFloatRule, IDoubleRule {

    /**
     * Is the case equal to the comparison value included
     */
    private boolean isEquals;
    private Number maxValue;
    private String message;
    private String tag;

    public MaxRule(short field, short max, boolean isEquals, String message, String tag) {
        this(field, max, isEquals, message);
        this.tag = tag;
    }

    public MaxRule(int field, int max, boolean isEquals, String message, String tag) {
        this(field, max, isEquals, message);
        this.tag = tag;
    }

    public MaxRule(long field, long max, boolean isEquals, String message, String tag) {
        this(field, max, isEquals, message);
        this.tag = tag;
    }

    public MaxRule(float field, float max, boolean isEquals, String message, String tag) {
        this(field, max, isEquals, message);
        this.tag = tag;
    }

    public MaxRule(double field, double max, boolean isEquals, String message, String tag) {
        this(field, max, isEquals, message);
        this.tag = tag;
    }

    public MaxRule(short field, short max, boolean isEquals, String message) {
        super(field);
        this.maxValue = max;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MaxRule(int field, int max, boolean isEquals, String message) {
        super(field);
        this.maxValue = max;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MaxRule(long field, long max, boolean isEquals, String message) {
        super(field);
        this.maxValue = max;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MaxRule(float field, float max, boolean isEquals, String message) {
        super(field);
        this.maxValue = max;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MaxRule(double field, double max, boolean isEquals, String message) {
        super(field);
        this.maxValue = max;
        this.isEquals = isEquals;
        this.message = message;
    }

    @Override
    public boolean onMatchShort(short field) {
        if (isEquals) return field <= maxValue.shortValue();
        else return field < maxValue.shortValue();
    }

    @Override
    public boolean onMatchInt(int field) {
        if (isEquals) return field <= maxValue.intValue();
        else return field < maxValue.intValue();
    }

    @Override
    public boolean onMatchLong(long field) {
        if (isEquals) return field <= maxValue.longValue();
        else return field < maxValue.longValue();
    }

    @Override
    public boolean onMatchFloat(float field) {
        if (isEquals) return field <= maxValue.floatValue();
        else return field < maxValue.floatValue();
    }

    @Override
    public boolean onMatchDouble(double field) {
        if (isEquals) return field <= maxValue.doubleValue();
        else return field < maxValue.doubleValue();
    }

    @Override
    public boolean onMatchField(Object o) {
        message = "MaxValueRule only support Int/Short/Long/Float/Double Type";
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
