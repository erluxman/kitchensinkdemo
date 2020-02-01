package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;

class ToolbarDemo extends DemoComponent {

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
                        .add(new ComboBox<String>("Messi", "Ronaldo", "Neymar", "Mbappe")))
                .add("Date Picker", PickerComponent.createDate(null).label("Select Birthday"))
                .add("Time Picker", PickerComponent.createTime(0).label("Select Alarm time"))
                .add("Date Time Picker", PickerComponent.createDateTime(null).label("Select Meeting time"))
                .add("Minute Duration Picker", PickerComponent.createDurationMinutes(0).label("Select Duration"))
                .add("Minute,Hour Duration Picker", PickerComponent.createDurationHoursMinutes(0, 0).label("Select Duration"))
        ;
        return demo.generate();
    }

}
