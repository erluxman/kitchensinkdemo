I have checked out and built your fork.  Here is some feedback.

Good start!.  Most of the components are in place.  We need to refine it in places, and some of the components need some changes to properly demonstrate their functionality, but there's a good base here to work with.

One key thing that needs to be added throughout is the ability for the user to find more information about each component, and see a code sample of how each is used.  So for each component, there should be a button that links to the javadocs for the component.  For the "Snippet", I'd like the user to stay in the app.  The button to see the code snippet for each can open a form with a BrowserComponent showing the content.  You can embed an [AceEditor](https://ace.c9.io/) in the browser component and display the snippet.

Once all of the flow is in place, I've going to get Renzo to do a design for it in XD - then I'll get you to implement that design.

- Maps
	- Google Map
		- If the the google map credentials aren’t available, then show a screenshot of a nice-looking google map, and add explain that Google Maps requires a Google Maps account.  Add a button that opens  the Google Maps Github page for more information.	
- Labels Form
	✅ SpanLabel needs longer test to demonstrate that the text wraps.  Use Lorem ipsum
	ScaleImageLabel 
  		✅ Add button for user to select a different image
		❌ Add Selection (using combo box or picker) to change the size of the component (small, medium, large)
	Floating hint
        ✅ This doesn’t seem to demonstrate floating hint’s ability to float.   When you enter text, the hint should float above the field

-Buttons
	- Multi Button.
	    - Create a better example that shows the real-world use-case for MultiButton.  
		    They can have checkboxes, badges, icons, etc….   
		    Show a container with 3 or 4 multi-buttons so people get the idea.
	- Scale Image Button
		- Add option for user to change the image
	- Floating Action Button
		- To see this properly used it needs to be on separator form. Make a subform for the floating 
		action button.  The subform should have some sort of list (box layout y), and the Floating action
		button should appear in bottom right of form.  The Contacts section already has a good example of this.

- Containers

	- Each container should have its own sub-form

	- Accordion
		- Add a few more headings
	- Infinite Container
		- Doesn’t seem infinite.  Have it generate an infinite number of rows using the Infinite container functionality
	- Tabs
		- Most definitely needs its own form.
		- Have something more interesting for each tab content.


- Dialog

	- Interaction Dialog
		- Don’t just show the dialog contents in this section.  Add a button that opens the Interaction Dialog 
		    just like you have for the other dialog types.

	- Dialog
		- The dialog needs work.  It just says “OK”.   
	- Sheet
		- Have the sheet show a little bit more than just Hello there.
		- Demonstrate its ability to navigate to a new sheet from within the sheet, with its back-button 
		functionality
		- I have added the ability to set the Sheet position (NORTH, EAST, WEST, SOUTH, CENTER).  Give user 
		ability to test out each of these positions.

ToolBar
	-  This doesn’t use the toolbar at all.  You might need to read some of the docs and tutorials on 
	ToolBar to get the idea.  The ToolBar is attached to a form.  It provides a side menu, and the option to add menu buttons in various places on the form.   The Search bar is a feature of the toolbar.  It shouldn’t just be placed on the form as it is.  It should be integrated with the toolbar for that demonstration.  You’ll want multiple Toolbar demonstrations - have each in its own subform.

Progress 
    Slider Looks strange. Looks like two sliders on top of each other



A couple of things I noticed:

- Component embedding is inconsistent in complex components e.g. in the advanced section the signature component is a link to a separate form (this makes sense). But the calendar, RSS reader etc. are all embedded into the same form and that makes scrolling/seeing them really hard.
Naturally this doesn't apply to simple components like labels and buttons

- I would suggest removing map component, it's deprecated. We should only support the native maps. Here there's a bit of a problem with getting the map key @shannah what do you think?

- Is media empty or is this just the JS port?