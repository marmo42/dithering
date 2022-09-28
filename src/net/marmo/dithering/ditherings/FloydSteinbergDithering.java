package net.marmo.dithering.ditherings;

import net.marmo.dithering.ditherings.types.ErrorDiffuseDithering;

public class FloydSteinbergDithering extends ErrorDiffuseDithering {
	
	private static final int[] DIFFUSION_MULTIPLIERS = new int[] {
		0, 0, 7,
		3, 5, 1
	};
	
	public FloydSteinbergDithering() {
		super(3, 2, 1 / 16f, DIFFUSION_MULTIPLIERS);
	}
	
}
