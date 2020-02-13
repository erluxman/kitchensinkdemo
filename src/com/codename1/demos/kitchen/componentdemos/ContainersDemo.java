package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.Accordion;
import com.codename1.components.SplitPane;
import com.codename1.demos.kitchen.containers.AccordinContainerDemo;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.demos.kitchen.containers.InfiniteContainerDemo;
import com.codename1.demos.kitchen.containers.SplitPaneContainer;
import com.codename1.demos.kitchen.containers.TabsContainerDemo;
import com.codename1.ui.Container;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Tabs;

class ContainersDemo extends DemoComponent {

    String accordinInfo = "The Accordion ui pattern is a vertically stacked list of items. Each item can be opened/closed to reveal more content similarly to a Tree however unlike the Tree the Accordion is designed to include containers or arbitrary components rather than model based data.\n" +
            "\n" +
            "This makes the Accordion more convenient as a tool for folding/collapsing UI elements known in advance whereas a Tree makes more sense as a tool to map data e.g. filesystem structure, XML hierarchy etc.\n" +
            "\n" +
            "Note that the Accordion like many composite components in Codename One is scrollable by default which means you should use it within a non-scrollable hierarchy. If you wish to add it into a scrollable Container you should disable it's default scrollability using setScrollable(false).";
    String infiniteContainerInfo = "This abstract Container can scroll indefinitely (or at least until we run out of data). This class uses the InfiniteScrollAdapter to bring more data and the pull to refresh feature to refresh current displayed data.\n" +
            "\n" +
            "The sample code shows the usage of the nestoria API to fill out an infinitely scrolling list.\n" +
            "\n";
    String splitPaneInfo = "A split pane can either be horizontal or vertical, and provides a draggable divider between two components. If the orientation is HORIZONTAL_SPLIT, then the child components will be laid out horizontally (side by side with a vertical bar as a divider). If the orientation is VERTICAL_SPLIT, then the components are laid out vertically (one above the other.\n" +
            "\n" +
            "The bar divider bar includes arrows to collapse and expand the divider also.";
    String tabsInfo = "A component that lets the user switch between a group of components by clicking on a tab with a given title and/or icon.\n" +
            "\n" +
            "Tabs/components are added to a Tabs object by using the addTab and insertTab methods. A tab is represented by an index corresponding to the position it was added in, where the first tab has an index equal to 0 and the last tab has an index equal to the tab count minus 1.\n" +
            "\n" +
            "The Tabs uses a SingleSelectionModel to represent the set of tab indices and the currently selected index. If the tab count is greater than 0, then there will always be a selected index, which by default will be initialized to the first tab. If the tab count is 0, then the selected index will be -1.\n" +
            "\n" +
            "A simple Tabs sample looks a bit like this:\n" +
            "\n";

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
        demo.add("Accordin", AccordinContainerDemo.getInstance(),accordinInfo, Accordion.class);
        demo.add("Infinite Container", InfiniteContainerDemo.getInstance(resources),infiniteContainerInfo, InfiniteContainer.class);
        demo.add("Split Pane", SplitPaneContainer.getInstance(),splitPaneInfo, SplitPane.class);
        demo.add("Tabs", TabsContainerDemo.getInstance(),tabsInfo, Tabs.class);
        return demo.generate();
    }

}
