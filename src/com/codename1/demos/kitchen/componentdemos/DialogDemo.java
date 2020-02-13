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

    String interactionInfo = "Unlike a regular dialog the interaction dialog only looks like a dialog, it resides in the layered pane and can be used to implement features where interaction with the background form is still required.\n" +
            "Since this code is designed for interaction all \"dialogs\" created thru here are modless and never block.\n";
    String dialogInfo = "A dialog is a form that occupies a part of the screen and appears as a modal entity to the developer. Dialogs allow us to prompt users for information and rely on the information being available on the next line after the show method.\n" +
            "\n" +
            "Modality indicates that a dialog will block the calling thread even if the calling thread is the EDT. Notice that a dialog will not release the block until dispose is called even if show() from another form is called! Events are still performed thanks to the Display.invokeAndBlock(java.lang.Runnable) capability of the Display class.\n" +
            "\n" +
            "To determine the size of the dialog use the show method that accepts 4 integer values, notice that these values accept margin from the four sides rather than x, y, width and height values!\n" +
            "\n" +
            "It's important to style a Dialog using getDialogStyle() or setDialogUIID(java.lang.String) methods rather than styling the dialog object directly.\n" +
            "\n" +
            "The Dialog class also includes support for popup dialog which is a dialog type that is positioned next to a component or screen area and points an arrow at that location.\n" +
            "\n";
    String sheetInfo = "A light-weight dialog that slides up from the bottom of the screen on mobile devices. Sheets include a \"title\" bar, with a back/close button, a title label, and a \"commands container\" (getCommandsContainer()) which allows you to insert your own custom components (usually buttons) in the upper right.\n" +
            "Custom content should be placed inside the content pane which can be retrieved via getContentPane()\n" +
            "\n" +
            "Usage\n" +
            "The general usage is to create new Sheet instance (or subclass), then call show() to make it appear over the current form. If a different sheet that is currently being displayed, then calling show() will replace it.";
    String toastInfo = "An API to present status messages to the user in an unobtrusive manner. This is useful if there are background tasks that need to display information to the user. E.g. If a network request fails, of let the user know that \"Jobs are being synchronized\".";

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

        demo.add("Interaction Dialog", openInteractionDialog, interactionInfo, InteractionDialog.class);
        demo.add("Dialog", openDialog, dialogInfo, Dialog.class);
        demo.add("Sheet", openSheetButton, sheetInfo, Sheet.class);
        demo.add("ToastBar", showToastBar, toastInfo, ToastBar.class);
        return demo.generate();
    }

}
