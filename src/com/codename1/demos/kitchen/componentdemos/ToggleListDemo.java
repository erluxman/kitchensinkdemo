package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.CheckBoxList;
import com.codename1.components.RadioButtonList;
import com.codename1.components.SwitchList;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;

class ToggleListDemo extends DemoComponent {

    private String switchListInfo = "A list of switches.";
    private String checkBoxListInfo = "A list of Check Boxes.";
    private String radioButtonListInfo = "A list of Radio Buttons.";

    @Override
    public String getImageName() {
        return "togglelist.png";
    }

    @Override
    Container getContent() {
        return toggleListContainer();
    }

    private Container toggleListContainer() {
        ComponentDemo demo = new ComponentDemo(getTitle());
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
                .add("Switch List(Flow)", switchListContainer, switchListInfo, SwitchList.class)
                .add("Check Box List(Flow)", checkBoxListContainer, checkBoxListInfo, CheckBoxList.class)
                .add("RadioButton List(Layout Y)", radioButtonListContainer, radioButtonListInfo, RadioButtonList.class);
        return demo.generate();
    }

    @Override
    public String getTitle() {
        return "Toggle List";
    }
}
