package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

class LabelDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "toggles.png";
    }

    @Override
    public String getSourceUrl() {
        return "https://stackoverflow.com/questions/14807129/missing-push-notification-entitlement";
    }

    @Override
    public String getTitle() {
        return "Toggle List";
    }

    @Override
    String getDescription() {
        return "Label is text";
    }

    @Override
    Container getContent() {
        return new Container(BoxLayout.y()).add(new Label("Hello world"));
    }
}
