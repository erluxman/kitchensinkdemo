package com.codename1.demos.kitchen.componentdemos;

import com.codename1.demos.kitchen.Demo;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.GridLayout;

import java.util.Arrays;
import java.util.List;

public class DemoComponents extends Demo {
    static List<DemoComponent> demoComponentList = Arrays.asList(
            new DemoComponent[]{
                    new ChartsDemo(),
                    new AdvancedDemo(),
                    new MapsDemo(),
                    new LabelDemo(),
                    new ButtonsDemo(),
                    new TogglesDemo(),
                    new ToggleListDemo(),
                    new SelectionDemo(),
                    new TextfieldDemo(),
                    new ContainersDemo(),
                    new DialogDemo(),
                    new ProgressDemo(),
                    new ToolbarDemo(),
                    new MediaDemo()
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
