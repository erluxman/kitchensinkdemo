/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Codename One through http://www.codenameone.com/ if you
 * need additional information or have any questions.
 */
package com.codename1.demos.kitchen;

import com.codename1.components.Accordion;
import com.codename1.components.CheckBoxList;
import com.codename1.components.ClearableTextField;
import com.codename1.components.FileTree;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.InteractionDialog;
import com.codename1.components.MediaPlayer;
import com.codename1.components.MultiButton;
import com.codename1.components.OnOffSwitch;
import com.codename1.components.RSSReader;
import com.codename1.components.RadioButtonList;
import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.components.SignatureComponent;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.SplitPane;
import com.codename1.components.Switch;
import com.codename1.components.SwitchList;
import com.codename1.components.ToastBar;
import com.codename1.demos.kitchen.components.ComponentDemo;
import com.codename1.demos.kitchen.components.InfiniteContainerDemo;
import com.codename1.io.Log;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.CN;
import com.codename1.ui.Calendar;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.CommonProgressAnimations;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.MenuBar;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Sheet;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.Slider;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.list.MultipleSelectionListModel;
import com.codename1.ui.spinner.Picker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.codename1.components.SplitPane.HORIZONTAL_SPLIT;
import static com.codename1.components.SplitPane.VERTICAL_SPLIT;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.callSerially;
import static com.codename1.ui.CN.scheduleBackgroundTask;


/**
 * Demonstrates some of the basic layout types available in Codename One with explanation and a smooth animation
 *
 * @author Shai Almog
 */
public class Components extends Demo {
    //Get it
    public String getDisplayName() {
        return "Components";
    }


    //Get it
    public Image getDemoIcon() {
        return getResources().getImage("components.png");
    }

    //Get it
    @Override
    public String getSourceCodeURL() {
        return "https://github.com/codenameone/KitchenSink/blob/master/src/com/codename1/demos/kitchen/Components.java";
    }

    private void resetMargin(Container c) {
        // Cleaver how the container implements List of Components but compositions won't be that bad either.
        // Coz this is really going to be there for forever.
        for (Component cc : c) {
            cc.setUIID(cc.getUIID());
        }
    }

    public Container createDemo() {

        Container selection = BoxLayout.encloseY(
                labelContainer(),
                buttonsContainer(),
                toggleContainer(),
                toggleListContainer(),
                selectionContainer(),
                textFieldContainer(),
                mediaContainer(),
                mapsContainer(),
                containersContainer(),
                dialogsContainer(),
                progressContainer(),
                advancedContainer(),
                chartsContainer(),
                toolbarContainer()
        );
        selection.setScrollableY(true);

        return selection;
    }

    Container labelContainer() {
        ComponentDemo demo = new ComponentDemo("Labels");
        demo.add("Label", new Label("This is label"))
                .add("Span Label", new SpanLabel("This is Span Label"))
                .add("Scale Image Label", new ScaleImageLabel(getResources().getImage("dog.jpg")))
                .add("Floating Hint", new TextComponent(
                ).label("Input your name"))
        ;
        return demo.generate();
    }

    Container buttonsContainer() {
        MultiButton multiButton = new MultiButton("MultiButton");
        multiButton.setTextLine1("Line one button");
        multiButton.setTextLine2("Line two button");
        multiButton.setTextLine3("Line three button");
        multiButton.setTextLine4("Line four button");

        ShareButton shareButton = new ShareButton();
        shareButton.setText("Share the file");
        ComponentDemo demo = new ComponentDemo("Buttons");
        demo
                .add("Button", new Button("Click this"))
                .add("Span Button", new SpanButton("Click SpanButton"))
                .add("Multi Button", multiButton)
                .add("Scale Image Button",
                        new ScaleImageButton(getResources().getImage("dog.jpg")))
                .add("Floating Action Button", FloatingActionButton.createFAB(FontImage.MATERIAL_ADD))
                .add("Share Button", shareButton);
        return demo.generate();
    }

    Container toggleContainer() {
        ComponentDemo demo = new ComponentDemo("Toggles");
        ButtonGroup genderButtons = new ButtonGroup();
        RadioButton male = new RadioButton("Male");
        male.setGroup("gender");
        RadioButton female = new RadioButton("Female");
        female.setGroup("gender");
        RadioButton others = new RadioButton("Others");
        others.setGroup("gender");
        demo
                .add("CheckBox", new Container(BoxLayout.y())
                        .add(new Label("Select Subjects"))
                        .add(new CheckBox("Maths"))
                        .add(new CheckBox("English"))
                        .add(new CheckBox("Science")))
                .add("Radio Button", new Container(BoxLayout.y())
                        .add(new Label("Select Gender"))
                        .add(male)
                        .add(female)
                        .add(others))
                .add("ON/OFF Switch", new OnOffSwitch())
                .add("Switch", new Switch());
        return demo.generate();
    }

    Container toggleListContainer() {
        ComponentDemo demo = new ComponentDemo("Toggle List");
        demo
                .add("Switch List", new SwitchList(new DefaultListModel<>("GPS", "Notifications")))
                .add("Check Box List", new CheckBoxList(new DefaultListModel<>("Maths", "Science", "English")))
                .add("Radio Button List", new RadioButtonList(new DefaultListModel<>("Male", "Female")));
        return demo.generate();
    }

    Container selectionContainer() {
        ComponentDemo demo = new ComponentDemo("Selection");
        demo
                .add("Combo Box", new Container(BoxLayout.y())
                        .add(new Label("Select your favourite Player"))
                        .add(new ComboBox<String>("Messi", "Ronaldo", "Neymar", "Mbappe")))
                .add("Date Picker", PickerComponent.createDate(null).label("Select Birthday"))
                .add("Time Picker", PickerComponent.createTime(0).label("Select Alarm time"))
                .add("Date Time Picker", PickerComponent.createDateTime(null).label("Select Meeting time"))
                .add("Minute Duration Picker", PickerComponent.createDurationMinutes(0).label("Select Duration"))
                .add("Minute,Hour Duration Picker", PickerComponent.createDurationHoursMinutes(0, 0).label("Select Duration"))
        ;
        return demo.generate();
    }

    Container textFieldContainer() {
        ComponentDemo demo = new ComponentDemo("TextField");
        demo.add("TextField", new TextField())
                .add("TextArea", new TextArea("", 3, 3))
                .add("Clearable TextField", ClearableTextField.wrap(new TextArea()))
                .add("Autocomplete TextField",
                        new AutoCompleteTextField("Paris", "Mumbai", "New York",
                                "Barcelona", "Berlin", "California", "Moscow", "Kathmandu",
                                "Jerusalem", "New Delhi", "Pokhara", "Rome", "Milan", "Seville"))
        ;
        return demo.generate();
    }

    Container mediaContainer() {
        ComponentDemo demo = new ComponentDemo("Media");
        Button playButton = new Button("Play online video");
//        try {
//            Media video = MediaManager.createMedia("http://www.codenameone.com/files/hello-codenameone.mp4", true, () -> demo.generate().getComponentForm().showBack());
//            MediaPlayer player = new MediaPlayer(video);
//            player.showControls();
//            demo. add("Media Player", player);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return demo.generate();
    }

    Container mapsContainer() {
        SpanLabel borderLayout = new SpanLabel("Maps", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container containersContainer() {
        ComponentDemo demo = new ComponentDemo("Containers");
        Accordion accordion = new Accordion();
        //How to add containers rather than just strings into Accordion.
        accordion.addContent("Greetings", new List<String>(
                "Hi", "Hello", "Namste", "gracias"
        ));

        SplitPane splitPane = new SplitPane(
                new SplitPane.Settings(HORIZONTAL_SPLIT, "15%", "50%", "85%"),
                new Label("hello"),
                new SplitPane(
                        new SplitPane.Settings(VERTICAL_SPLIT, "15%", "50%", "85%"),
                        new Label("Hola"),
                        new Label("Hi")));

        Tabs tabs = new Tabs();
        tabs.addTab("Home", new Label("Home"));
        tabs.addTab("Profile", new Label("Profile"));
        tabs.addTab("Setting", new Label("Setting"));
        demo.add("Accordin", accordion);
        demo.add("Infinite Container", InfiniteContainerDemo.getInstance());
        demo.add("Split Pane", splitPane);
        demo.add("Tabs", tabs);
        return demo.generate();
    }

    Container dialogsContainer() {
        ComponentDemo demo = new ComponentDemo("Dialogs / Prompts");
        InteractionDialog interactionDialog = new InteractionDialog();
        interactionDialog.addComponent(new Button("Ok"));
        interactionDialog.addComponent(new Button("Cancel"));
        interactionDialog.setLayout(BoxLayout.y());

        Dialog dialog = new Dialog();
        Button okButton = new Button("Ok");
        okButton.addActionListener(evt -> dialog.dispose());
        dialog.addComponent(okButton);
        Button showDialog = new Button("Show Dialog");
        //Why does it take long to show dialog?
        showDialog.addActionListener(evt -> dialog.show());


        Button openSheetButton = new Button("Open Sheet");
        Sheet sheet = new Sheet(null, "Hello there");
        openSheetButton.addActionListener(evt -> sheet.show());

        Button showToastBar = new Button("Show toastbar");
        showToastBar.addActionListener((event) -> {
            ToastBar.showMessage("Hello from Toastbar", FontImage.MATERIAL_INFO);
        });

        demo.add("Interaction Dialog", interactionDialog);
        demo.add("Dialog", showDialog);
        demo.add("Sheet", openSheetButton);
        demo.add("ToastBar", showToastBar);
        return demo.generate();
    }

    Container progressContainer() {
        ComponentDemo demo = new ComponentDemo("Progress");
        InfiniteProgress infiniteProgress = new InfiniteProgress();

        Slider slider = new Slider();
        slider.setProgress(50);
        slider.setEditable(true);

        demo.add("Infinite Progress", infiniteProgress);
        demo.add("Slider", slider);
        demo.add("Circle Animation", new CommonProgressAnimations.CircleProgress());
        demo.add("Text Loading Animation", new CommonProgressAnimations.LoadingTextAnimation().rows(2).cols(1));

        return demo.generate();
    }

    Container advancedContainer() {
        ComponentDemo demo = new ComponentDemo("Advanced");
//        BrowserComponent browserComponent = new BrowserComponent();
//        browserComponent.setURL("https://www.codenameone.com/");
//        browserComponent.addWebEventListener(BrowserComponent.onMessage, e->{
//            CN.callSerially(()->{
//                Log.p("Message: "+e.getSource());
//                Dialog.show("Here", (String)e.getSource(), "OK", null);
//            });
//        });
//
//        //Browser component flickers in list, we have to find a better way to present it.
//        //demo.add("Browser Component",browserComponent);
//
//        SignatureComponent signatureComponent = new SignatureComponent();
        //demo.add("Signature Component",signatureComponent);

        FileTree fileTree = new FileTree();
        fileTree.setScrollableY(false);
        RSSReader rssReader = new RSSReader();
        rssReader.setURL("https://us12.campaign-archive.com/feed?u=f39692e245b94f7fb693b6d82&id=93b2272cb6");
        ImageViewer imageViewer = new ImageViewer();
        ListModel<Image> images = new DefaultListModel<Image>(
                getResources().getImage("background.jpg"),
                getResources().getImage("layout.png"),
                getResources().getImage("themes.png"),
                getResources().getImage("dog.jpg")
        );
        imageViewer.setImageList(images);
        demo.add("Calendar", new Calendar());
        demo.add("FileTree", fileTree);
        demo.add("Rss Reader", rssReader);
        demo.add("Image Viewer", imageViewer);
        return demo.generate();
    }

    Container chartsContainer() {
        ComponentDemo demo = new ComponentDemo("Charts");
        return demo.generate();
    }

    Container toolbarContainer() {
        ComponentDemo demo = new ComponentDemo("Toolbar");
        Toolbar searchBar = new Toolbar();
        demo.add("Search Bar", searchBar);
        return demo.generate();
    }


    @Override
    public String getDescription() {
        return "Layouts allow the UI of Codename One to adapt to the different resolutions and DPI's supported by "
                + "the various OS's. This is just the tip of the iceberg. Layouts can be nested deeply and there are very "
                + "complex layouts such as MiG, Group, GridBag etc. that aren't fully represented here...";
    }
}