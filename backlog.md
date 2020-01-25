One key thing that needs to be added throughout is the ability for the user to find more information about 
each component, and see a code sample of how each is used.  So for each component, there should be a button 
that links to the javadocs for the component.  For the "Snippet", I'd like the user to stay in the app.  
The button to see the code snippet for each can open a form with a BrowserComponent showing the content.  
You can embed an [AceEditor](https://ace.c9.io/) in the browser component and display the snippet.

- Maps
	- Google Map
		- If the the google map credentials aren’t available, then show a screenshot of a nice-looking google map, and add explain that Google Maps requires a Google Maps account.  Add a button that opens  the Google Maps Github page for more information.	
- Labels Form
	ScaleImageLabel 
		❌ Add Selection (using combo box or picker) to change the size of the component (small, medium, large)
-Buttons
	- Multi Button.
	    - Create a better example that shows the real-world use-case for MultiButton.  
		    They can have checkboxes, badges, icons, etc….   
		    Show a container with 3 or 4 multi-buttons so people get the idea.
			
ToolBar
	-  This doesn’t use the toolbar at all.  You might need to read some of the docs and tutorials on 
	ToolBar to get the idea.  The ToolBar is attached to a form.  It provides a side menu, and the option to add menu buttons in various places on the form.   The Search bar is a feature of the toolbar.  It shouldn’t just be placed on the form as it is.  It should be integrated with the toolbar for that demonstration.  You’ll want multiple Toolbar demonstrations - have each in its own subform.

Progress 
    Slider Looks strange. Looks like two sliders on top of each other

- Component embedding is inconsistent in complex components e.g. in the advanced section the signature component is a link to a separate form (this makes sense). But the calendar, RSS reader etc. are all embedded into the same form and that makes scrolling/seeing them really hard.
Naturally this doesn't apply to simple components like labels and buttons

- I would suggest removing map component, it's deprecated. We should only support the native maps. Here there's a bit of a problem with getting the map key @shannah what do you think?

- Is media empty or is this just the JS port?