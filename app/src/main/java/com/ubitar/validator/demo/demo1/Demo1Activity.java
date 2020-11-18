package com.ubitar.validator.demo.demo1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ubitar.validator.CValidator;
import com.ubitar.validator.demo.R;
import com.ubitar.validator.demo.demo1.bean.RawBean1;
import com.ubitar.validator.demo.demo1.validation.RawValidation1;
import com.ubitar.validator.reason.IReason;
import com.ubitar.validator.result.IResult;
import com.ubitar.validator.rule.base.BaseRule;
import com.ubitar.validator.rule.base.IFieldRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Demo1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        RawBean1 bean = new RawBean1();

        bean.setStr("xxx");
        bean.setIntValue(12);
        bean.setFloatValue(12f);
        bean.setList(getList());
        bean.setMap(getMap());

        IResult result = CValidator.valid(new RawValidation1(bean));
        boolean isValid = result.isValid();
        if (isValid) {
            Log.d("Demo1Activity", "valid pass");
        } else {
            IReason reason = result.getReasonAtFirst();

            String message = reason.getMessage();

            IFieldRule<Object> rule = (BaseRule<Object>) reason.getRule();
            String tag = rule.getTag();
            Object field = rule.getField();

            Log.d("Demo1Activity", message + "---" + tag + "---" + field);
        }
    }

    private List<String> getList() {
        ArrayList<String> list = new ArrayList();
        list.add("123");
        list.add("456");
        list.add("789");
        return list;
    }

    private HashMap<String, String> getMap() {
        HashMap<String, String> map = new HashMap();
        map.put("123", "123");
        map.put("456", "456");
        map.put("789", "789");
        return map;
    }
}
