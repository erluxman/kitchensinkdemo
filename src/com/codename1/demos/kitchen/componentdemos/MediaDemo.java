package com.codename1.demos.kitchen.componentdemos;

import com.codename1.demos.kitchen.Video;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

class MediaDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "media.png";
    }

    @Override
    public String getTitle() {
        return "Media";
    }

    @Override
    Container getContent() {
        return mediaContainer();
    }

    private Container mediaContainer() {
        Form form = new Form(getTitle(), new BorderLayout());
        return new Video().createDemo(form);
    }
}
