package net.londatiga.android;

import net.londatiga.android.enums.FontSize;
import net.londatiga.android.style.DialogStyle;
import net.londatiga.android.style.ItemStyle;
import net.londatiga.android.ui.ActionItem;
import net.londatiga.android.ui.QuickAction;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * Gallery3D like QuickAction.
 * 
 * This example shows how to use Gallery3D like QuickAction.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 * 
 *         Contributors: - Kevin Peck <kevinwpeck@gmail.com>
 * 
 */
public class ExampleActivity extends Activity {
	// action id
	private static final int ID_UP = 1;
	private static final int ID_DOWN = 2;
	private static final int ID_SEARCH = 3;
	private static final int ID_INFO = 4;
	private static final int ID_ERASE = 5;
	private static final int ID_OK = 6;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		final QuickAction quickAction1 = getBtn1QuickAction();
		final QuickAction quickAction2 = getBtn2QuickAction();
		final QuickAction quickAction3 = getBtn3QuickAction();

		// show on btn1
		Button btn1 = (Button) this.findViewById(R.id.btn1);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				quickAction1.show(v);
			}
		});

		Button btn2 = (Button) this.findViewById(R.id.btn2);
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				quickAction2.show(v);
			}
		});

		Button btn3 = (Button) this.findViewById(R.id.btn3);
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				quickAction3.show(v);
				quickAction3.setAnimStyle(QuickAction.ANIM_REFLECT);
			}
		});
	}

	private QuickAction getBtn3QuickAction() {

		// create QuickAction. Use QuickAction.VERTICAL or
		// QuickAction.HORIZONTAL param to define layout
		// orientation
		final QuickAction quickAction = new QuickAction(this,
				QuickAction.HORIZONTAL);

		addActionItems(quickAction);
		return quickAction;
	}

	private QuickAction getBtn2QuickAction() {
		DialogStyle btn1DialogStyle = getDialogStyle(Color.WHITE, 5,
				Color.BLACK, 2, Color.GRAY);

		ItemStyle btn1ItemStyle = getBtnItemStyle(
				R.drawable.action_item_selected_test, Color.BLACK,
				FontSize.LARGE_FONT);

		// create QuickAction. Use QuickAction.VERTICAL or
		// QuickAction.HORIZONTAL param to define layout
		// orientation
		final QuickAction quickAction = new QuickAction(this,
				QuickAction.VERTICAL, btn1DialogStyle, btn1ItemStyle);

		addActionItems(quickAction);
		return quickAction;

	}

	private DialogStyle getDialogStyle(int backgroundColor, float radius,
			int SeparatorColor, int borderWidth, int borderColor) {
		// Set dialog styles
		DialogStyle dialogStyle = new DialogStyle();
		dialogStyle.setBackgroundColor(backgroundColor);
		dialogStyle.setDialogRadius(radius);
		dialogStyle.setSeperatorColor(SeparatorColor);
		dialogStyle.setBorderWidth(borderWidth);
		dialogStyle.setBorderColor(borderColor);
		return dialogStyle;
	}

	private QuickAction getBtn1QuickAction() {
		DialogStyle btn1DialogStyle = getDialogStyle(Color.MAGENTA, 10,
				Color.GREEN, 0, Color.GRAY);

		ItemStyle btn1ItemStyle = getBtnItemStyle(
				R.drawable.action_item_selected_test, Color.WHITE,
				FontSize.NORMAL_FONT);

		// create QuickAction. Use QuickAction.VERTICAL or
		// QuickAction.HORIZONTAL param to define layout
		// orientation
		final QuickAction quickAction = new QuickAction(this,
				QuickAction.HORIZONTAL, btn1DialogStyle, btn1ItemStyle);

		addActionItems(quickAction);
		return quickAction;

	}

	private void addActionItems(final QuickAction quickAction) {
		ActionItem nextItem = new ActionItem(ID_DOWN, "Next", getResources()
				.getDrawable(R.drawable.menu_down_arrow));
		ActionItem prevItem = new ActionItem(ID_UP, "Prev", getResources()
				.getDrawable(R.drawable.menu_up_arrow));
		ActionItem searchItem = new ActionItem(ID_SEARCH, "Find",
				getResources().getDrawable(R.drawable.menu_search));
		ActionItem infoItem = new ActionItem(ID_INFO, "Info", getResources()
				.getDrawable(R.drawable.menu_info));
		ActionItem eraseItem = new ActionItem(ID_ERASE, "Clear", getResources()
				.getDrawable(R.drawable.menu_eraser));
		ActionItem okItem = new ActionItem(ID_OK, "OK", getResources()
				.getDrawable(R.drawable.menu_ok));

		// use setSticky(true) to disable QuickAction dialog being dismissed
		// after an item is clicked
		prevItem.setSticky(true);
		nextItem.setSticky(true);

		// add action items into QuickAction
		quickAction.addActionItem(nextItem);
		quickAction.addActionItem(prevItem);
		quickAction.addActionItem(searchItem);
		quickAction.addActionItem(infoItem);
		quickAction.addActionItem(eraseItem);
		quickAction.addActionItem(okItem);

		// Set listener for action item clicked
		quickAction
				.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {
					@Override
					public void onItemClick(QuickAction source, int pos,
							int actionId) {
						ActionItem actionItem = quickAction.getActionItem(pos);

						// here we can filter which action item was clicked with
						// pos or actionId parameter
						if (actionId == ID_SEARCH) {
							Toast.makeText(getApplicationContext(),
									"Let's do some search action",
									Toast.LENGTH_SHORT).show();
						} else if (actionId == ID_INFO) {
							Toast.makeText(getApplicationContext(),
									"I have no info this time",
									Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(getApplicationContext(),
									actionItem.getTitle() + " selected",
									Toast.LENGTH_SHORT).show();
						}
					}
				});

		// set listnener for on dismiss event, this listener will be called only
		// if QuickAction dialog was dismissed
		// by clicking the area outside the dialog.
		quickAction.setOnDismissListener(new QuickAction.OnDismissListener() {
			@Override
			public void onDismiss() {
				Toast.makeText(getApplicationContext(), "Dismissed",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	private ItemStyle getBtnItemStyle(int backgroundResId, int fontColor,
			FontSize fontSize) {
		// Set Items style
		ItemStyle itemStyle = new ItemStyle();
		itemStyle.setBackground(getResources().getDrawable(backgroundResId));
		itemStyle.setFontColor(fontColor);
		itemStyle.setFontSize(fontSize);
		// itemStyle.setMinHeight(200);
		// itemStyle.setMinWdith(50);
		return itemStyle;
	}

}