package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.InteractionDialog;
import com.codename1.components.ToastBar;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.codename1.maps.MapComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;

import static com.codename1.ui.CN.CENTER;

class MapsDemo extends DemoComponent {

    String mapComponentInfo ="";
    String googleMapInfo ="";
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

        demo.add("MapComponent", getMapComponentButton(),mapComponentInfo,MapComponent.class);
        demo.add("GoogleMap", getGoogleMapButton(),googleMapInfo,MapContainer.class);
        return demo.generate();
    }

    Button getMapComponentButton() {
        Button showMapComponent = new Button("Show map component");

        showMapComponent.addActionListener(evt -> {
            MapComponent mapComponent = new MapComponent();
            Form viewer = new Form("MapComponent Demo", new BorderLayout());
            viewer.add(CENTER, BorderLayout.center(mapComponent));
            viewer.getToolbar().setBackCommand("", ee -> showMapComponent.getComponentForm().showBack());
            viewer.show();
        });
        return showMapComponent;
    }

    Button getGoogleMapButton() {
        Button showGoogleMap = new Button("Google Map");

        showGoogleMap.addActionListener(evt -> {
            Form hi = new Form("Native Maps Test");
            hi.setLayout(new BorderLayout());
            hi.add(BorderLayout.CENTER, getGoogleMapContainer());
            hi.getToolbar().setBackCommand("Google Map", ee -> showGoogleMap.getComponentForm().showBack());
            hi.show();
        });
        return showGoogleMap;
    }

    Container getGoogleMapContainer (){
        final MapContainer cnt = new MapContainer("AIzaSyAogHsu1vXFGIu1geq3BYfJ4xoYA7hTYh4");
        //final MapContainer cnt = new MapContainer();

        Button btnMoveCamera = new Button("Move Camera");
        btnMoveCamera.addActionListener(e -> {
            cnt.setCameraPosition(new Coord(-33.867, 151.206));
        });
        Style s = new Style();
        s.setFgColor(0xff0000);
        s.setBgTransparency(0);
        FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(3));

        Button btnAddMarker = new Button("Add Marker");
        btnAddMarker.addActionListener(e -> {

            cnt.setCameraPosition(new Coord(41.889, -87.622));
            cnt.addMarker(
                    EncodedImage.createFromImage(markerImg, false),
                    cnt.getCameraPosition(),
                    "Hi marker",
                    "Optional long description",
                    evt -> {
                        ToastBar.showMessage("You clicked the marker", FontImage.MATERIAL_PLACE);
                    }
            );

        });

        Button btnAddPath = new Button("Add Path");
        btnAddPath.addActionListener(e -> {

            cnt.addPath(
                    cnt.getCameraPosition(),
                    new Coord(-33.866, 151.195), // Sydney
                    new Coord(-18.142, 178.431),  // Fiji
                    new Coord(21.291, -157.821),  // Hawaii
                    new Coord(37.423, -122.091)  // Mountain View
            );
        });

        Button btnClearAll = new Button("Clear All");
        btnClearAll.addActionListener(e -> {
            cnt.clearMapLayers();
        });

        cnt.addTapListener(e -> {
            TextField enterName = new TextField();
            Container wrapper = BoxLayout.encloseY(new Label("Name:"), enterName);
            InteractionDialog dlg = new InteractionDialog("Add Marker");
            dlg.getContentPane().add(wrapper);
            enterName.setDoneListener(e2 -> {
                String txt = enterName.getText();
                cnt.addMarker(
                        EncodedImage.createFromImage(markerImg, false),
                        cnt.getCoordAtPosition(e.getX(), e.getY()),
                        enterName.getText(),
                        "",
                        e3 -> {
                            ToastBar.showMessage("You clicked " + txt, FontImage.MATERIAL_PLACE);
                        }
                );
                dlg.dispose();
            });
            dlg.showPopupDialog(new Rectangle(e.getX(), e.getY(), 10, 10));
            enterName.startEditingAsync();
        });

        return LayeredLayout.encloseIn(
                BorderLayout.center(cnt),
                BorderLayout.south(
                        FlowLayout.encloseBottom(btnMoveCamera, btnAddMarker, btnAddPath, btnClearAll)
                )
        );
    }
}
