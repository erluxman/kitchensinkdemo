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

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.demos.kitchen.components.ComponentDemo;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;

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
        return getResources().getImage("layout.png");
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

    public Container createDemo() {

        Container selection = BoxLayout.encloseY(
            labelContainer(),
            buttonsContainer(),
            toggleContainer(),
            toggleListContainer(),
            selectionContainer(),
            textFieldContainer(),
            mediaContainer(),
            mapsContainer(),
            containersContainer(),
            dialogsContainer(),
            progressContainer(),
            advancedContainer(),
            chartsContainer(),
            toolbarContainer()
        );
        selection.setScrollableY(true);

        return selection;
    }

    Container labelContainer() {
        ComponentDemo demo = new ComponentDemo("Labels");
        demo.add("Label", new Label("This is label"))
            .add("Span Label", new SpanLabel("This is Span Label"))
            .add("Scale Image Label", new ScaleImageLabel(getResources().getImage("dog.jpg")))
            .add("Floating Hint", new TextComponent(
            ).label("Input your name"))
        ;
        return demo.generate();
    }

    Container buttonsContainer() {
        MultiButton multiButton = new MultiButton("MultiButton");
        multiButton.setTextLine1("Line one button");
        multiButton.setTextLine2("Line two button");
        multiButton.setTextLine3("Line three button");
        multiButton.setTextLine4("Line four button");

        ShareButton shareButton = new ShareButton();
        shareButton.setText("Share the file");
        ComponentDemo demo = new ComponentDemo("Buttons");
        demo
            .add("Button", new Button("Click this"))
            .add("Span Button", new SpanButton("Click SpanButton"))
            .add("Multi Button", multiButton)
            .add("Scale Image Button",
                new ScaleImageButton(getResources().getImage("dog.jpg")))
            .add("Floating Action Button", FloatingActionButton.createFAB(FontImage.MATERIAL_ADD))
            .add("Share Button", shareButton)
        ;
        return demo.generate();
    }

    Container toggleContainer() {
        SpanLabel borderLayout = new SpanLabel("Toggles", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container toggleListContainer() {
        SpanLabel borderLayout = new SpanLabel("Toggle List", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container selectionContainer() {
        SpanLabel borderLayout = new SpanLabel("Selection", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container textFieldContainer() {
        SpanLabel borderLayout = new SpanLabel("Text Fields", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container mediaContainer() {
        SpanLabel borderLayout = new SpanLabel("Media", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container mapsContainer() {
        SpanLabel borderLayout = new SpanLabel("Maps", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container containersContainer() {
        SpanLabel borderLayout = new SpanLabel("Containers", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container dialogsContainer() {
        SpanLabel borderLayout = new SpanLabel("Dialogs / Prompts", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container progressContainer() {
        SpanLabel borderLayout = new SpanLabel("Progress", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container advancedContainer() {
        SpanLabel borderLayout = new SpanLabel("Advanced", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container chartsContainer() {
        SpanLabel borderLayout = new SpanLabel("Charts", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }

    Container toolbarContainer() {
        SpanLabel borderLayout = new SpanLabel("Toolbar", "subComponent");
        return BoxLayout.encloseY(borderLayout);
    }


    @Override
    public String getDescription() {
        return "Layouts allow the UI of Codename One to adapt to the different resolutions and DPI's supported by "
            + "the various OS's. This is just the tip of the iceberg. Layouts can be nested deeply and there are very "
            + "complex layouts such as MiG, Group, GridBag etc. that aren't fully represented here...";
    }
}