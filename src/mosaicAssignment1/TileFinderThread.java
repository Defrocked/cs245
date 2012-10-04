package mosaicAssignment1;

import java.awt.Color;
import java.util.ArrayList;

public class TileFinderThread implements Runnable {
	private int tileWidth;
	private int tileHeight;
	private int threadNum;
	private UWECImage blankMosaic;
	private UWECImage image;
	private ArrayList<UWECImage> imageAL;

	public TileFinderThread(UWECImage blankMosaic, UWECImage image, int tileWidth, int tileHeight, ArrayList<UWECImage> imageAL, int threadNum) {
		this.blankMosaic = blankMosaic;
		this.image = image;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.threadNum = threadNum;
		this.imageAL = imageAL;
	}

	public void run() {
		//task splitting
		int numOfThreads = blankMosaic.getWidth() / tileWidth;
		int startWidth = blankMosaic.getWidth() / numOfThreads * threadNum;
		int endWidth = blankMosaic.getWidth() / numOfThreads * (threadNum + 1);

		//variables used inside the loops
		int red = 0;
		int green = 0;
		int blue = 0;
		Color aveColour;
		
		// LOOPAN increment by 10x10 since that is the size of our squares?
		for (int i = startWidth; i < endWidth; i += tileWidth) {
			for (int j = 0; j < blankMosaic.getHeight(); j += tileHeight) {
				// set the avecolour to for 10x10 squares
				aveColour = image.averageImageColor(i, j, tileWidth, tileHeight);

				// find the best tile for the average colour
				UWECImage bestTile;
				bestTile = imageAL.get(MosaicMaker.findBestTile(aveColour));

				// loop to copy the pixels of the best tile to the rectangle of
				// our mosaic
				for (int k = 0; k < tileWidth; k++) {
					for (int l = 0; l < tileHeight; l++) {
						// get the red green and blue values
						red = bestTile.getRed(k, l);
						green = bestTile.getGreen(k, l);
						blue = bestTile.getBlue(k, l);

						// puts the colour into the new image;
						blankMosaic.setRGB(k + i, l + j, red, green, blue);
					}
				}
			}
		}
	}
}
