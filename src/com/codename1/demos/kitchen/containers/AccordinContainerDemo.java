package com.codename1.demos.kitchen.containers;

import com.codename1.components.Accordion;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.List;
import com.codename1.ui.layouts.BorderLayout;

public class AccordinContainerDemo {
    public static Button getInstance(){
        Button show = new Button("Show Accordin");
        Form form = new Form("Accordin Page", new BorderLayout());
        Accordion accordion = new Accordion();
        //How to add containers rather than just strings into Accordion.
        accordion.addContent("Greeting Words", new List<String>(
                "Hi", "Hello", "Namste", "gracias"
        ));

        accordion.addContent("Respect Words", new List<String>(
                "Hi", "Hello", "Namste", "gracias"
        ));
        accordion.addContent("Insult Words", new List<String>(
                "ugly", "tiny", "dumb", "Pig headed"
        ));

        accordion.addContent("Places", new List<String>(
                "Nyc", "Washington", "Paris", "Milan"
        ));


        form.add(BorderLayout.CENTER, accordion);
        form.getToolbar().setBackCommand("Line Chart", ee -> show.getComponentForm().showBack());
        show.addActionListener(evt -> {
            form.show();
        });
        return show;
    }
}
