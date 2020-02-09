package com.codename1.demos.kitchen.containers;

import com.codename1.ui.Component;

public class SubComponent {
    String title;
    Component body;
    SubComponentInfo subComponentInfo;


    public SubComponent(String title, Component body) {
        this(title, body, new SubComponentInfo("Blank Info", body.getClass()));
    }

    public SubComponent(String title, Component body, SubComponentInfo subComponentInfo) {
        this.title = title;
        this.body = body;
        this.subComponentInfo = subComponentInfo;
    }

    public SubComponent(String title, Component body, String subComponentInfo,Class javaClass) {
        this.title = title;
        this.body = body;
        this.subComponentInfo = new SubComponentInfo(subComponentInfo,javaClass);
    }

}

