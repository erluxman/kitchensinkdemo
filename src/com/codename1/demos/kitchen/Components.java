/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Codename One through http://www.codenameone.com/ if you
 * need additional information or have any questions.
 */
package com.codename1.demos.kitchen;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.GridLayout;

import static com.codename1.demos.kitchen.ComponentFactory.advancedContainer;
import static com.codename1.demos.kitchen.ComponentFactory.buttonsContainer;
import static com.codename1.demos.kitchen.ComponentFactory.chartsContainer;
import static com.codename1.demos.kitchen.ComponentFactory.containersContainer;
import static com.codename1.demos.kitchen.ComponentFactory.dialogsContainer;
import static com.codename1.demos.kitchen.ComponentFactory.getCard;
import static com.codename1.demos.kitchen.ComponentFactory.labelContainer;
import static com.codename1.demos.kitchen.ComponentFactory.mapsContainer;
import static com.codename1.demos.kitchen.ComponentFactory.mediaContainer;
import static com.codename1.demos.kitchen.ComponentFactory.progressContainer;
import static com.codename1.demos.kitchen.ComponentFactory.searchBarContainer;
import static com.codename1.demos.kitchen.ComponentFactory.selectionContainer;
import static com.codename1.demos.kitchen.ComponentFactory.textFieldContainer;
import static com.codename1.demos.kitchen.ComponentFactory.toggleContainer;
import static com.codename1.demos.kitchen.ComponentFactory.toggleListContainer;


/**
 * Demonstrates some of the basic layout types available in Codename One with explanation and a smooth animation
 *
 * @author Shai Almog
 */
public class Components extends Demo {
    //Get it
    public String getDisplayName() {
        return "Components";
    }


    //Get it
    public Image getDemoIcon() {
        return getResources().getImage("components.png");
    }

    //Get it
    @Override
    public String getSourceCodeURL() {
        return "https://github.com/codenameone/KitchenSink/blob/master/src/com/codename1/demos/kitchen/Components.java";
    }

    private void resetMargin(Container c) {
        // Cleaver how the container implements List of Components but compositions won't be that bad either.
        // Coz this is really going to be there for forever.
        for (Component cc : c) {
            cc.setUIID(cc.getUIID());
        }
    }

    private Image getImage(String image) {
        return getResources().getImage(image);
    }

    public Container createDemo() {
        GridLayout g = new GridLayout(2);
        g.setAutoFit(true);

        Container selection = Container.encloseIn(g,
                getCard("Charts", chartsContainer(), getImage("charts.png")),
                getCard("Advanced", advancedContainer(getResources()), getImage("advanced.png")),
                getCard("Maps", mapsContainer(), getImage("maps.png")),
                getCard("Labels", labelContainer(getResources()), getImage("text.png")),
                getCard("Buttons", buttonsContainer(getResources()), getImage("buttons.png")),
                getCard("Toggles", toggleContainer(), getImage("toggles.png")),
                getCard("Toggle List", toggleListContainer(), getImage("toggleList.png")),
                getCard("Selection", selectionContainer(), getImage("selection.png")),
                getCard("TextField", textFieldContainer(), getImage("textfield.png")),
                getCard("Containers", containersContainer(getResources()), getImage("containers.png")),
                getCard("Dialog", dialogsContainer(getResources()), getImage("dialog.png")),
                getCard("Progress", progressContainer(), getImage("progress.png")),
                 searchBarContainer("Toolbar",getImage("toolbar.png")),
                getCard("Media", mediaContainer(), getImage("media.png"))
        );
        selection.setScrollableY(true);
        return selection;
    }

    @Override
    public String getDescription() {
        return "Layouts allow the UI of Codename One to adapt to the different resolutions and DPI's supported by "
                + "the various OS's. This is just the tip of the iceberg. Layouts can be nested deeply and there are very "
                + "complex layouts such as MiG, Group, GridBag etc. that aren't fully represented here...";
    }
}