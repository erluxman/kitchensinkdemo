package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.components.ClearableTextField;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;

class TextfieldDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "textfield.png";
    }

    @Override
    public String getSourceUrl() {
        return "https://stackoverflow.com/questions/14807129/missing-push-notification-entitlement";
    }

    @Override
    public String getTitle() {
        return "TextField";
    }

    @Override
    Container getContent() {
        return textFieldContainer();
    }

    private Container textFieldContainer() {
        ComponentDemo demo = new ComponentDemo(getTitle());
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

}