package net.londatiga.android;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.Toast;

/**
 * Gallery 3D like quickaction. 
 * 
 * This example shows how to use Gallery3D like quickaction.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *
 */
public class NewQuickAction3DActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		//dashboard action item
		ActionItem dashboard = new ActionItem();
		
		dashboard.setTitle("Dashboard");
		dashboard.setIcon(getResources().getDrawable(R.drawable.dashboard));
		
		//user action item
		ActionItem user = new ActionItem();
		
		user.setTitle("Users & Groups");
		user.setIcon(getResources().getDrawable(R.drawable.kontak));
		
		//create quickaction
		final QuickAction quickAction = new QuickAction(this);
		
		quickAction.addActionItem(dashboard);
		quickAction.addActionItem(user);
		
		quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {			
			@Override
			public void onItemClick(int pos) {
				if (pos == 0) {
					Toast.makeText(NewQuickAction3DActivity.this, "Dashboard item selected", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(NewQuickAction3DActivity.this, "User item selected", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
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