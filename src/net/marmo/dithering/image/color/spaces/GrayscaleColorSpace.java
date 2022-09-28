package net.marmo.dithering.image.color.spaces;

import net.marmo.dithering.image.color.Color;
import net.marmo.dithering.image.color.ColorSpace;

public class GrayscaleColorSpace extends ColorSpace {
	
	@Override
	public Color sample(Color color) {
		float brightness = color.brightness();
		
		return new Color(brightness, brightness, brightness);
	}
	
}
