package net.londatiga.android.style;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import net.londatiga.android.enums.FontSize;

/**
 * @author Muhammad Rohail
 * 
 *         Company : Confiz Limited
 * 
 *         this class helps setting style to the items of QuickAction
 */
public class ItemStyle {

	private FontSize mFontSize;
	private int mFontColor;
	private Drawable mBackground;
	private int mMinWdith;
	private int mMinHeight;

	public ItemStyle() {
		mFontSize = FontSize.NORMAL_FONT;
		mFontColor = Color.WHITE;
		mMinHeight = -1;
		mMinWdith = -1;
		mBackground = null;
	}

	public FontSize getFontSize() {
		return mFontSize;
	}

	/**
	 * 
	 * sets font size
	 * 
	 * @param mFontSize
	 * 
	 *            set font size of item. you can set small, normal or large font
	 *            size.
	 * 
	 */
	public void setFontSize(FontSize mFontSize) {
		this.mFontSize = mFontSize;
	}

	public int getFontColor() {
		return mFontColor;
	}

	/**
	 * sets font color
	 * 
	 * @param mFontColor
	 *            set color of text
	 */
	public void setFontColor(int mFontColor) {
		this.mFontColor = mFontColor;
	}

	public Drawable getBackground() {
		return mBackground;
	}

	/**
	 * sets background
	 * 
	 * @param mBackground
	 *            set background of item, you can provide drawable having
	 *            different states like pressed and non-pressed etc.
	 */
	public void setBackground(Drawable mBackground) {
		this.mBackground = mBackground;
	}

	public int getMinWdith() {
		return mMinWdith;
	}

	/**
	 * sets min width of item. use it for vertical quickaction
	 * 
	 * @param mMinWdith
	 *            set min width for item in dp
	 */
	public void setMinWdith(int mMinWdith) {
		this.mMinWdith = mMinWdith;
	}

	public int getMinHeight() {
		return mMinHeight;
	}

	/**
	 * sets min height of item use it for horizontal quickaction
	 * 
	 * @param mMinHeight
	 *            set min height for item in dp
	 */
	public void setMinHeight(int mMinHeight) {
		this.mMinHeight = mMinHeight;
	}

}
