package com.codename1.demos.kitchen.componentdemos;

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

        demo.add("Button", simpleButton)
                .add("Span Button", spanButton)
                .add("Multi Button", multiButton)
                .add("Scale Image Button", scaleImageContainer)
                .add("Floating Action Button", FloatingActionButtonDemo.getInstance(resources))
                .add("Share Button", shareButton);
        return demo.generate();
    }

}
