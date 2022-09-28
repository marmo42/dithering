package net.marmo.dithering;

import net.marmo.dithering.ditherings.FloydSteinbergDithering;
import net.marmo.dithering.ditherings.JarvisDithering;
import net.marmo.dithering.image.ImageData;
import net.marmo.dithering.image.color.Color;
import net.marmo.dithering.image.color.ColorSpace;

public class Dithering {
	
	public static final Dithering JARVIS = new JarvisDithering();
	public static final Dithering FLOYD_STEINBERG = new FloydSteinbergDithering();
	
	public static final Dithering NONE = new Dithering();
	
	public void ditherPixel(ImageData imageData, int pixelX, int pixelY, Color sourceColor, Color targetColor) {
		imageData.setImageColor(pixelX, pixelY, targetColor);
	}
	
	public void ditherImage(ImageData imageData, ColorSpace colorSpace) {
		for(int y = 0; y < imageData.getImageHeight(); y++) {
			for(int x = 0; x < imageData.getImageWidth(); x++) {
				
				Color sourceColor = imageData.getImageColor(x, y);
				Color targetColor = colorSpace.sample(sourceColor);
				
				ditherPixel(imageData, x, y, sourceColor, targetColor);
			}
		}
	}
	
}
