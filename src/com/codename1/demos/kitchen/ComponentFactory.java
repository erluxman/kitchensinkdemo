package com.codename1.demos.kitchen;

import com.codename1.components.Accordion;
import com.codename1.components.CheckBoxList;
import com.codename1.components.ClearableTextField;
import com.codename1.components.FileTree;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.InteractionDialog;
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
import com.codename1.ui.List;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Sheet;
import com.codename1.ui.Slider;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.util.Resources;

import static com.codename1.components.SplitPane.HORIZONTAL_SPLIT;
import static com.codename1.components.SplitPane.VERTICAL_SPLIT;
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

class ComponentFactory {
    static Component getCard(String title, Component container) {
        Button button = new Button(title, "CardButton");
        Form form = new Form(title, new BorderLayout());
        form.add(CENTER, BorderLayout.center(container));
        form.getToolbar().setBackCommand(title, evt -> button.getComponentForm().show());
        button.addActionListener(evt -> {
            form.show();
        });
        return button;
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
        showSignature.addActionListener(evt -> {
            Form viewer = new Form("Browser Demo", new BorderLayout());
            viewer.add(CENTER, BorderLayout.center(signatureComponent));
            viewer.getToolbar().setBackCommand("", ee -> showSignature.getComponentForm().showBack());
            viewer.show();
        });

        FileTree fileTree = new FileTree();
        fileTree.setScrollableY(false);
        RSSReader rssReader = new RSSReader();
        rssReader.setURL("https://us12.campaign-archive.com/feed?u=f39692e245b94f7fb693b6d82&id=93b2272cb6");
        ImageViewer imageViewer = new ImageViewer();
        ListModel<Image> images = new DefaultListModel<Image>(
                res.getImage("background.jpg"),
                res.getImage("layout.png"),
                res.getImage("themes.png"),
                res.getImage("dog.jpg")
        );
        imageViewer.setImageList(images);


        demo.add("Browser Component", showBrowserComponent);
        demo.add("SignatureComponent", showSignature);
        demo.add("Calendar", new Calendar());
        demo.add("FileTree", fileTree);
        demo.add("Rss Reader", rssReader);
        demo.add("Image Viewer", imageViewer);
        return demo.generate();
    }

    static Container labelContainer(Resources resources) {
        ComponentDemo demo = new ComponentDemo("Labels");
        demo.add("Label", new Label("This is label"))
                .add("Span Label", new SpanLabel("This is Span Label"))
                .add("Scale Image Label", new ScaleImageLabel(resources.getImage("dog.jpg")))
                .add("Floating Hint", new TextComponent(
                ).label("Input your name"))
        ;
        return demo.generate();
    }

    static Container buttonsContainer(Resources resources) {
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
                        new ScaleImageButton(resources.getImage("dog.jpg")))
                .add("Floating Action Button", FloatingActionButton.createFAB(FontImage.MATERIAL_ADD))
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
        demo
                .add("Switch List", new SwitchList(new DefaultListModel<>("GPS", "Notifications")))
                .add("Check Box List", new CheckBoxList(new DefaultListModel<>("Maths", "Science", "English")))
                .add("Radio Button List", new RadioButtonList(new DefaultListModel<>("Male", "Female")));
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

    static Container mediaContainer() {
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

        //AudioRecorderComponent audioRecorder = new AudioRecorderComponent(new MediaRecorderBuilder());
        //demo.add("Media Recorder",audioRecorder);
        return demo.generate();
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

    static Container containersContainer() {
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

    static Container dialogsContainer() {
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

    static Container toolbarContainer() {
        ComponentDemo demo = new ComponentDemo("Toolbar");
        Toolbar searchBar = new Toolbar();
        demo.add("Search Bar", searchBar);
        return demo.generate();
    }
}
