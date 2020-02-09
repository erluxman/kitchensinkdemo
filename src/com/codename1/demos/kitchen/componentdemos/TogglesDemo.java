package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.OnOffSwitch;
import com.codename1.components.Switch;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.demos.kitchen.containers.SubComponent;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.layouts.BoxLayout;

class TogglesDemo extends DemoComponent {

    private String checkBoxInfo ="CheckBox is a button that can be selected or deselected and displays its state to the user. Check out RadioButton for a more exclusive selection approach. Both components support a toggle button mode using the Button.setToggle(boolean) API.";

    private String radioButtonInfo = "CheckBox is a button that can be selected or deselected and displays its state to the user. Check out RadioButton for a more exclusive selection approach. Both components support a toggle button mode using the Button.setToggle(boolean) API.";

    private  String onOffButtonInfo = "The on/off switch is a checkbox of sort (although it derives container) that represents its state as a switch each of which has a short label associated with it. It has two types: Android and iOS. The types differ in the way that they are rendered. The Android type (the default) is just a button with a label that can be moved/dragged between the two states. The iOS version is more elaborate due to the look of that platform.";
    private  String switchInfo = "The on/off switch is a checkbox of sort (although it derives container) that represents its state as a switch When using the Android native theme, this implementation follows the Material Design Switch guidelines: https://material.io/guidelines/components/selection-controls.html#selection-controls-radio-button\n";
    @Override
    public String getImageName() {
        return "toggles.png";
    }

    @Override
    Container getContent() {
        return toggleContainer();
    }

    private Container toggleContainer() {
        ComponentDemo demo = new ComponentDemo(getTitle());
        Container checkBoxes = new Container(BoxLayout.y())
                .add(new Label("Select Subjects"))
                .add(new CheckBox("Maths"))
                .add(new CheckBox("English"))
                .add(new CheckBox("Science"));

        RadioButton male = new RadioButton("Male");
        male.setGroup("gender");
        RadioButton female = new RadioButton("Female");
        female.setGroup("gender");
        RadioButton others = new RadioButton("Others");
        others.setGroup("gender");

        Container radioButtons = new Container(BoxLayout.y())
                .add(new Label("Select Gender"))
                .add(male)
                .add(female)
                .add(others);


        demo
                .add("CheckBox", checkBoxes, checkBoxInfo,CheckBox.class)
                .add(new SubComponent("Radio Button", radioButtons,radioButtonInfo,RadioButton.class))
                .add("ON/OFF Switch", new OnOffSwitch(),onOffButtonInfo,OnOffSwitch.class)
                .add("Switch", new Switch(),switchInfo,Switch.class);
        return demo.generate();
    }

    @Override
    public String getTitle() {
        return "Toggles";
    }

}
