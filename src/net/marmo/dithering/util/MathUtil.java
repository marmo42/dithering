package net.marmo.dithering.util;

public class MathUtil {
	
	private static final float DEFAULT_CLAMPING_MIN = 0;
	private static final float DEFAULT_CLAMPING_MAX = 1;
	
	public static float clamp(float value) {
		return clamp(value, DEFAULT_CLAMPING_MIN, DEFAULT_CLAMPING_MAX);
	}
	
	public static float clamp(float value, float min, float max) {
		if(value < min) return min;
		if(value > max) return max;
		
		return value;
	}
	
}
