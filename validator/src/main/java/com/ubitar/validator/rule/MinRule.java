package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.IDoubleRule;
import com.ubitar.validator.rule.base.IFloatRule;
import com.ubitar.validator.rule.base.IIntRule;
import com.ubitar.validator.rule.base.ILongRule;
import com.ubitar.validator.rule.base.IShortRule;

public class MinRule extends BaseRule<Object> implements IIntRule, IShortRule, ILongRule, IFloatRule, IDoubleRule {

    /**
     * Is the case equal to the comparison value included
     */
    private boolean isEquals;
    private Number minValue;
    private String message;
    private String tag;

    public MinRule(short field, short value, boolean isEquals, String message, String tag) {
        this(field, value, isEquals, message);
        this.tag = tag;
    }

    public MinRule(int field, int value, boolean isEquals, String message, String tag) {
        this(field, value, isEquals, message);
        this.tag = tag;
    }

    public MinRule(long field, long value, boolean isEquals, String message, String tag) {
        this(field, value, isEquals, message);
        this.tag = tag;
    }

    public MinRule(float field, float value, boolean isEquals, String message, String tag) {
        this(field, value, isEquals, message);
        this.tag = tag;
    }

    public MinRule(double field, double value, boolean isEquals, String message, String tag) {
        this(field, value, isEquals, message);
        this.tag = tag;
    }

    public MinRule(short field, short value, boolean isEquals, String message) {
        super(field);
        this.minValue = value;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MinRule(int field, int value, boolean isEquals, String message) {
        super(field);
        this.minValue = value;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MinRule(long field, long value, boolean isEquals, String message) {
        super(field);
        this.minValue = value;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MinRule(float field, float value, boolean isEquals, String message) {
        super(field);
        this.minValue = value;
        this.isEquals = isEquals;
        this.message = message;
    }

    public MinRule(double field, double value, boolean isEquals, String message) {
        super(field);
        this.minValue = value;
        this.isEquals = isEquals;
        this.message = message;
    }

    @Override
    public boolean onMatchShort(short field) {
        if (isEquals) return field >= minValue.shortValue();
        else return field > minValue.shortValue();
    }

    @Override
    public boolean onMatchInt(int field) {
        if (isEquals) return field >=  minValue.intValue();
        else return field > minValue.intValue();
    }

    @Override
    public boolean onMatchLong(long field) {
        if (isEquals) return field >=  minValue.longValue();
        else return field > minValue.longValue();
    }

    @Override
    public boolean onMatchFloat(float field) {
        if (isEquals) return field >=  minValue.floatValue();
        else return field > minValue.floatValue();
    }

    @Override
    public boolean onMatchDouble(double field) {
        if (isEquals) return field >=  minValue.doubleValue();
        else return field > minValue.doubleValue();
    }

    @Override
    public boolean onMatchField(Object o) {
        message = "MinValueRule only support Int/Short/Long/Float/Double Type";
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
