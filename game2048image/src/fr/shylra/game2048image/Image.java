package fr.shylra.game2048image;

import java.awt.image.BufferedImage;

public class Image {
	public static BufferedImage Img(int i, int j, int k, BufferedImage[] images) {
		if ( k == 2) {
			return (images[1]);
		} else if (k == 4) {
			return (images[2]);
		} else if (k == 8) {
			return (images[3]);
		} else if (k == 16) {
			return (images[4]);
		} else if (k == 32) {
			return (images[5]);
		} else if (k == 64) {
			return (images[6]);
		} else if (k == 128) {
			return (images[7]);
		} else if (k == 256) {
			return (images[8]);
		} else if (k == 512) {
			return (images[9]);
		} else if (k == 1024) {
			return (images[10]);
		} else {
			return (images[11]);
		}
	}
}
