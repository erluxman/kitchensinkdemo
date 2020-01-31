package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.components.OnOffSwitch;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.Switch;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;

class TogglesDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "toggles.png";
    }

    @Override
    public String getSourceUrl() {
        return "https://stackoverflow.com/questions/14807129/missing-push-notification-entitlement";
    }

    @Override
    public String getTitle() {
        return "Toggles";
    }

    @Override
    Container getContent() {
        return toggleContainer();
    }

    private Container toggleContainer() {
        ComponentDemo demo = new ComponentDemo(getTitle());
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

}
