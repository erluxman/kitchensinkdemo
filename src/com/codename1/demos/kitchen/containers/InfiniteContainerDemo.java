package com.codename1.demos.kitchen.containers;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfiniteContainerDemo extends InfiniteContainer {

    static int pageNumber = 1;

    public static Button getInstance(Resources resources) {
        Button infiniteContainerButton = new Button("Infinite Container");
        Form infiniteList = new Form("InfiniteContainer", new BorderLayout());

        infiniteList.add(BorderLayout.CENTER, getInfiniteContainerContent(resources));
        infiniteList.getToolbar().setBackCommand("Line Chart", ee -> infiniteContainerButton.getComponentForm().showBack());
        infiniteContainerButton.addActionListener(evt -> {
            infiniteList.show();
        });
        return infiniteContainerButton;
    }

    public static InfiniteContainer getInfiniteContainerContent(Resources resources){
        InfiniteContainer ic = new InfiniteContainer() {
            @Override
            public Component[] fetchComponents(int index, int amount) {
                java.util.List<Map<String, Object>> data = fetchPropertyData();
                Button[] cmps = new Button[data.size()];
                for (int iter = 0; iter < cmps.length; iter++) {
                    Map<String, Object> datam = data.get(iter);
                    cmps[iter] = new Button("Image" + iter + " Page no" + datam.get("page"));
                    cmps[iter].setIcon(resources.getImage("dog.jpg"));
                }
                return cmps;
            }
        };
        return ic;
    }

    static List<Map<String, Object>> fetchPropertyData() {
        try {

            List<Map<String, Object>> responseList = new ArrayList();

            for (int i = 0; i < 10; i++) {
                responseList.add(getIthItem(pageNumber));
            }
            pageNumber++;
            return responseList;
        } catch (Exception err) {
            Log.e(err);
            return null;
        }
    }

    static Map<String, Object> getIthItem(int pageNumber) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", pageNumber);
        return map;
    }

    @Override
    public Component[] fetchComponents(int index, int amount) {
        return new Component[0];
    }
}
