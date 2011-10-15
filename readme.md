NewQuickAction3D
================

NewQuickAction3D is a small android library to create QuickAction dialog with Gallery3D app style.

How to Use
==========
This repo includes a sample Activity (__ExampleActivity.java__) to show how to use QuickAction.

	public class ExampleActivity extends Activity {
		//action id
		private static final int ID_UP     = 1;
		private static final int ID_DOWN   = 2;
		private static final int ID_SEARCH = 3;
		private static final int ID_INFO   = 4;
		private static final int ID_ERASE  = 5;	
		private static final int ID_OK     = 6;
	    
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			setContentView(R.layout.main);

			ActionItem nextItem 	= new ActionItem(ID_DOWN, "Next", getResources().getDrawable(R.drawable.menu_down_arrow));
			ActionItem prevItem 	= new ActionItem(ID_UP, "Prev", getResources().getDrawable(R.drawable.menu_up_arrow));
        	ActionItem searchItem 	= new ActionItem(ID_SEARCH, "Find", getResources().getDrawable(R.drawable.menu_search));
        	ActionItem infoItem 	= new ActionItem(ID_INFO, "Info", getResources().getDrawable(R.drawable.menu_info));
        	ActionItem eraseItem 	= new ActionItem(ID_ERASE, "Clear", getResources().getDrawable(R.drawable.menu_eraser));
        	ActionItem okItem 		= new ActionItem(ID_OK, "OK", getResources().getDrawable(R.drawable.menu_ok));
        
        	//use setSticky(true) to disable QuickAction dialog being dismissed after an item is clicked
        	prevItem.setSticky(true);
        	nextItem.setSticky(true);
		
			//create QuickAction. Use QuickAction.VERTICAL or QuickAction.HORIZONTAL param to define layout 
        	//orientation
			final QuickAction quickAction = new QuickAction(this, QuickAction.VERTICAL);
		
			//add action items into QuickAction
        	quickAction.addActionItem(nextItem);
			quickAction.addActionItem(prevItem);
        	quickAction.addActionItem(searchItem);
        	quickAction.addActionItem(infoItem);
        	quickAction.addActionItem(eraseItem);
        	quickAction.addActionItem(okItem);
        
        	//Set listener for action item clicked
			quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {			
				@Override
				public void onItemClick(QuickAction source, int pos, int actionId) {
					//here we can filter which action item was clicked with pos or actionId parameter
					ActionItem actionItem = quickAction.getActionItem(pos);
                 
					Toast.makeText(getApplicationContext(), actionItem.getTitle() + " selected", Toast.LENGTH_SHORT).show();			    
				}
			});
		
			//set listnener for on dismiss event, this listener will be called only if QuickAction dialog was dismissed
			//by clicking the area outside the dialog.
			quickAction.setOnDismissListener(new QuickAction.OnDismissListener() {			
				@Override
				public void onDismiss() {
					Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
				}
			});
		
			//show on btn1
			Button btn1 = (Button) this.findViewById(R.id.btn1);
			btn1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					quickAction.show(v);
				}
			});

			Button btn2 = (Button) this.findViewById(R.id.btn2);
			btn2.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					quickAction.show(v);
				}
			});
		
			Button btn3 = (Button) this.findViewById(R.id.btn3);
			btn3.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					quickAction.show(v);
					quickAction.setAnimStyle(QuickAction.ANIM_REFLECT);
				}
			});
		}
	}

**See http://www.londatiga.net/it/how-to-create-quickaction-dialog-in-android/ for more information.**

![Example Image](http://londatiga.net/images/quickaction3d_horizontal.png)  ![Example Image](http://londatiga.net/images/quickaction3d_vertical.png) 

Developed By
============

* Lorensius W. L. T - <lorenz@londatiga.net>

Contributors
============

* Kevin Peck - <kevinwpeck@gmail.com>

Changes
=======

### 2011-10-15:
* Fix 'container moves' bug as addressed in this [issue](https://github.com/lorensiuswlt/NewQuickAction3D/issues/1). Thanx to [The Vaan](TheVaan@gmail.com) for giving me the clue.
2. New improvements added by [Kevin Pack](kevinpeck@gmail.com):
  3. Action Item – new constructor with action id, title, icon
  4. Callback enhanced to return QuickAction object as source and action id (allows you to add items in any order as you base what was clicked on by the ID, not the pos)
  5. Action item supports sticky mode, if that is enabled the menu does not dismiss post button press. I needed this for my application.
  6. QuickAction has getActionItem(pos) call so you can get action item back. QuickAction has ArrayList of added items to support this
  7. QuickAction supports constructor with horizontal flag so you can run menu horizontally instead of just vertically
  8. If doing horizontal QuickAction loads the action_item_horizontal.xml and popup_horizontal.xml files instead of the vertical ones
  9. Added action_item_horizontal.xml with a centered image over a centered text label
  10. Added horiz_separator.xml file so you can show a separator between items in a horizontal layout
  11. Updated NewQuickAction3DActivity to show the toast message based on label of action item clicked as you now have enough info in callback to do that generically
  12. Update sample code to show sticky items in action, watching for dismiss action and extra menu items 
3. New listener to handle on dismiss event.

### 2011-10-05:
* Fix force close that occured when tapping randomly on a view to show QuickAction dialog ([issue](https://github.com/lorensiuswlt/NewQuickAction3D/issues/2)). Thanx to [Zammbi](zammbi@gmail.com) for bug fixing..