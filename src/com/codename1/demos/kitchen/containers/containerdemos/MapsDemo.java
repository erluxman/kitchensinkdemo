package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.demos.kitchen.map.GoogleMapDemo;
import com.codename1.maps.MapComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.CENTER;

class MapsDemo extends DemoComponent {
    @Override
    String getImageName() {
        return "maps.png";
    }

    @Override
    String getTitle() {
        return "Maps";
    }

    @Override
    Container getContent() {
        return mapsContainer();
    }

    private Container mapsContainer() {
        ComponentDemo demo = new ComponentDemo(getTitle());
        MapComponent mapComponent = new MapComponent();
        Button showMapComponent = new Button("Show map component");

        Form viewer = new Form("MapComponent Demo", new BorderLayout());
        viewer.add(CENTER, BorderLayout.center(mapComponent));
        viewer.getToolbar().setBackCommand("", ee -> showMapComponent.getComponentForm().showBack());
        showMapComponent.addActionListener(evt -> {
            viewer.show();
        });

        //Is google map that hard to implement ( as in github repo)?
        demo.add("MapComponent", showMapComponent);
        demo.add("GoogleMap", GoogleMapDemo.getGoogleMapButton());
        return demo.generate();
    }
}
