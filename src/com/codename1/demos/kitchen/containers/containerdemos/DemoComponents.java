package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.demos.kitchen.Demo;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.GridLayout;

import java.util.Arrays;
import java.util.List;

public class DemoComponents extends Demo {
    List<DemoComponent> demoComponentList = Arrays.asList(
            new DemoComponent[]{
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo(),
                    new LabelDemo()
            }
    );

    public String getDisplayName() {
        return "Components";
    }

    //Get it
    public Image getDemoIcon() {
        return getResources().getImage("components.png");
    }

    public Container createDemo() {
        GridLayout g = new GridLayout(2);
        g.setAutoFit(true);
        Container selection = new Container(g);
        for (DemoComponent demoComponent : demoComponentList) {
            demoComponent.init(getResources());
            selection.addComponent(demoComponent.getMenuItem());
        }
        selection.setScrollableY(true);
        return selection;
    }
}
