package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.OnOffSwitch;
import com.codename1.components.Switch;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.layouts.BoxLayout;

class TogglesDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "toggles.png";
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
