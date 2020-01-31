package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.components.ScaleImageButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.SOUTH;
import static com.codename1.ui.CN.execute;


abstract class DemoComponent {

    Resources resources;

    public void init(Resources resources) {
        this.resources = resources;
    }

    abstract String getImageName();

    abstract String getSourceUrl();

    abstract String getTitle();

    abstract String getDescription();

    abstract Container getContent();


    public Container getMenuItem() {
        Container buttonCard = getGridCard(getTitle(), resources.getImage(getImageName()));
        Form form = getForm(getTitle(), getContent(), buttonCard);
        connectCardWithForm(buttonCard, form);
        return buttonCard;
    }

    private void connectCardWithForm(Container gridButton, Form form) {
        Button imageButton = new Button();
        imageButton.setWidth(10);
        imageButton.addActionListener(evt -> form.show());
        gridButton.setLeadComponent(imageButton);
    }

    private Form getForm(String title, Component content, Container menuCard) {
        Form form = new Form(title, new BorderLayout());
        form.add(CENTER, BorderLayout.center(content));
        form.getToolbar().setBackCommand(title, evt -> menuCard.getComponentForm().showBack());
        form.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_INFO, 4, ee -> {
            execute(getSourceUrl());
        });
        return form;
    }

    private Container getGridCard(String title, Image image) {
        Container buttonCard = new Container(BoxLayout.y());
        buttonCard.setUIID("gridcard");
        ScaleImageButton scaleImageButton = new ScaleImageButton(image);
        scaleImageButton.setPreferredSize(new Dimension(200, 200));
        buttonCard.add(scaleImageButton);
        Label titleLabel = new Label(title);
        buttonCard.add(new Container(BoxLayout.xCenter()).add(titleLabel));
        return buttonCard;
    }
}
