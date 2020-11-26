package com.ubitar.validator.comparator;

import com.ubitar.validator.reason.CReason;
import com.ubitar.validator.reason.IReason;
import com.ubitar.validator.result.CResult;
import com.ubitar.validator.result.IResult;
import com.ubitar.validator.rule.base.IRule;

import java.util.ArrayList;
import java.util.List;

public class CComparator<Raw> implements IComparator {

    private Raw raw;
    private boolean isQuickCompareMode = true;

    private List<IRule> items = new ArrayList<IRule>();

    public CComparator(Raw raw) {
        this(raw, true);
    }

    public CComparator(Raw raw, boolean isQuickCompareMode) {
        this.raw = raw;
        this.isQuickCompareMode = isQuickCompareMode;
    }

    @Override
    public CComparator<Raw> addItem(IRule rule) {
        items.add(rule);
        return this;
    }

    @Override
    public IResult<Raw> validate() {
        CResult<Raw> results = new CResult<Raw>(raw);
        for (IRule item : items) {
            if (!item.onMatch()) {
                String message = item.getMessage();
                IReason reason = new CReason(message, item);
                results.addReason(reason);
                if (isQuickCompareMode) break;
            }
        }
        return results;
    }

}
