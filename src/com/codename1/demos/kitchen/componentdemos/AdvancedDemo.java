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
        Button showBrowserComponent = new Button("Show browser");
        showBrowserComponent.addActionListener(evt -> {
            BrowserComponent browserComponent = new BrowserComponent();

            browserComponent.setURL("https://www.codenameone.com/");

            Form viewer = new Form("Browser Demo", new BorderLayout());
            viewer.add(CENTER, BorderLayout.center(browserComponent));
            viewer.getToolbar().setBackCommand("", ee -> showBrowserComponent.getComponentForm().showBack());
            viewer.show();
        });


        Button showSignature = new Button("Sign the Document");
        showSignature.addActionListener(evt -> {
            SignatureComponent signatureComponent = new SignatureComponent();
            Form viewer = new Form("Browser Demo", new BorderLayout());
            viewer.add(CENTER, BorderLayout.center(signatureComponent));
            viewer.getToolbar().setBackCommand("", ee -> showSignature.getComponentForm().showBack());
            viewer.show();
        });

        Button showFiles = new Button("Show Files");
        showFiles.addActionListener(evt -> {
            Form viewer = new Form("Browser Demo", new BorderLayout());
            FileTree fileTree = new FileTree();
            fileTree.setScrollableY(false);
            viewer.add(CENTER, BorderLayout.center(fileTree));
            viewer.getToolbar().setBackCommand("", ee -> showFiles.getComponentForm().showBack());
            viewer.show();
        });


        Button showImageViewer = new Button("Show Image Viewer");
        showImageViewer.addActionListener(evt -> {
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

            Form viewer = new Form("Image Viewer", new BorderLayout());
            ImageViewer imageViewer = new ImageViewer();
            Container imageViewerContainer = new Container(BoxLayout.y())
                    .add(imageViewer).add(buttonLine);
            imageViewer.setImageList(images);
            viewer.add(CENTER, BorderLayout.center(imageViewerContainer));
            viewer.getToolbar().setBackCommand("", ee -> showImageViewer.getComponentForm().showBack());
            viewer.show();
        });

        Button showCalendar = new Button("Show Calendar");
        showCalendar.addActionListener(evt -> {
            Form viewer = new Form("Calendar Viewer", new BorderLayout());
            Container imageViewerContainer = new Container(BoxLayout.y())
                    .add(new Calendar());
            viewer.add(CENTER, BorderLayout.center(imageViewerContainer));
            viewer.getToolbar().setBackCommand("", ee -> showCalendar.getComponentForm().showBack());
            viewer.show();

        });
        demo.add("Browser Component", showBrowserComponent,browserInfo,BrowserComponent.class);
        demo.add("SignatureComponent", showSignature,signatureInfo,SignatureComponent.class);
        demo.add("Calendar", showCalendar,calendarInfo,Calendar.class);
        demo.add("FileTree", showFiles,fileTreeInfo,FileTree.class);
        demo.add("Image Viewer", showImageViewer,imageViewerInfo,ImageViewer.class);
        return demo.generate();
    }

    String browserInfo ="The browser component is an interface to an embeddable native platform browser on platforms that support embedding the native browser in place, if you need wide compatibility and flexibility you should check out the HTMLComponent which provides a lightweight 100% cross platform web component.\n" +
            "This component will only work on platforms that support embedding a native browser which exclude earlier versions of Blackberry devices and J2ME devices.\n" +
            "Its recommended that you place this component in a fixed position (none scrollable) on the screen without other focusable components to prevent confusion between focus authority and allow the component to scroll itself rather than CodenameOne making that decision for it.\n" +
            "\n" +
            "On Android this component might show a native progress indicator dialog. You can disable that functionality using the call.";
    String signatureInfo ="A component to allow a user to enter their signature. This is just a button that, when pressed, will pop up a dialog where the user can draw their signature with their finger. The user is given the option to save/reset/cancel the signature. On save, the signatureImage property will be set with a full-size image of the signature, and the icon on the button will show a thumbnail of the image.";
    String calendarInfo ="Date widget for selecting a date/time value." +
            "To localize strings for month names use the values Calendar.Month using the 3 first characters of the month name in the resource localization e.g. Calendar.Jan, Calendar.Feb etc..." +
            "To localize strings for day names use the values Calendar.Day in the resource localization e.g. \"Calendar.Sunday\", \"Calendar.Monday\" etc..." +
            "\n" +
            "Note that we recommend using the Picker class which is superior when running on the device for most use cases.";
    String fileTreeInfo ="Simple class showing off the filesystem as a tree component";
    String imageViewerInfo ="ImageViewer allows zooming/panning an image and potentially flicking between multiple images within a list of images.";
}
