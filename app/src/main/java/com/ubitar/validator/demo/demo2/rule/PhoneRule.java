package com.ubitar.validator.demo.demo2.rule;

import androidx.annotation.Nullable;

import com.ubitar.validator.demo.demo2.bean.RawBean2;
import com.ubitar.validator.rule.base.BaseRule;

import java.util.regex.Pattern;

public class PhoneRule extends BaseRule<String> {

    /**
     * Regex of simple mobile.
     */
    public static final String REGEX_MOBILE_SIMPLE = "^[1]\\d{10}$";

    private String message;
    private String tag;

    public PhoneRule(@Nullable String field, String message, String tag) {
        this(field, message);
        this.tag = tag;
    }

    public PhoneRule(@Nullable String field, String message) {
        super(field);
        this.message = message;
    }

    /**
     * your custom valid
     *
     * @return true :pass valid    false:unpass
     */
    @Override
    public boolean onMatchField(String field) {
        if (field == null||field.length()<=0) return false;
        return Pattern.matches(REGEX_MOBILE_SIMPLE, field);
    }

    /**
     * your can get the error message after the verification fails
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * your can get the tag after the verification fails
     */
    @Override
    public String getTag() {
        return tag;
    }
}
