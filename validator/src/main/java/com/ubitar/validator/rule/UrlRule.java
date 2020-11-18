package com.ubitar.validator.rule;

import android.util.Patterns;

import androidx.annotation.Nullable;

import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.IStringRule;

import org.jetbrains.annotations.NotNull;


public class UrlRule extends BaseRule<String>{

    private String message;
    private String tag;


    public UrlRule(@Nullable String field,  String message, String tag) {
        this(field,  message);
        this.tag = tag;
    }

    public UrlRule(@Nullable String field, String message) {
        super(field);
        this.message = message;
    }

    @Override
    public boolean onMatchField(String field) {
        return Patterns.WEB_URL.matcher(field).matches();
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
