package com.ubitar.validator.rule.base;

public interface IFieldRule<Field> extends IRule {
    Field getField();

    boolean onMatchField(Field field);
}
