package com.ubitar.validator.rule.base;

import java.util.Collection;
import java.util.Map;

public abstract class BaseRule<Field> implements IFieldRule<Field> {

    protected Field field;

    public BaseRule(Field field) {
        this.field = field;
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public boolean onMatch() {
        Field field = getField();
        if (isShortFormat(field)) {
            return ((IShortRule) this).onMatchShort((Short) field);
        } else if (isIntFormat(field)) {
            return ((IIntRule) this).onMatchInt((Integer) field);
        } else if (isLongFormat(field)) {
            return ((ILongRule) this).onMatchLong((Long) field);
        } else if (isFloatFormat(field)) {
            return ((IFloatRule) this).onMatchFloat((Float) field);
        } else if (isDoubleFormat(field)) {
            return ((IDoubleRule) this).onMatchDouble((Double) field);
        } else if (isStringFormat(field)) {
            return ((IStringRule) this).onMatchString((String) field);
        } else if (isMapFormat(field)) {
            return ((IMapRule) this).onMatchMap((Map) field);
        } else if (isCollectionFormat(field)) {
            return ((ICollectionRule) this).onMatchCollection((Collection) field);
        } else {
            return ((IFieldRule) this).onMatchField(field);
        }
    }

    private boolean isShortFormat(Field field) {
        return (field instanceof Short) && (this instanceof IShortRule);
    }

    private boolean isIntFormat(Field field) {
        return (field instanceof Integer) && (this instanceof IIntRule);
    }

    private boolean isLongFormat(Field field) {
        return (field instanceof Long) && (this instanceof ILongRule);
    }

    private boolean isFloatFormat(Field field) {
        return (field instanceof Float) && (this instanceof IFloatRule);
    }

    private boolean isDoubleFormat(Field field) {
        return (field instanceof Double) && (this instanceof IDoubleRule);
    }

    private boolean isStringFormat(Field field) {
        return (field instanceof String) && (this instanceof IStringRule);
    }

    private boolean isMapFormat(Field field) {
        return (field instanceof Map) && (this instanceof IMapRule);
    }

    private boolean isCollectionFormat(Field field) {
        return (field instanceof Collection) && (this instanceof ICollectionRule);
    }

}
