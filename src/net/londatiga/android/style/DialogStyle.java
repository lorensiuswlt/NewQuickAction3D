package net.londatiga.android.style;

import android.graphics.Color;

/**
 * @author Muhammad Rohail
 * 
 * @Company Confiz Limited
 * 
 *          this class helps setting style for dialog of QuickAction
 * 
 */
public class DialogStyle {
	private int mSeperatorColor = Color.WHITE;
	private int mBackgroundColor = Color.BLACK;
	private int borderColor = Color.WHITE;

	private int borderWidth = 2;

	private float dialogRadius = 10;

	// setters
	/**
	 * sets seperator color
	 * 
	 * @param mSeperatorColor
	 *            set color of separator between items
	 */
	public void setSeperatorColor(int mSeperatorColor) {
		this.mSeperatorColor = mSeperatorColor;
	}

	public void setDialogRadius(float radius) {
		dialogRadius = radius;
	}

	/**
	 * set border width in dp
	 * 
	 * @param borderWidth
	 *            border color value. default is 0. if set to 0 then border is
	 *            not visible
	 */
	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}

	/**
	 * sets backgrond color
	 * 
	 * @param mBackgroundColor
	 *            set background of dialog
	 */

	public void setBackgroundColor(int mBackgroundColor) {
		this.mBackgroundColor = mBackgroundColor;
	}

	/**
	 * set border color
	 * 
	 * @param borderColor
	 */
	public void setBorderColor(int borderColor) {
		this.borderColor = borderColor;
	}

	// getters

	public int getSeperatorColor() {
		return mSeperatorColor;
	}

	public int getBackgroundColor() {
		return mBackgroundColor;
	}

	public int getBorderColor() {
		return borderColor;
	}

	public int getBorderWidth() {
		return borderWidth;
	}

	public float getDialogRadius() {
		return dialogRadius;
	}

}
