package net.marmo.dithering;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.marmo.dithering.image.ImageData;
import net.marmo.dithering.image.color.ColorSpace;

public class Ditherer {
	
	public static void ditherImage(BufferedImage image, ColorSpace colorSpace) {
		ditherImage(image, colorSpace, Dithering.JARVIS);
	}
	
	public static void ditherImage(BufferedImage image, ColorSpace colorSpace, Dithering dithering) {
		ImageData data = ImageData.ofImage(image);
		
		dithering.ditherImage(data, colorSpace);
		
		data.toImage(image);
	}
	
	public static void main(String[] args) {
		try {
			
			File file1 = new File("image_input.png");
			File file2 = new File("image_output.png");
			
			BufferedImage image = ImageIO.read(file1);
			
			ditherImage(image, ColorSpace.ONE_BIT);
			
			ImageIO.write(image, "PNG", file2);
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
