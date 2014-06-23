package net.londatiga.android.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class Util {

	public static int dipToPixels(Context context, float dipValue) {
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dipValue, metrics);
	}

	public static Drawable createDrawable(Context context, int color,
			float radius, int strokeWidth, int strokeColor, int shape) {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(Util.dipToPixels(context, radius));
		gd.setStroke(Util.dipToPixels(context, strokeWidth), strokeColor);
		gd.setShape(shape);// GradientDrawable.RECTANGLE);
		return gd;

	}

}
