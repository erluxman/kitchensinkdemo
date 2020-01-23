package com.codename1.demos.kitchen.containers;

import com.codename1.components.SplitPane;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.components.SplitPane.HORIZONTAL_SPLIT;
import static com.codename1.components.SplitPane.VERTICAL_SPLIT;

public class SplitPaneContainer {
    public  static  Button getInstance(){
        Button showButton = new Button("SplitPane");
        Form form = new Form("SplitPane", new BorderLayout());

        SplitPane splitPane = new SplitPane(
                new SplitPane.Settings(HORIZONTAL_SPLIT, "15%", "50%", "85%"),
                new Label("hello"),
                new SplitPane(
                        new SplitPane.Settings(VERTICAL_SPLIT, "15%", "50%", "85%"),
                        new Label("Hola"),
                        new Label("Hi")));
        form.add(BorderLayout.CENTER,splitPane);
        form.getToolbar().setBackCommand("Line Chart", ee -> showButton.getComponentForm().showBack());
        showButton.addActionListener(evt -> {
            form.show();
        });
        return showButton;
    }
}
