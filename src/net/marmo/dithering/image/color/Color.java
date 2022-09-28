package net.marmo.dithering.image.color;

import net.marmo.dithering.util.ColorUtil;
import net.marmo.dithering.util.MathUtil;

public class Color {
	
	public static final Color WHITE = ofRGB(0xFFFFFF);
	public static final Color BLACK = ofRGB(0x000000);
	
	private float red;
	private float green;
	private float blue;
	
	public Color(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public float brightness() {
		return Math.max(red, Math.max(green, blue));
	}
	
	public Color clamp() {
		float red = MathUtil.clamp(this.red);
		float green = MathUtil.clamp(this.green);
		float blue = MathUtil.clamp(this.blue);
		
		return new Color(red, green, blue);
	}
	
	public Color subtract(Color color) {
		color = color.multiply(-1);
		
		return add(color);
	}
	
	public Color add(Color color) {
		float red = this.red + color.getRed();
		float green = this.green + color.getGreen();
		float blue = this.blue + color.getBlue();
		
		return new Color(red, green, blue);
	}
	
	public Color divide(float scalar) {
		return multiply(1 / scalar);
	}
	
	public Color multiply(float scalar) {
		return new Color(red * scalar, green * scalar, blue * scalar);
	}
	
	public int toRGB() {
		Color color = clamp();
		
		return ColorUtil.colorToRGB(color);
	}
	
	public float getRed() {
		return red;
	}
	
	public float getBlue() {
		return blue;
	}
	
	public float getGreen() {
		return green;
	}
	
	public static Color ofRGB(int rgb) {
		return ColorUtil.rgbToColor(rgb);
	}
	
}
