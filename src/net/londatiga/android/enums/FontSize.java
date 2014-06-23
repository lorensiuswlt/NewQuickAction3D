package net.londatiga.android.enums;

public enum FontSize {

	/**
	 * set size of font to 12 sp
	 */
	SMALL_FONT(12),

	/**
	 * set size of font to 14 sp
	 */

	NORMAL_FONT(14),

	/**
	 * set size of font to 16 sp
	 */
	LARGE_FONT(16);

	private FontSize(int value) {
		fontSizeVal = value;
	}

	public int getFontSizeVal() {
		return fontSizeVal;
	}

	private int fontSizeVal;
}