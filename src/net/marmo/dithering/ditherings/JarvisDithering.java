package net.marmo.dithering.ditherings;

import net.marmo.dithering.ditherings.types.ErrorDiffuseDithering;

public class JarvisDithering extends ErrorDiffuseDithering {
	
	private static final int[] DIFFUSION_MULTIPLIERS = new int[] {
		0, 0, 0, 7, 5,
		3, 5, 7, 5, 3,
		1, 3, 5, 3, 1
	};
	
	public JarvisDithering() {
		super(5, 3, 1 / 48f, DIFFUSION_MULTIPLIERS);
	}
	
}
