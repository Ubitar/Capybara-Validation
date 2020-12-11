package com.ubitar.validator.rule.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

interface IMarker {
    @NonNull
    String getMessage();

    @Nullable
    String getTag();
}
