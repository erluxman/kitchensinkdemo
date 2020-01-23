package com.codename1.demos.kitchen.containers;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;


public class TabsContainerDemo {
    public static Button getInstance() {
        Button show = new Button("Show Tabs Page");
        Form form = new Form("Tabs Page", new BorderLayout());

        Tabs tabs = new Tabs();
        tabs.addTab("Home",
               new Container(BoxLayout.yCenter()).add(new Label("Home"))
        );
        tabs.addTab("Profile",
                new Label("Profile")
        );
        tabs.addTab("Setting",
                new Label("Setting")
        );
        tabs.setAnimateTabSelection(true);
        form.add(BorderLayout.CENTER, tabs);
        form.getToolbar().setBackCommand("Line Chart", ee -> show.getComponentForm().showBack());
        show.addActionListener(evt -> {
            form.show();
        });
        return show;
    }
}
