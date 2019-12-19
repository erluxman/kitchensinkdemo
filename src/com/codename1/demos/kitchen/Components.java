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

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.TableLayout;

import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.CENTER_BEHAVIOR_CENTER;
import static com.codename1.ui.CN.CENTER_BEHAVIOR_SCALE;
import static com.codename1.ui.CN.EAST;
import static com.codename1.ui.CN.NORTH;
import static com.codename1.ui.CN.SOUTH;
import static com.codename1.ui.CN.TOP;
import static com.codename1.ui.CN.WEST;
import static com.codename1.ui.layouts.BorderLayout.CENTER_BEHAVIOR_TOTAL_BELOW;

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
        for(Component cc : c) {
            cc.setUIID(cc.getUIID());
        }
    }

    public Container createDemo() {

        Label borderLayout = new Label("Border");
        Button borderAbsoluteLayout = new Button("Border - Absolute");
        Button boxYLayout = new Button("Box Y");
        Button boxXLayout = new Button("Box X");
        Button flowLayout = new Button("Flow");
        Button flowCenterLayout = new Button("Flow Center");
        Button gridLayout = new Button("Grid");
        Button tableLayout = new Button("Table");
        Button layeredLayout = new Button("Layered");
        Container selection = BoxLayout.encloseY(flowLayout, flowCenterLayout, borderLayout, borderAbsoluteLayout, boxYLayout, boxXLayout, gridLayout, tableLayout, layeredLayout);
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

