package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Sheet;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;

import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.NORTH;
import static com.codename1.ui.CN.SOUTH;

class DialogDemo extends DemoComponent {

    @Override
    public String getImageName() {
        return "dialog.png";
    }

    @Override
    public String getTitle() {
        return "Dialogs";
    }

    @Override
    Container getContent() {
        return dialogsContainer();
    }

    private Container dialogsContainer() {
        ComponentDemo demo = new ComponentDemo("Dialogs / Prompts");
        InteractionDialog interactionDialog = new InteractionDialog();

        Button openInteractionDialog = new Button("Deliver Shipping");
        Button confirmDelivery = new Button("Receive");
        Button wrongPackage = new Button("Reject");
        Button ignore = new Button();
        ignore.setWidth(100);
        FontImage.setMaterialIcon(ignore, FontImage.MATERIAL_CLOSE, 8);

        confirmDelivery.addActionListener(evt -> {
            openInteractionDialog.setText("Successfully delivered");
            interactionDialog.dispose();
        });
        wrongPackage.addActionListener(evt -> {
            openInteractionDialog.setText("Wrong Puppy");
            interactionDialog.dispose();
        });
        ignore.addActionListener(evt -> {
            interactionDialog.dispose();
        });

        Container interactionContent = new Container(new BorderLayout());
        interactionContent.add(NORTH, new Container(BoxLayout.xRight()).add(ignore));
        interactionContent.add(CENTER, new Container(BoxLayout.xCenter()).add(resources.getImage("dog.jpg")));
        Container buttonRow = new Container(GridLayout.autoFit());
        buttonRow.add(confirmDelivery).add(wrongPackage);
        interactionContent.add(SOUTH, buttonRow);


        //Container interactionContent = new Container(BoxLayout.yCenter());
        //interactionContent.add(new Container(BoxLayout.xRight()).add(ignore));
        //interactionContent.add();
        //interactionContent.addComponent(confirmDelivery);
        //interactionContent.addComponent(wrongPackage);
        interactionDialog.addComponent(interactionContent);
        interactionDialog.setLayout(new LayeredLayout());
        openInteractionDialog.addActionListener(evt -> interactionDialog.show(200, 200, 100, 100));


        Dialog dialog = new Dialog();
        Container dialogContent = new Container(BoxLayout.yCenter());
        Button openDialog = new Button("Deliver Shipping");
        Button confirmDialog = new Button("Confirm");
        Button closeDialog = new Button("Close");
        confirmDialog.addActionListener(evt -> dialog.dispose());
        closeDialog.addActionListener(evt -> dialog.dispose());
        dialogContent.add(new Container(BoxLayout.xCenter()).add(resources.getImage("dog.jpg")));
        dialogContent.addComponent(new Container(BoxLayout.xCenter()).add(confirmDialog).add(closeDialog));
        dialog.setLayout(new LayeredLayout());
        dialog.addComponent(dialogContent);
        openDialog.addActionListener(evt -> dialog.show());


        Button openSheetButton = new Button("Open Sheet");
        Sheet sheet = new Sheet(null, "         Welcome to the Sheet       ");
        sheet.setWidth(500);
        sheet.setWidth(500);
        Container sheetContents = new Container(BoxLayout.y());

        Button openInLeft = new Button("Open In left");
        openInLeft.addActionListener(evt -> {
            sheet.setPosition(BorderLayout.EAST);
            sheet.show();
        });
        Button openInRight = new Button("Open In Right");
        openInRight.addActionListener(evt -> {
            sheet.setPosition(BorderLayout.WEST);
            sheet.show();
        });

        Button openInTop = new Button("Open In Top");
        openInTop.addActionListener(evt -> {
            sheet.setPosition(BorderLayout.NORTH);
            sheet.show();
        });
        Button openInBottom = new Button("Open In Bottom");
        openInBottom.addActionListener(evt -> {
            sheet.setPosition(BorderLayout.SOUTH);
            sheet.show();
        });

        Button openDetailsSheet = new Button("Open Details");
        SpanLabel detailsText = new SpanLabel("This is best puppy in the world, \nbuy it for million dollars only");
        Sheet detailSheet = new Sheet(sheet, "Sheet Child as Details");
        Container detailsSheetContent = new Container(BoxLayout.y());
        detailsSheetContent.add(resources.getImage("dog.jpg"));
        detailsSheetContent.add(detailsText);
        detailSheet.add(CENTER, detailsSheetContent);

        openDetailsSheet.addActionListener(evt -> {
            detailSheet.show();
        });

        sheetContents.add(openInLeft).add(openInRight).add(openInTop).add(openInBottom).add(openDetailsSheet);

        sheet.add(CENTER, sheetContents);
        sheet.setPosition(BorderLayout.SOUTH);
        openSheetButton.addActionListener(evt -> sheet.show());


        Button showToastBar = new Button("Show toastbar");
        showToastBar.addActionListener((event) -> {
            ToastBar.showMessage("Hello from Toastbar", FontImage.MATERIAL_INFO);
        });

        demo.add("Interaction Dialog", openInteractionDialog);
        demo.add("Dialog", openDialog);
        demo.add("Sheet", openSheetButton);
        demo.add("ToastBar", showToastBar);
        return demo.generate();
    }

}
