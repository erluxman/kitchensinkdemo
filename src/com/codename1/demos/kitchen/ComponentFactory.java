package com.codename1.demos.kitchen;

import com.codename1.components.CheckBoxList;
import com.codename1.components.ClearableTextField;
import com.codename1.components.FileTree;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.InteractionDialog;
import com.codename1.components.MultiButton;
import com.codename1.components.OnOffSwitch;
import com.codename1.components.RadioButtonList;
import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.components.SignatureComponent;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.Switch;
import com.codename1.components.SwitchList;
import com.codename1.components.ToastBar;
import com.codename1.demos.kitchen.containers.AccordinContainerDemo;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.demos.kitchen.containers.InfiniteContainerDemo;
import com.codename1.demos.kitchen.containers.SplitPaneContainer;
import com.codename1.demos.kitchen.containers.TabsContainerDemo;
import com.codename1.demos.kitchen.demoforms.FloatingActionButtonDemo;
import com.codename1.demos.kitchen.map.GoogleMapDemo;
import com.codename1.maps.MapComponent;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
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
import com.codename1.ui.Label;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Sheet;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.util.Resources;

import static com.codename1.demos.kitchen.charts.ChartDemosList.getBarChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getBubbleChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getCombinedXYChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getCubicLineChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getDialChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getDonutChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getLineChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getPieChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getRadarChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getRoundChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getScatterChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getTimeChartButton;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.NORTH;
import static com.codename1.ui.CN.SOUTH;

class ComponentFactory {

    static Component getCard(String title, Component detailsContent, Image image) {
        Container buttonCard = getGridCard(title, image);
        Form form = getForm(title, detailsContent, buttonCard);

        Button imageButton = new Button();
        imageButton.setWidth(10);
        imageButton.addActionListener(evt -> form.show());
        buttonCard.setLeadComponent(imageButton);
        return buttonCard;
    }

    private static Form getForm(String title, Component content, Container menuCard) {
        Form form = new Form(title, new BorderLayout());
        form.add(CENTER, BorderLayout.center(content));
        form.getToolbar().setBackCommand(title, evt -> menuCard.getComponentForm().showBack());
        return form;
    }

    private static Container getGridCard(String title, Image image) {
        Container buttonCard = new Container(BoxLayout.y());
        buttonCard.setUIID("gridcard");
        ScaleImageButton scaleImageButton = new ScaleImageButton(image);
        scaleImageButton.setPreferredSize(new Dimension(200, 200));
        buttonCard.add(scaleImageButton);
        Label titleLabel = new Label(title);
        buttonCard.add(new Container(BoxLayout.xCenter()).add(titleLabel));
        return buttonCard;
    }

    static Component chartsContainer() {
        ComponentDemo demo = new ComponentDemo("Charts");
        demo.add("Bar Chart", getBarChartButton());
        demo.add("Bubble Chart", getBubbleChartButton());
        demo.add("CombinedXY Chart", getCombinedXYChartButton());
        demo.add("CubicLine Chart", getCubicLineChartButton());
        demo.add("Dial Chart", getDialChartButton());
        demo.add("Donut Chart", getDonutChartButton());
        demo.add("Line Chart", getLineChartButton());
        demo.add("Pie Chart", getPieChartButton());
        demo.add("Radar Chart", getRadarChartButton());
        demo.add("Round Chart", getRoundChartButton());
        demo.add("Scatter Chart", getScatterChartButton());
        demo.add("Time Chart", getTimeChartButton());
        return demo.generate();
    }

    static Component advancedContainer(Resources res) {
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
                res.getImage("background.jpg"),
                res.getImage("layout.png"),
                res.getImage("themes.png"),
                res.getImage("dog.jpg")
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

    static Container labelContainer(Resources resources) {
        ComponentDemo demo = new ComponentDemo("Labels");

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

    static Container buttonsContainer(Resources resources) {

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

    static Container toggleContainer() {
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

    static Container toggleListContainer() {
        ComponentDemo demo = new ComponentDemo("Toggle List");
        Container switchListContainer = new Container(new FlowLayout());
        SwitchList switchList = new SwitchList(new DefaultListModel<>("GPS", "Net", "Storage", "App usage", "Display over app"));
        switchListContainer.add(switchList);


        Container checkBoxListContainer = new Container(new FlowLayout());
        CheckBoxList checkBoxList = new CheckBoxList(
                new DefaultListModel<>("Maths", "Science", "English", "Social", "Drawing", "English"));
        checkBoxListContainer.add(checkBoxList);

        Container radioButtonListContainer = new Container(new FlowLayout());
        RadioButtonList radioButtonList = new RadioButtonList(
                new DefaultListModel<>("Male", "Female", "alien", "robot", "Others", "Do not want to disclose"));

        //This is use vertical list instead of flow layout for the toggle list.
        radioButtonList.setLayout(BoxLayout.y());
        radioButtonListContainer.add(radioButtonList);

        demo
                .add("Switch List(Flow)", switchListContainer)
                .add("Check Box List(Flow)", checkBoxListContainer)
                .add("RadioButton List(Layout Y)", radioButtonListContainer);
        return demo.generate();
    }

    static Container selectionContainer() {
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

    static Container textFieldContainer() {
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

    static Component mediaContainer() {
        Form form = new Form("Media", new BorderLayout());
        return new Video().createDemo(form);
    }

    static Container mapsContainer() {
        ComponentDemo demo = new ComponentDemo("Maps");
        MapComponent mapComponent = new MapComponent();
        Button showMapComponent = new Button("Show map component");

        Form viewer = new Form("MapComponent Demo", new BorderLayout());
        viewer.add(CENTER, BorderLayout.center(mapComponent));
        viewer.getToolbar().setBackCommand("", ee -> showMapComponent.getComponentForm().showBack());
        showMapComponent.addActionListener(evt -> {
            viewer.show();
        });

        //Is google map that hard to implement ( as in github repo)?
        demo.add("MapComponent", showMapComponent);
        demo.add("GoogleMap", GoogleMapDemo.getGoogleMapButton());
        return demo.generate();
    }

    static Container containersContainer(Resources resources) {
        ComponentDemo demo = new ComponentDemo("Containers");
        demo.add("Accordin", AccordinContainerDemo.getInstance());
        demo.add("Infinite Container", InfiniteContainerDemo.getInstance(resources));
        demo.add("Split Pane", SplitPaneContainer.getInstance());
        demo.add("Tabs", TabsContainerDemo.getInstance());
        return demo.generate();
    }

    static Container dialogsContainer(Resources resources) {
        ComponentDemo demo = new ComponentDemo("Dialogs / Prompts");
        InteractionDialog interactionDialog = new InteractionDialog();

        Button openInteractionDialog = new Button("Deliver Shipping");
        Button confirmDelivery = new Button("Receive");
        Button wrongPackage = new Button("Reject");
        Button ignore = new Button();
        ignore.setWidth(100);
        FontImage.setMaterialIcon(ignore, FontImage.MATERIAL_CLOSE, 8);

        confirmDelivery.addActionListener(evt -> {
            openInteractionDialog.setText("Successfully delivered");
            interactionDialog.dispose();
        });
        wrongPackage.addActionListener(evt -> {
            openInteractionDialog.setText("Wrong Puppy");
            interactionDialog.dispose();
        });
        ignore.addActionListener(evt -> {
            interactionDialog.dispose();
        });

        Container interactionContent = new Container(new BorderLayout());
        interactionContent.add(NORTH, new Container(BoxLayout.xRight()).add(ignore));
        interactionContent.add(CENTER, new Container(BoxLayout.xCenter()).add(resources.getImage("dog.jpg")));
        Container buttonRow = new Container(GridLayout.autoFit());
        buttonRow.add(confirmDelivery).add(wrongPackage);
        interactionContent.add(SOUTH, buttonRow);


        //Container interactionContent = new Container(BoxLayout.yCenter());
        //interactionContent.add(new Container(BoxLayout.xRight()).add(ignore));
        //interactionContent.add();
        //interactionContent.addComponent(confirmDelivery);
        //interactionContent.addComponent(wrongPackage);
        interactionDialog.addComponent(interactionContent);
        interactionDialog.setLayout(new LayeredLayout());
        openInteractionDialog.addActionListener(evt -> interactionDialog.show(200, 200, 100, 100));


        Dialog dialog = new Dialog();
        Container dialogContent = new Container(BoxLayout.yCenter());
        Button openDialog = new Button("Deliver Shipping");
        Button confirmDialog = new Button("Confirm");
        Button closeDialog = new Button("Close");
        confirmDialog.addActionListener(evt -> dialog.dispose());
        closeDialog.addActionListener(evt -> dialog.dispose());
        dialogContent.add(new Container(BoxLayout.xCenter()).add(resources.getImage("dog.jpg")));
        dialogContent.addComponent(new Container(BoxLayout.xCenter()).add(confirmDialog).add(closeDialog));
        dialog.setLayout(new LayeredLayout());
        dialog.addComponent(dialogContent);
        openDialog.addActionListener(evt -> dialog.show());


        Button openSheetButton = new Button("Open Sheet");
        Sheet sheet = new Sheet(null, "         Welcome to the Sheet       ");
        sheet.setWidth(500);
        sheet.setWidth(500);
        Container sheetContents = new Container(BoxLayout.y());

        Button openInLeft = new Button("Open In left");
        openInLeft.addActionListener(evt -> {
            sheet.setPosition(BorderLayout.EAST);
            sheet.show();
        });
        Button openInRight = new Button("Open In Right");
        openInRight.addActionListener(evt -> {
            sheet.setPosition(BorderLayout.WEST);
            sheet.show();
        });

        Button openInTop = new Button("Open In Top");
        openInTop.addActionListener(evt -> {
            sheet.setPosition(BorderLayout.NORTH);
            sheet.show();
        });
        Button openInBottom = new Button("Open In Bottom");
        openInBottom.addActionListener(evt -> {
            sheet.setPosition(BorderLayout.SOUTH);
            sheet.show();
        });

        Button openDetailsSheet = new Button("Open Details");
        SpanLabel detailsText = new SpanLabel("This is best puppy in the world, \nbuy it for million dollars only");
        Sheet detailSheet = new Sheet(sheet, "Sheet Child as Details");
        Container detailsSheetContent = new Container(BoxLayout.y());
        detailsSheetContent.add(resources.getImage("dog.jpg"));
        detailsSheetContent.add(detailsText);
        detailSheet.add(CENTER, detailsSheetContent);

        openDetailsSheet.addActionListener(evt -> {
            detailSheet.show();
        });

        sheetContents.add(openInLeft).add(openInRight).add(openInTop).add(openInBottom).add(openDetailsSheet);

        sheet.add(CENTER, sheetContents);
        sheet.setPosition(BorderLayout.SOUTH);
        openSheetButton.addActionListener(evt -> sheet.show());


        Button showToastBar = new Button("Show toastbar");
        showToastBar.addActionListener((event) -> {
            ToastBar.showMessage("Hello from Toastbar", FontImage.MATERIAL_INFO);
        });

        demo.add("Interaction Dialog", openInteractionDialog);
        demo.add("Dialog", openDialog);
        demo.add("Sheet", openSheetButton);
        demo.add("ToastBar", showToastBar);
        return demo.generate();
    }

    static Container progressContainer() {
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

    private  static Form getToolbarForm(String title,Container buttonCard){
        Form searchScreen = new Form(title);
        Button imageButton = new Button();
        //Button showToolbarScreen = new Button("Show toolbar", "CardButton");
        Button showSearchBar = new Button("Show searchbar");
        Button goBack = new Button("Go back");
        Toolbar searchBar = new Toolbar();
        searchScreen.setToolbar(searchBar);
        Button homeButton = new Button("Home");
        FontImage.setMaterialIcon(homeButton, FontImage.MATERIAL_HOME);
        searchBar.addComponentToSideMenu(homeButton);
        Button profileButton = new Button("Profile");
        FontImage.setMaterialIcon(profileButton, FontImage.MATERIAL_SUPERVISED_USER_CIRCLE);
        searchBar.addComponentToSideMenu(profileButton);
        Button settingButton = new Button("Setting");
        FontImage.setMaterialIcon(settingButton, FontImage.MATERIAL_SETTINGS);
        searchBar.addComponentToSideMenu(settingButton);
        Button logoutButton = new Button("Logout");
        FontImage.setMaterialIcon(logoutButton, FontImage.MATERIAL_LOGOUT);
        searchBar.addComponentToSideMenu(logoutButton);
        searchBar.setRightSideMenuCmdsAlignedToLeft(true);
        Label searchResult = new Label();

        showSearchBar.addActionListener(e -> {
            searchBar.showSearchBar(evt -> {
                String searchValue = (String) evt.getSource();
                searchResult.setText(searchValue);
            });
        });

        imageButton.setWidth(10);
        imageButton.addActionListener(evt -> searchScreen.show());
        buttonCard.setLeadComponent(imageButton);

        goBack.addActionListener(evt -> buttonCard.getComponentForm().showBack());
        Container buttons = new Container(BoxLayout.y());
        buttons.add(searchResult);
        buttons.add(showSearchBar);
        buttons.add(goBack);
        searchScreen.add(buttons);
        return searchScreen;
    }
    static Container searchBarContainer(String title,Image image) {

        Container buttonCard = getGridCard(title, image);
        Form form = getToolbarForm(title, buttonCard);

        Button imageButton = new Button();
        imageButton.setWidth(10);
        imageButton.addActionListener(evt -> form.show());
        buttonCard.setLeadComponent(imageButton);
        return buttonCard;
    }
}
