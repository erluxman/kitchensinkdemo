package com.codename1.demos.kitchen.containers.containerdemos;

import com.codename1.components.ClearableTextField;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;

import static com.codename1.ui.CN.execute;

class SearchBarDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "toolbar.png";
    }

    @Override
    public String getTitle() {
        return "Toolbar";
    }

    @Override
    Container getContent() {
        return searchBarContainer();
    }

    @Override
    public Container getMenuItem() {
        return searchBarContainer();
    }

    private Container searchBarContainer() {
        Container buttonCard = getGridCard(getTitle(), resources.getImage(getImageName()));
        Form form = getToolbarForm(getTitle(), buttonCard);
        form.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_CODE, 4, ee -> {
            execute(getSourceUrl());
        });
        Button imageButton = new Button();
        imageButton.setWidth(10);
        imageButton.addActionListener(evt -> form.show());
        buttonCard.setLeadComponent(imageButton);
        return buttonCard;
    }

    private  Form getToolbarForm(String title,Container buttonCard){
        Form searchScreen = new Form(title);
        Button imageButton = new Button();
        //Button showToolbarScreen = new Button("Show toolbar", "CardButton");
        Button showSearchBar = new Button("Show searchbar");
        Button goBack = new Button("Go back");
        Toolbar searchBar = new Toolbar();
        searchScreen.setToolbar(searchBar);
        Button homeButton = new Button("Home");
        FontImage.setMaterialIcon(homeButton, FontImage.MATERIAL_HOME);
        searchBar.addComponentToSideMenu(homeButton);
        Button profileButton = new Button("Profile");
        FontImage.setMaterialIcon(profileButton, FontImage.MATERIAL_SUPERVISED_USER_CIRCLE);
        searchBar.addComponentToSideMenu(profileButton);
        Button settingButton = new Button("Setting");
        FontImage.setMaterialIcon(settingButton, FontImage.MATERIAL_SETTINGS);
        searchBar.addComponentToSideMenu(settingButton);
        Button logoutButton = new Button("Logout");
        FontImage.setMaterialIcon(logoutButton, FontImage.MATERIAL_LOGOUT);
        searchBar.addComponentToSideMenu(logoutButton);
        searchBar.setRightSideMenuCmdsAlignedToLeft(true);
        Label searchResult = new Label();

        showSearchBar.addActionListener(e -> {
            searchBar.showSearchBar(evt -> {
                String searchValue = (String) evt.getSource();
                searchResult.setText(searchValue);
            });
        });

        imageButton.setWidth(10);
        imageButton.addActionListener(evt -> searchScreen.show());
        buttonCard.setLeadComponent(imageButton);

        goBack.addActionListener(evt -> buttonCard.getComponentForm().showBack());
        Container buttons = new Container(BoxLayout.y());
        buttons.add(searchResult);
        buttons.add(showSearchBar);
        buttons.add(goBack);
        searchScreen.add(buttons);
        return searchScreen;
    }

}
