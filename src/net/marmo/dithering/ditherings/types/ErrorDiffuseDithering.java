package net.marmo.dithering.ditherings.types;

import net.marmo.dithering.Dithering;
import net.marmo.dithering.image.ImageData;
import net.marmo.dithering.image.color.Color;

// TODO refactor and optimize
public class ErrorDiffuseDithering extends Dithering {
	
	private int diffusionWidth;
	private int diffusionHeight;
	
	private int diffusionOffsetX;
	
	private float diffusionStrength;
	
	private int[] diffusionMultipliers;
	
	public ErrorDiffuseDithering(int diffusionWidth, int diffusionHeight, float diffusionStrength, int[] diffusionMultipliers) {
		this(diffusionWidth, diffusionHeight, -diffusionWidth / 2, diffusionStrength, diffusionMultipliers);
	}
	
	public ErrorDiffuseDithering(int diffusionWidth, int diffusionHeight, int diffusionOffsetX, float diffusionStrength, int[] diffusionMultipliers) {
		this.diffusionWidth = diffusionWidth;
		this.diffusionHeight = diffusionHeight;
		this.diffusionOffsetX = diffusionOffsetX;
		this.diffusionStrength = diffusionStrength;
		this.diffusionMultipliers = diffusionMultipliers;
	}
	
	@Override
	public void ditherPixel(ImageData imageData, int pixelX, int pixelY, Color sourceColor, Color targetColor) {
		super.ditherPixel(imageData, pixelX, pixelY, sourceColor, targetColor);
		
		Color colorError = sourceColor.subtract(targetColor);
		
		for(int y = 0; y < diffusionHeight; y++) {
			for(int x = 0; x < diffusionWidth; x++) {
				
				float multiplier = getDiffusionMultiplier(x, y) * diffusionStrength;
				
				int diffusionPixelX = pixelX + x + diffusionOffsetX;
				int diffusionPixelY = pixelY + y;
				
				diffusePixel(imageData, diffusionPixelX, diffusionPixelY, colorError, multiplier);
			}
		}
	}
	
	private void diffusePixel(ImageData imageData, int pixelX, int pixelY, Color diffusionColor, float multiplier) {
		diffusionColor = diffusionColor.multiply(multiplier);
		
		Color color = imageData.getImageColor(pixelX, pixelY);
		
		color = color.add(diffusionColor);
		
		imageData.setImageColor(pixelX, pixelY, color);
	}
	
	public int getDiffusionMultiplier(int x, int y) {
		int index = y * diffusionWidth + x;
		
		return getDiffusionMultiplier(index);
	}
	
	public int getDiffusionMultiplier(int index) {
		return diffusionMultipliers[index];
	}
	
	public int getDiffusionWidth() {
		return diffusionWidth;
	}
	
	public int getDiffusionHeight() {
		return diffusionHeight;
	}
	
	public int getDiffusionOffsetX() {
		return diffusionOffsetX;
	}
	
	public float getDiffusionStrength() {
		return diffusionStrength;
	}
	
	public int[] getDiffusionMultipliers() {
		return diffusionMultipliers;
	}
	
}
