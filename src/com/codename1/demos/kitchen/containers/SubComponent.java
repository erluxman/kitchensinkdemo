package com.codename1.demos.kitchen.containers;

import com.codename1.ui.Component;

public class SubComponent {
    String title;
    Component body;
    String componentInfo;
    Class componentClass;

    /**
     * <p>Use this method if the component whose JavaDocs is to be displayed is the
     * outermost container/component and there is no info about the component
     *
     * @author @erluxman
     */
    public SubComponent(String title, Component body) {
        this(title, body, "Blank Info", body.getClass());
    }

    /**
     * <p>Use this method if the component whose JavaDocs is to be displayed is not the
     * outermost container/component.
     *
     * @author @erluxman
     */
    public SubComponent(String title, Component body, String subComponentInfo, Class javaClass) {
        this.title = title;
        this.body = body;
        this.componentClass = javaClass;
        this.componentInfo = subComponentInfo;
    }

    /**
     * <p>Use this method if the component whose JavaDocs is to be displayed is the
     * outermost container/component.
     *
     * @author @erluxman
     */
    public SubComponent(String title, Component body, String componentInfo) {
        this(title, body, componentInfo, body.getClass());
    }

}

