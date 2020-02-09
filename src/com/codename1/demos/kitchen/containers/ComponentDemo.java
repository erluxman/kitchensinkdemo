package com.codename1.demos.kitchen.containers;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import java.util.ArrayList;

import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.EAST;
import static com.codename1.ui.CN.NORTH;
import static com.codename1.ui.CN.WEST;

public class ComponentDemo {
    String title;
    ArrayList<SubComponent> subComponents = new ArrayList<>();

    public ComponentDemo(String title) {
        this.title = title;
    }

    public ComponentDemo add(String title, Component body) {
        subComponents.add(new SubComponent(title, body));
        return this;
    }

    public ComponentDemo add(SubComponent subComponent) {
        subComponents.add(subComponent);
        return this;
    }

    public Container generate() {
        Label componentTitle = new Label(title, "componentTitle");

        Container componentDemo = new Container(BoxLayout.y(), "componentDemo");
        componentDemo.add(componentTitle);
        componentDemo.setScrollableY(true);

        for (SubComponent subComponent : subComponents) {
            Image icon = FontImage.createMaterial(FontImage.MATERIAL_INFO, "subComponentLabel", 5).toImage();
            Button infoButton= new Button(icon);
            infoButton.addActionListener(evt -> {
                System.out.println("Show info for the subcomponent");
            });

            Label info= new Label("This is all new kind of component");
            Form form = new Form(title, new BorderLayout());
            form.add(CENTER, BorderLayout.center(info));
            form.getToolbar().setBackCommand(title, evt -> infoButton.getComponentForm().showBack());
            infoButton.addActionListener(evt -> form.show());

            Label subtitle = new Label(subComponent.title, "subComponentLabel");
            Label centerBlank = new Label("                    ");
            Container interactionContent = new Container(new BorderLayout());
            interactionContent.add(WEST, subtitle);
            interactionContent.add(EAST, infoButton);
            interactionContent.add(CENTER, centerBlank);

            componentDemo.add(
                    new Container(BoxLayout.y(), "demoArea")
                            .add(new Container(BoxLayout.y(), "subComponent").add(subComponent.body)
                            ).add(new Container(new BoxLayout(BoxLayout.X_AXIS))
                            .add(interactionContent)));
        }
        new Container();
        return componentDemo;
    }
}


