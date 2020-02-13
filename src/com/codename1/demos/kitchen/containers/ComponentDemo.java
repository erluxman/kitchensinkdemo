package com.codename1.demos.kitchen.containers;

import com.codename1.components.SpanLabel;
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
import static com.codename1.ui.CN.SOUTH;
import static com.codename1.ui.CN.WEST;
import static com.codename1.ui.CN.execute;

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

    public ComponentDemo add(String title, Component body, String info, Class javaClass) {
        subComponents.add(new SubComponent(title, body, info, javaClass));
        return this;
    }

    public ComponentDemo add(String title, Component body, String info) {
        subComponents.add(new SubComponent(title, body, info));
        return this;
    }

    public Container generate() {
        Label componentTitle = new Label(title, "componentTitle");

        Container componentDemo = new Container(BoxLayout.y(), "componentDemo");
        componentDemo.add(componentTitle);
        componentDemo.setScrollableY(true);

        for (SubComponent subComponent : subComponents) {
            componentDemo.add(
                    new Container(BoxLayout.y(), "demoArea")
                            .add(getComponentContainer(subComponent))
                            .add(getComponentFooter(subComponent)));
        }
        return componentDemo;
    }

    Container getComponentContainer(SubComponent subComponent) {
        Container componentContainer = new Container(BoxLayout.y(), "subComponent");
        componentContainer.add(subComponent.body);
        return componentContainer;
    }

    Container getComponentFooter(SubComponent subComponent) {
        Label subtitle = new Label(subComponent.title, "subComponentLabel");
        Label centerBlank = new Label("                                                                                                 ");

        Container footer = new Container(new BorderLayout());
        footer.add(WEST, subtitle);
        footer.add(EAST, getInfoButton(subComponent));
        footer.add(CENTER, centerBlank);
        return footer;
    }

    Button getInfoButton(SubComponent subComponent) {
        Image icon = FontImage.createMaterial(FontImage.MATERIAL_INFO, "subComponentLabel", 5).toImage();
        Button infoButton = new Button(icon);
        infoButton.addActionListener(evt -> {
            SpanLabel info = new SpanLabel(subComponent.componentInfo, "subComponent");
            Form form = new Form(subComponent.title, new BorderLayout());
            Button toJavaDocs = new Button("See More");
            toJavaDocs.addActionListener(evt1 -> {
                execute(getJavaDocsUrl(subComponent.componentClass));
            });
            form.add(SOUTH, toJavaDocs);
            form.add(CENTER, info);
            form.getToolbar().setBackCommand(title, e -> infoButton.getComponentForm().showBack());
            form.show();
        });
        return infoButton;
    }

    private String getJavaDocsUrl(Class javaClass) {
        String JAVADOC_SOURCE_URL = "https://www.codenameone.com/javadoc/";
        return JAVADOC_SOURCE_URL + javaClass.getCanonicalName().replace(".", "/") + ".html";
    }
}


