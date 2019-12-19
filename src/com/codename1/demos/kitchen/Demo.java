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

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.util.Resources;

/**
 * The demo class is the base class for all the demos in the application
 *
 * @author Shai Almog
 */
public abstract class Demo {
    private Resources res;
    public void init(Resources res) {
        this.res = res;
    }
    
    protected Resources getResources() {
        return res;
    }

    //Returns title name
    public abstract String getDisplayName();

    // Gives us the image to be displayed in
    public abstract Image getDemoIcon();

    // The Content of the details screen without navigation stuffs
    public Container createDemo() {
        throw new RuntimeException("Must override createDemo");
    }

    // It shows details of the screen in info button
    public String getDescription() {
        return "";
    }

    // This is merely a resource url to that file if it exists
    public String getSourceCodeURL() {
        return "https://www.codenameone.com/";
    }

    // I am not sure what two creatDemo methods need to be here even if one is calling another
    // Will find it out
    // If a container needs Parent form to be made it uses this class else another
    // But it's a clever implementation how the Exception is returned in another method

    public Container createDemo(Form parentForm) {
        return createDemo();
    }

    // This callback will handle anything on back pressed.
    boolean onBack() {
        return true;
    }
}
