package com.ubitar.validator.demo.demo2.bean;

public class RawBean2 {

    private RawBeanInner innerClass;

    public RawBeanInner getInnerClass() {
        return innerClass;
    }

    public void setInnerClass(RawBeanInner innerClass) {
        this.innerClass = innerClass;
    }

    public static class RawBeanInner {
        private String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}
