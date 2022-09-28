package net.marmo.dithering.util;

import net.marmo.dithering.image.color.Color;

public class ColorUtil {
	
	private static final int RED_COMPONENT_INDEX = 2;
	private static final int GREEN_COMPONENT_INDEX = 1;
	private static final int BLUE_COMPONENT_INDEX = 0;
	
	private static final int MAX_COMPONENT_VALUE = 255;
	private static final int COMPONENT_LENGTH = 8;
	
	public static int colorToRGB(Color color) {
		int red = analogToDigital(color.getRed());
		int green = analogToDigital(color.getGreen());
		int blue = analogToDigital(color.getBlue());
		
		int rgb = 0;
		
		rgb = setColorComponent(rgb, RED_COMPONENT_INDEX, red);
		rgb = setColorComponent(rgb, GREEN_COMPONENT_INDEX, green);
		rgb = setColorComponent(rgb, BLUE_COMPONENT_INDEX, blue);
		
		return rgb;
	}
	
	public static Color rgbToColor(int rgb) {
		float red = digitalToAnalog(getColorComponent(rgb, RED_COMPONENT_INDEX));
		float green = digitalToAnalog(getColorComponent(rgb, GREEN_COMPONENT_INDEX));
		float blue = digitalToAnalog(getColorComponent(rgb, BLUE_COMPONENT_INDEX));
		
		return new Color(red, green, blue);
	}
	
	private static int getColorComponent(int rgb, int index) {
		return (rgb >> index * COMPONENT_LENGTH) & MAX_COMPONENT_VALUE;
	}
	
	private static int setColorComponent(int rgb, int index, int value) {
		return rgb | (value << (COMPONENT_LENGTH * index));
	}
	
	private static int analogToDigital(float value) {
		return Math.round(value * MAX_COMPONENT_VALUE);
	}
	
	private static float digitalToAnalog(int value) {
		return (float) value / MAX_COMPONENT_VALUE;
	}
	
}
