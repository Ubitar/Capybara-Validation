package com.ubitar.validator.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;

import java.util.regex.Pattern;

public class EmailRule extends BaseRule<String> {

    public static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    private String message;
    private String tag;


    public EmailRule(@Nullable String field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public EmailRule(@Nullable String field, String message) {
        super(field);
        this.message = message;
    }

    @Override
    public boolean onMatchField(String field) {
        return Pattern.matches(REGEX_EMAIL, field);
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
