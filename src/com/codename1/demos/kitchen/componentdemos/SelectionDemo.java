package com.codename1.demos.kitchen.componentdemos;

import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.layouts.BoxLayout;

class SelectionDemo extends DemoComponent {

    private String comboBoxInfo = "ComboBox is a list that allows only one selection at a time, when a user clicks" +
            " * the code ComboBox a popup button with the full list of elements allows the selection of" +
            " * a single element. The ComboBox is driven by the list model and allows all the renderer" +
            " * features of the List as well. ";
    private String datePickerInfo ="Date Picker is a PickerComponent use PickerComponent.createDate(null).label(\"Select Birthday\")";
    private String timePickerInfo ="Time Picker is a PickerComponent use PickerComponent.createTime(null).label(\"Select Alarm time\")";
    private String dateTimePickerInfo ="DateTime Picker is a PickerComponent use PickerComponent.createDateTime(null).label(\"Select Meeting schedule\")";
    private String durationMinutePickerInfo ="Minute Picker is a PickerComponent use PickerComponent.createDurationMinutes(0).label(\"Select Duration\")";
    private String durationMinuteHoursPickerInfo ="Hour Minute Picker is a PickerComponent use PickerComponent.createDurationHoursMinutes(0, 0).label(\"Select Duration\")";


    @Override
    public String getImageName() {
        return "selection.png";
    }

    @Override
    public String getTitle() {
        return "Selection";
    }

    @Override
    Container getContent() {
        return selectionContainer();
    }

    private Container selectionContainer() {
        ComponentDemo demo = new ComponentDemo(getTitle());
        demo
                .add("Combo Box", new Container(BoxLayout.y())
                        .add(new Label("Select your favourite Player"))
                        .add(new ComboBox<String>("Messi", "Ronaldo", "Neymar", "Mbappe")), comboBoxInfo, ComboBox.class)
                .add("Date Picker", PickerComponent.createDate(null).label("Select Birthday"),datePickerInfo)
                .add("Time Picker", PickerComponent.createTime(0).label("Select Alarm time"),timePickerInfo)
                .add("Date Time Picker", PickerComponent.createDateTime(null).label("Select Meeting time"),dateTimePickerInfo)
                .add("Minute Duration Picker", PickerComponent.createDurationMinutes(0).label("Select Duration"),durationMinutePickerInfo)
                .add("Minute,Hour Duration Picker", PickerComponent.createDurationHoursMinutes(0, 0).label("Select Duration"),durationMinuteHoursPickerInfo)
        ;
        return demo.generate();
    }

}
