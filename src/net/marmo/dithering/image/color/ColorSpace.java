package net.marmo.dithering.image.color;

import net.marmo.dithering.image.color.spaces.GrayscaleColorSpace;
import net.marmo.dithering.image.color.spaces.OneBitColorSpace;

public abstract class ColorSpace {
	
	public static final ColorSpace GRAYSCALE = new GrayscaleColorSpace();
	
	public static final ColorSpace ONE_BIT = new OneBitColorSpace();
	
	public abstract Color sample(Color color);
	
}
