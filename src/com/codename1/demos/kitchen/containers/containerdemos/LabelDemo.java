package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;

class LabelDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "labels.png";
    }

    @Override
    public String getTitle() {
        return "Labels";
    }

    @Override
    Container getContent() {
        return labelContainer();
    }

    private Container labelContainer() {
        ComponentDemo demo = new ComponentDemo(getTitle());

        ScaleImageLabel imageLabel = new ScaleImageLabel(resources.getImage("dog.jpg"));
        ListModel<Image> images = new DefaultListModel<Image>(
                resources.getImage("background.jpg"),
                resources.getImage("layout.png"),
                resources.getImage("themes.png"),
                resources.getImage("dog.jpg")
        );
        Button previousButton = new Button("Previous");
        Button nextButton = new Button("Next");
        Container buttonLine = new Container(BoxLayout.xCenter())
                .add(previousButton)
                .add(nextButton);
        Container scaleImageContainer = new Container(BoxLayout.y())
                .add(imageLabel).add(buttonLine);
        previousButton.addActionListener(event -> {
            int currentIndex = images.getSelectedIndex();
            int totalSize = images.getSize();
            currentIndex -= 1;
            if (currentIndex < 0) {
                currentIndex = totalSize - 1;
            }
            images.setSelectedIndex(currentIndex);
            imageLabel.setIcon(images.getItemAt(images.getSelectedIndex()));
        });

        nextButton.addActionListener(event -> {
            int currentIndex = images.getSelectedIndex();
            currentIndex += 1;
            if (currentIndex >= (images.getSize() - 1)) {
                currentIndex = 0;
            }
            images.setSelectedIndex(currentIndex);
            imageLabel.setIcon(images.getItemAt(images.getSelectedIndex()));
        });

        TextComponent floatingText = new TextComponent();
        floatingText.labelAndHint("Full name");
        demo.add("Label", new Label("This is label"))
                .add("Span Label", new SpanLabel("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scramble"))
                .add("Scale Image Label", scaleImageContainer)
                .add("Floating Hint", floatingText)
        ;
        return demo.generate();
    }

}
