package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageButton;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanButton;
import com.codename1.components.ToastBar;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.demos.kitchen.demoforms.FloatingActionButtonDemo;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;

class ButtonsDemo extends DemoComponent {
    private String buttonInfo = "Button is the base class for several UI widgets allowing clickability." +
            "It has 3 states: rollover, pressed and the default state. Button can also have an " +
            "ActionListener that react when the Button is clicked or handle actions via a Command." +
            "Button has the Button UIID by default.";
    private String spanButtonInfo = "A complex button similar to MultiButton that breaks lines automatically and looks like a regular button (more or less). Unlike the multi button the span button has the UIID style of a button.";
    private String multiButtonInfo = "A powerful button like component that allows multiple rows/and an icon to be added every row/icon can have its own UIID. Internally the multi-button is a container with a lead component. Up to 4 rows are supported.";
    private String scaleImageButtonInfo = "Button that simplifies the usage of scale to fill/fit. This is effectively equivalent to just setting the style image on a button but more convenient for some special circumstances. One major difference is that preferred size equals the image in this case.";
    private String fabInfo = "Floating action buttons are a material design element used to promote a special action in a Form. They are represented as a floating circle with a flat icon floating above the UI typically in the bottom right area.";
    private String shareButtonInfo = "The share button allows sharing a String or an image either thru the defined sharing services or thru the native OS sharing support. On Android & iOS the native sharing API is invoked for this class." +
            "The code below demonstrates image sharing, notice that an image must be stored using the FileSystemStorage API and shouldn't use a different API like Storage";

    @Override
    String getImageName() {
        return "buttons.png";
    }

    @Override
    String getTitle() {
        return "Buttons";
    }

    @Override
    Container getContent() {
        return buttonsContainer();
    }

    Container buttonsContainer() {

        MultiButton multiButton1 = new MultiButton("MultiButton");
        multiButton1.setTextLine1("Line one button");
        multiButton1.setTextLine2("Line two button");
        multiButton1.setTextLine3("Line three button");
        multiButton1.setTextLine4("Line four button");

        MultiButton multiButton2 = new MultiButton("MultiButton checkboxes");
        multiButton2.setCheckBox(true);
        multiButton2.setTextLine1("Line 1");
        multiButton2.setTextLine2("Line 2");
        multiButton2.setTextLine3("Line 3");
        multiButton2.setTextLine4("Line 4");

        MultiButton multiButton3 = new MultiButton("MultiButton checkboxes");
        multiButton3.setCheckBox(true);
        multiButton3.setIcon(resources.getImage("dog.jpg"));
        multiButton3.setTextLine1("Line 1");
        multiButton3.setTextLine2("Line 2");
        multiButton3.setTextLine3("Line 3");
        multiButton3.setTextLine4("Line 4");

        Container multiButton = new Container(BoxLayout.y());
        multiButton.add(multiButton1).add(multiButton2).add(multiButton3);

        ComponentDemo demo = new ComponentDemo("Buttons");
        Button simpleButton = new Button("Show toast");
        SpanButton spanButton = new SpanButton("Click SpanButton Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard d ");
        spanButton.addActionListener(evt -> {
            ToastBar.showMessage(spanButton.getText(), FontImage.MATERIAL_INFO);
        });
        simpleButton.addActionListener(evt -> {
            ToastBar.showMessage("Hello from Toastbar", FontImage.MATERIAL_INFO);
        });

        ScaleImageButton imageButton = new ScaleImageButton(resources.getImage("dog.jpg"));
        ListModel<Image> images = new DefaultListModel<Image>(
                resources.getImage("background.jpg"),
                resources.getImage("layout.png"),
                resources.getImage("themes.png"),
                resources.getImage("dog.jpg")
        );

        Button previousButton = new Button("Previous");
        Button nextButton = new Button("Next");
        previousButton.addActionListener(event -> {
            int currentIndex = images.getSelectedIndex();
            int totalSize = images.getSize();
            currentIndex -= 1;
            if (currentIndex < 0) {
                currentIndex = totalSize - 1;
            }
            images.setSelectedIndex(currentIndex);
            Image currentImage = images.getItemAt(images.getSelectedIndex());
            System.out.println("currentIndex" + currentIndex + "Image = " + currentImage);
            imageButton.setIcon(currentImage);
        });

        nextButton.addActionListener(event -> {
            int currentIndex = images.getSelectedIndex();
            currentIndex += 1;
            if (currentIndex >= (images.getSize() - 1)) {
                currentIndex = 0;
            }
            images.setSelectedIndex(currentIndex);
            Image currentImage = images.getItemAt(images.getSelectedIndex());
            System.out.println("currentIndex" + currentIndex + "Image = " + currentImage);
            imageButton.setIcon(currentImage);
        });
        Container buttonLine = new Container(BoxLayout.xCenter())
                .add(previousButton)
                .add(nextButton);


        Container scaleImageContainer = new Container(BoxLayout.y())
                .add(imageButton).add(buttonLine);

        ShareButton shareButton = new ShareButton();
        shareButton.setText("Share the file");
        Button fab = FloatingActionButtonDemo.getInstance(resources);
        demo.add("Button", simpleButton, buttonInfo, Button.class)
                .add("Span Button", spanButton, spanButtonInfo, SpanButton.class)
                .add("Multi Button", multiButton, multiButtonInfo, MultiButton.class)
                .add("Scale Image Button", scaleImageContainer, scaleImageButtonInfo, ScaleImageButton.class)
                .add("Floating Action Button", fab, fabInfo, FloatingActionButton.class)
                .add("Share Button", shareButton, shareButtonInfo, ShareButton.class);
        return demo.generate();
    }

}
