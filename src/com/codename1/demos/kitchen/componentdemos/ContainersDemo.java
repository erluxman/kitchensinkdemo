package com.codename1.demos.kitchen.componentdemos;

import com.codename1.demos.kitchen.containers.AccordinContainerDemo;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.demos.kitchen.containers.InfiniteContainerDemo;
import com.codename1.demos.kitchen.containers.SplitPaneContainer;
import com.codename1.demos.kitchen.containers.TabsContainerDemo;
import com.codename1.ui.Container;

class ContainersDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "containers.png";
    }

    @Override
    public String getTitle() {
        return "Containers";
    }

    @Override
    Container getContent() {
        return containersContainer();
    }

    private Container containersContainer() {
        ComponentDemo demo = new ComponentDemo(getTitle());
        demo.add("Accordin", AccordinContainerDemo.getInstance());
        demo.add("Infinite Container", InfiniteContainerDemo.getInstance(resources));
        demo.add("Split Pane", SplitPaneContainer.getInstance());
        demo.add("Tabs", TabsContainerDemo.getInstance());
        return demo.generate();
    }

}
