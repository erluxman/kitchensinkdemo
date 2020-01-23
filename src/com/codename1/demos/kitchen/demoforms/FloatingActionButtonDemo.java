package com.codename1.demos.kitchen.demoforms;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ToastBar;
import com.codename1.demos.kitchen.containers.InfiniteContainerDemo;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;


public class FloatingActionButtonDemo {
    public static Button getInstance(Resources resources){
        Button show = new com.codename1.ui.Button("Show Fab");
        Form form = new Form("Fab Page", new BorderLayout());
        final Container fabdemo = InfiniteContainerDemo.getInfiniteContainerContent(resources);
        fabdemo.setScrollableY(true);

        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.addActionListener(e -> {
            ToastBar.showMessage("Added a new Puppy at the bottom of list", FontImage.MATERIAL_INFO);
        });form.add(BorderLayout.CENTER, fab.bindFabToContainer(fabdemo));
        form.getToolbar().setBackCommand("Line Chart", ee -> show.getComponentForm().showBack());
        show.addActionListener(evt -> {
            form.show();
        });
        return show;
    }
}
