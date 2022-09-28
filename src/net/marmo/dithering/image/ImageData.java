package net.marmo.dithering.image;

import java.awt.image.BufferedImage;

import net.marmo.dithering.image.color.Color;

public class ImageData {
	
	private int imageWidth;
	private int imageHeight;
	
	private Color[][] imageColors;
	
	public ImageData(int imageWidth, int imageHeight) {
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		
		this.imageColors = new Color[imageWidth][imageHeight];
	}
	
	public BufferedImage toImage() {
		BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		
		return toImage(image);
	}
	
	public BufferedImage toImage(BufferedImage image) {
		for(int x = 0; x < imageWidth; x++) {
			for(int y = 0; y < imageHeight; y++) {
				
				Color color = getImageColor(x, y);
				
				int rgb = color.toRGB();
				
				image.setRGB(x, y, rgb);
			}
		}
		
		return image;
	}
	
	public Color getImageColor(int x, int y) {
		if(isOutOfBounds(x, y)) return Color.BLACK;
		
		return imageColors[x][y];
	}
	
	public void setImageColor(int x, int y, Color color) {
		if(isOutOfBounds(x, y)) return;
		
		imageColors[x][y] = color;
	}
	
	private boolean isOutOfBounds(int x, int y) {
		return x < 0 || y < 0 || x >= imageWidth || y >= imageHeight;
	}
	
	public int getImageWidth() {
		return imageWidth;
	}
	
	public int getImageHeight() {
		return imageHeight;
	}
	
	public Color[][] getImageColors() {
		return imageColors;
	}
	
	public static ImageData ofImage(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		
		ImageData data = new ImageData(width, height);
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				int rgb = image.getRGB(x, y);
				
				Color color = Color.ofRGB(rgb);
				
				data.setImageColor(x, y, color);
			}
		}
		
		return data;
	}
	
}
