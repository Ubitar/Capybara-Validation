package com.ubitar.validator.rule.base;

import java.util.Collection;

public interface ICollectionRule extends IRule {
    boolean onMatchCollection(Collection field);

}
