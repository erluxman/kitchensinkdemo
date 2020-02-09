package com.codename1.demos.kitchen.componentdemos;

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

    String labelInfo = "Allows displaying a single line of text and icon (both optional) with different alignment options. This class is a base class for several components allowing them to declare alignment/icon appearance universally.";
    String spanLabelInfo = "A multi line label component that can be easily localized, this is simply based on a text area combined with a label";
    String scaleImageLabelInfo = "Label that simplifies the usage of scale to fill/fit. This is effectively equivalent to just setting the style image on a label but more convenient for some special circumstances. One major difference is that preferred size equals the image in this case." +
            "The default UIID for this component is Label";
    String floatingHintInfo = "TextComponent Encapsulates a text field and label into a single component. This allows the UI to adapt for iOS/Android behavior differences and support features like floating hint when necessary. It also includes platform specific error handling logic." +
            "It is highly recommended to use text components in the context of a TextModeLayout This allows the layout to implicitly adapt to the on-top mode and use a box layout Y mode for iOS and other platforms." +
            "This class supports several theme constants:";
    @Override
    public String getImageName() {
        return "labels.png";
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

        Label label = new Label("This is Label");
        SpanLabel spanLabel = new SpanLabel("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scramble");
        demo.add("Label", label, labelInfo)
                .add("Span Label", spanLabel,spanLabelInfo)
                .add("Scale Image Label", scaleImageContainer, scaleImageLabelInfo,ScaleImageLabel.class)
                .add("Floating Hint", floatingText, floatingHintInfo);
        return demo.generate();
    }

    @Override
    public String getTitle() {
        return "Labels";
    }

}
