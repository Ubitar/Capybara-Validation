package com.ubitar.validator.demo.demo2;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ubitar.validator.CValidator;
import com.ubitar.validator.demo.R;
import com.ubitar.validator.demo.demo1.validation.RawValidation1;
import com.ubitar.validator.demo.demo2.bean.RawBean2;
import com.ubitar.validator.demo.demo2.validation.RawValidation2;
import com.ubitar.validator.reason.IReason;
import com.ubitar.validator.result.IResult;
import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.IFieldRule;

public class Demo2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        RawBean2 bean=new RawBean2();
        RawBean2.RawBeanInner inner=new RawBean2.RawBeanInner();
        inner.setStr("112");
        bean.setInnerClass(inner);

        IResult result = CValidator.valid(new RawValidation2(bean));
        boolean isValid = result.isValid();
        if (isValid) {
            Log.d("Demo2Activity", "valid pass");
        } else {
            IReason reason = result.getReasonAtFirst();

            String message = reason.getMessage();

            IFieldRule<Object> rule = (BaseRule<Object>) reason.getRule();
            String tag = rule.getTag();
            Object field = rule.getField();

            Log.d("Demo2Activity", message + "---" + tag + "---" + field);
        }
    }
}
