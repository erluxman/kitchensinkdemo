package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.ScaleImageButton;
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
import static com.codename1.ui.CN.execute;

abstract class DemoComponent {

    Resources resources;

    public void init(Resources resources) {
        this.resources = resources;
    }

    public Container getMenuItem() {
        Container buttonCard = getGridCard(getTitle(), resources.getImage(getImageName()));
        connectCardWithForm(buttonCard);
        return buttonCard;
    }

    protected Container getGridCard(String title, Image image) {
        Container buttonCard = new Container(BoxLayout.y());
        buttonCard.setUIID("gridcard");
        ScaleImageButton scaleImageButton = new ScaleImageButton(image);
        scaleImageButton.setPreferredSize(new Dimension(200, 200));
        buttonCard.add(scaleImageButton);
        Label titleLabel = new Label(title);
        buttonCard.add(new Container(BoxLayout.xCenter()).add(titleLabel));
        return buttonCard;
    }

    abstract String getTitle();

    abstract String getImageName();

    private void connectCardWithForm(Container gridButton) {
        Button imageButton = new Button();
        imageButton.setWidth(10);
        imageButton.addActionListener(evt -> {
            Form form = getForm(getTitle(), getContent(), gridButton);
            form.show();
        });
        gridButton.setLeadComponent(imageButton);
    }

    private Form getForm(String title, Component content, Container menuCard) {
        Form form = new Form(title, new BorderLayout());
        form.add(CENTER, BorderLayout.center(content));
        form.getToolbar().setBackCommand(title, evt -> menuCard.getComponentForm().showBack());
        form.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_CODE, 4, ee -> {
            execute(getSourceUrl());
        });
        return form;
    }

    abstract Container getContent();

    String getSourceUrl() {
        String BASE_SOURCE_URL = "https://github.com/erluxman/kitchensinkdemo/blob/master/src/";
        return BASE_SOURCE_URL + this.getClass().getCanonicalName().replace(".", "/") + ".java";
    }
}
