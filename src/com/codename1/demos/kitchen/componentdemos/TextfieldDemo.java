package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.ClearableTextField;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Container;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;

class TextfieldDemo extends DemoComponent {

    String textFieldInfo = "A specialized version of TextArea with some minor deviations from " +
            "the original specifically: Blinking cursor is rendered on TextField only\n" +
            "com.codename1.ui.events.DataChangeListener is only available in TextField. This is " +
            "crucial for character by character input event tracking\n" +
            "setDoneListener(com.codename1.ui.events.ActionListener) is only available in TextField\n" +
            "Different UIID's (\"TextField\" vs. \"TextArea\")";

    String textAreaInfo="An optionally multi-line editable region that can display text and allow " +
            "a user to edit it. By default the text area will grow based on its content.\n" +
            "TextArea is useful both for text input and for displaying multi-line data, it is " +
            "used internally by components such as SpanLabel & SpanButton.\n" +
            "\n" +
            "TextArea & TextField are very similar, we discuss the main differences between the two here. " +
            "In fact they are so similar that our sample code below was written for TextField but " +
            "should be interchangeable with TextArea.\n" +
            "\n";

    String clearableTextField = "Wraps a text field so it will have an X to clear its content on the right hand side";

    String autoCompleteTextField = "An editable TextField with completion suggestions that show up in a drop down menu while the user types in text.\n" +
            "This class uses the \"TextField\" UIID by default as well as \"AutoCompletePopup\" & \"AutoCompleteList\" for the popup list details.\n" +
            "The sample below shows the more trivial use case for this widget:" ;



    @Override
    public String getImageName() {
        return "textfield.png";
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
        demo.add("TextField", new TextField(),textFieldInfo)
                .add("TextArea", new TextArea("", 3, 3),textAreaInfo)
                .add("Clearable TextField", ClearableTextField.wrap(new TextArea()),clearableTextField)
                .add("Autocomplete TextField",
                        new AutoCompleteTextField("Paris", "Mumbai", "New York",
                                "Barcelona", "Berlin", "California", "Moscow", "Kathmandu",
                                "Jerusalem", "New Delhi", "Pokhara", "Rome", "Milan", "Seville"),autoCompleteTextField)
        ;
        return demo.generate();
    }

}
