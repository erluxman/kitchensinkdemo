package com.codename1.demos.kitchen.containers;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

import java.util.ArrayList;

public class ComponentDemo {
    String title;
    ArrayList<SubComponentDemo> subComponents = new ArrayList<>();

    public ComponentDemo(String title) {
        this.title = title;
    }

    public ComponentDemo add(String title, Component body) {
        subComponents.add(new SubComponentDemo(title, body));
        return this;
    }

    public Container generate() {
        Label componentTitle = new Label(title, "componentTitle");

        Container componentDemo = new Container(BoxLayout.y(), "componentDemo");
        componentDemo.add(componentTitle);
        componentDemo.setScrollableY(true);

        for (SubComponentDemo subComponent : subComponents) {
            componentDemo.add(
                    new Container(BoxLayout.y(), "demoArea")
                            .add(new Container(BoxLayout.y(), "subComponent")
                                    .add(subComponent.body)

                            ).add(new Label(subComponent.title, "subComponentLabel"))
            );
        }
        return componentDemo;
    }

    private  static class SubComponentDemo {
        String title;
        Component body;

        public SubComponentDemo(String title, Component body) {
            this.title = title;
            this.body = body;
        }
    }
}


