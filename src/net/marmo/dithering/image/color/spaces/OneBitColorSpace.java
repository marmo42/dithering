package net.marmo.dithering.image.color.spaces;

import net.marmo.dithering.image.color.Color;
import net.marmo.dithering.image.color.ColorSpace;

public class OneBitColorSpace extends ColorSpace {
	
	@Override
	public Color sample(Color color) {
		float brightness = color.brightness();
		
		return brightness > 0.5f ? Color.WHITE : Color.BLACK;
	}
	
}
