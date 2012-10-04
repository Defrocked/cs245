package mosaicAssignment1;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

public class MosaicMaker {
	@SuppressWarnings("unused")
	private String tileFolder;
	private int horzMosaicSize;
	private int vertMosaicSize;
	private int horzNumTiles;
	@SuppressWarnings("unused")
	private int vertNumTiles;
	private ArrayList<UWECImage> imageAL;
	private static ArrayList<Color> imageColourAL;
	private int tileHeight;
	private int tileWidth;

	public MosaicMaker(String tileFolder, int horzMosaicSize, int vertMosaicSize, int horzNumTiles, int vertNumTiles) {
		this.tileFolder = tileFolder;
		this.horzMosaicSize = horzMosaicSize;
		this.vertMosaicSize = vertMosaicSize;
		this.horzNumTiles = horzNumTiles;
		this.vertNumTiles = vertNumTiles;
		Color aveTileColour;

		// creates a file object of the folder path
		File tileFiles = new File(tileFolder);

		// creates an array for files and an arraylist for images and image
		// colours
		String[] fileArray;
		this.imageAL = new ArrayList<UWECImage>();
		MosaicMaker.imageColourAL = new ArrayList<Color>();

		// lists the files in the folder as an array of abstract pathnames and
		// assigns to our file array
		fileArray = tileFiles.list();

		// gets the height and width we want our tiles to be
		this.tileHeight = vertMosaicSize / vertNumTiles;
		this.tileWidth = horzMosaicSize / horzNumTiles;

		for (int i = 0; i < fileArray.length; i++) {
			// makes our list of file pathnames into image files
			UWECImage fileToImage = new UWECImage("dvdReleases/" + fileArray[i]);

			// scales our images based on our earlier calculation
			fileToImage.scaleImage(tileWidth, tileHeight);

			// finds the average colour of our images
			aveTileColour = fileToImage.averageImageColor();

			// adds the scaled image to an arraylist and average colours to an
			// arraylist
			imageAL.add(fileToImage);
			imageColourAL.add(aveTileColour);
		}
	}

	/**
	 * takes the image to be mosaic'd and then splits it up into tile sized
	 * rectangles (10x10 in our case)
	 * 
	 * send everything to the tilefinderthread method to get the average colour,
	 * find the best tile, and then mosaic the new image
	 * 
	 * @param image
	 * @return blankMosaic
	 * @throws InterruptedException 
	 */
	public UWECImage createMosaic(UWECImage image) {
		// scales our mosaic image
		image.scaleImage(horzMosaicSize, vertMosaicSize);

		// create a new blank uwecimage
		UWECImage blankMosaic = new UWECImage(horzMosaicSize, vertMosaicSize);

		// create threads and total number of tiles to be used
		int numOfThreads = (horzNumTiles); // should be 192 //64
		TileFinderThread[] tft = new TileFinderThread[numOfThreads];
		Thread[] ts = new Thread[numOfThreads];

		// start threads
		for (int i = 0; i < numOfThreads; i++) {
			tft[i] = new TileFinderThread(blankMosaic, image, tileWidth, tileHeight, imageAL, i);
			ts[i] = new Thread(tft[i]);
			ts[i].start();
		}
		// wait for all of the tile threads and merge them
		for (int i = 0; i < numOfThreads; i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return blankMosaic;
	}

	// Find the tile with the best match to the mosaic.
	public static int findBestTile(Color mosaicColor) {
		// int to hold location in array of the best tile.
		int bestTile = 0;
		// double to hold the distance of the currently best tile; starts at
		// 100000 to make sure will be larger than distance.
		double currentBestTile = 100000;
		// ints for each color in mosaic
		int R = mosaicColor.getRed();
		int G = mosaicColor.getGreen();
		int B = mosaicColor.getBlue();
		// float arrays for the HSB conversion.
		float[] mosaicHSB;
		float[] tileHSB;
		// Convert mosaic RGB colors to HSB colors.
		mosaicHSB = Color.RGBtoHSB(R, G, B, null);
		// Make doubles to use to compare floats generated.
		double mosaicH = mosaicHSB[0];
		double mosaicS = mosaicHSB[1];
		double mosaicB = mosaicHSB[2];
		double tileH;
		double tileS;
		double tileB;

		// double for the distance for the tile as they are checked.
		double newTile;
		// for loop to check the distance for every tile.
		for (int i = 0; i < imageColourAL.size(); i++) {
			// set the tile RGB to HSB conversion and convert to doubles.
			tileHSB = Color.RGBtoHSB(imageColourAL.get(i).getRed(), imageColourAL.get(i).getGreen(), imageColourAL.get(i).getBlue(), null);
			tileH = tileHSB[0];
			tileS = tileHSB[1];
			tileB = tileHSB[2];
			// Calculate distance for mosaic from current tile.
			newTile = Math.pow((Math.pow((mosaicH - tileH), 2) + Math.pow((mosaicS - tileS), 2) + Math.pow((mosaicB - tileB), 2)), 0.5);
			// Compare the new tile to the current best tile, if new tile is
			// less, make it the current best and store the location in array.
			if (newTile < currentBestTile) {
				currentBestTile = newTile;
				bestTile = i;
			}
		}
		// return location of best tile in array.
		return bestTile;
	}

}
