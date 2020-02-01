package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.FileTree;
import com.codename1.components.ImageViewer;
import com.codename1.components.SignatureComponent;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;

import static com.codename1.ui.CN.CENTER;

class AdvancedDemo extends DemoComponent {
    @Override
    String getImageName() {
        return "advanced.png";
    }

    @Override
    String getTitle() {
        return "Advanced";
    }

    @Override
    Container getContent() {
        return advancedContainer();
    }

    private Container advancedContainer() {
        ComponentDemo demo = new ComponentDemo("Advanced");
        BrowserComponent browserComponent = new BrowserComponent();

        browserComponent.setURL("https://www.codenameone.com/");

        Button showBrowserComponent = new Button("Show browser");
        showBrowserComponent.addActionListener(evt -> {
            Form viewer = new Form("Browser Demo", new BorderLayout());
            viewer.add(CENTER, BorderLayout.center(browserComponent));
            viewer.getToolbar().setBackCommand("", ee -> showBrowserComponent.getComponentForm().showBack());
            viewer.show();
        });


        SignatureComponent signatureComponent = new SignatureComponent();
        Button showSignature = new Button("Sign the Document");
        Form viewer = new Form("Browser Demo", new BorderLayout());
        viewer.add(CENTER, BorderLayout.center(signatureComponent));
        viewer.getToolbar().setBackCommand("", ee -> showSignature.getComponentForm().showBack());
        showSignature.addActionListener(evt -> {
            viewer.show();
        });

        FileTree fileTree = new FileTree();
        fileTree.setScrollableY(false);
        ImageViewer imageViewer = new ImageViewer();
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
        Container imageViewerContainer = new Container(BoxLayout.y())
                .add(imageViewer).add(buttonLine);
        previousButton.addActionListener(event -> {
            int currentIndex = images.getSelectedIndex();
            int totalSize = images.getSize();
            currentIndex -= 1;
            if (currentIndex < 0) {
                currentIndex = totalSize - 1;
            }
            images.setSelectedIndex(currentIndex);
        });

        nextButton.addActionListener(event -> {
            int currentIndex = images.getSelectedIndex();
            currentIndex += 1;
            if (currentIndex >= images.getSize()) {
                currentIndex = 0;
            }
            images.setSelectedIndex(currentIndex);
        });
        imageViewer.setImageList(images);

        demo.add("Browser Component", showBrowserComponent);
        demo.add("SignatureComponent", showSignature);
        demo.add("Calendar", new Calendar());
        demo.add("FileTree", fileTree);
        demo.add("Image Viewer", imageViewerContainer);
        return demo.generate();
    }

}
