package com.codename1.demos.kitchen.components;

import com.codename1.ui.Component;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;

public class InfiniteContainerDemo extends InfiniteContainer {
    @Override
    public Component[] fetchComponents(int index, int amount) {
        return new Component[0];
    }

    public static InfiniteContainerDemo getInstance() {
        InfiniteContainerDemo container = new InfiniteContainerDemo();
        container.add(new Label("Hello there "));
        container.add(new Label("Namaste"));
        container.add(new Label("Hi everyone"));
        container.add(new Label("let's go party"));
        container.add(new Label("Codenameone"));
        container.add(new Label("Amazing Cross platform"));
        return container;

    }
}
