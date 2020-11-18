package com.ubitar.validator.rule.base;

import java.util.Map;

public interface IMapRule extends IRule {
    boolean onMatchMap(Map field);
}
