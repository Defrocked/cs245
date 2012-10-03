package mosaicAssignment1;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;

public class MosaicMaker {

	/*
	 * write the constructor and use the uwecimage scaling class
	 */

	private String tileFolder;
	private int horzMosaicSize;
	private int vertMosaicSize;
	private int horzNumTiles;
	private int vertNumTiles;
	private ArrayList<UWECImage> imageAL;
	private ArrayList<Color> imageColourAL;
	private int tileHeight;
	private int tileWidth;

	public MosaicMaker(String tileFolder, int horzMosaicSize,
			int vertMosaicSize, int horzNumTiles, int vertNumTiles) {
		this.tileFolder = tileFolder;
		this.horzMosaicSize = horzMosaicSize;
		this.vertMosaicSize = vertMosaicSize;
		this.horzNumTiles = horzNumTiles;
		this.vertNumTiles = vertNumTiles;
		Color aveTileColour;

		// use the file class to operate on tilefolder or someshit
		// scale everything to the correct size (use mosaic size v & h and
		// number of tiles to know
		// how big the images are going to have to be

		// creates a file object of the folder path
		File tileFiles = new File(tileFolder);

		// creates an array for files and an arraylist for images and image
		// colours
		String[] fileArray;
		this.imageAL = new ArrayList<UWECImage>();
		this.imageColourAL = new ArrayList<Color>();

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
			imageAL.add(fileToImage);  //THIS NEEDS TO BE OUR BUFFERED IMAGES ARRAYLIST FROM SCALEIMAGE
			imageColourAL.add(aveTileColour);
//			System.out.println(imageAL.size());
//			ImagePanel i1 = new ImagePanel(imageAL.get(1));

		}

	}

	/**
	 * takes the image to be mosaic'd and then splits it up into tile sized
	 * rectangles (10x10 in our case) get the average colour of each tile using
	 * uwecimage get the best tile for the colour using find best tile run
	 * through and colour in the rectangle with the best tile (nested loops --
	 * NOT uwecimage)
	 * 
	 * @param image
	 * @return
	 */
	public UWECImage createMosaic(UWECImage image) {
		int red;
		int green;
		int blue;
		// scales our mosaic image
		image.scaleImage(horzMosaicSize, vertMosaicSize);
		
		System.out.println(image.getHeight());
		System.out.println(image.getWidth());

		// create a new blank uwecimage
		UWECImage blankMosaic = new UWECImage(horzMosaicSize, vertMosaicSize);

		// makes an imagepanel so we can see wtf we are doing
		ImagePanel ima = new ImagePanel(blankMosaic);
		ImagePanel ima2 = new ImagePanel(image);

		// LOOPAN increment by 10x10 since that is the size of our squares?
		for (int i = 0; i < blankMosaic.getWidth(); i +=tileWidth) {
			for (int j = 0; j < blankMosaic.getHeight(); j += tileHeight) {
				// set the avecolour to for 10x10 squares
				Color aveColour = image.averageImageColor(i, j, tileWidth,
						tileHeight);
				
//				System.out.println(i);
//				System.out.println(j);

				// find the best tile for the average colour
				UWECImage bestTile;
				bestTile = imageAL.get(findBestTile(aveColour));

				// loop to copy the pixels of the best tile to the rectangle of
				// our mosaic
				for (int k = 0; k < tileWidth; k++) {
					for (int l = 0; l < tileHeight; l++) {
						red = bestTile.getRed(k, l);
						green = bestTile.getGreen(k, l);
						blue = bestTile.getBlue(k, l);
						// puts the colour into the new image
						blankMosaic.setRGB(k, l, red, green, blue);
						//blankMosaic.setRGB(k,l,50,70,80);
//						System.out.println(findBestTile(aveColour));
						
						
						ima.repaint();

					}
				}
			}
		}

		return image;
	}
	
	// Find the tile with the best match to the mosaic.
		public int findBestTile(Color mosaicColor) {
			// int to hold location in array of the best tile.
			int bestTile = 0;
			// double to hold the distance of the currently best tile; starts at 100000 to make sure will be larger than distance.
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
			// for loop to check the distance for every  tile.
			for (int i = 0; i < imageColourAL.size() ; i++) {
				// set the tile RGB to HSB conversion and convert to doubles.
				tileHSB = Color.RGBtoHSB(imageColourAL.get(i).getRed(), imageColourAL.get(i).getGreen(), imageColourAL.get(i).getBlue(), null);
				tileH = tileHSB[0];
				tileS = tileHSB[1];
				tileB = tileHSB[2];
				// Calculate distance for mosaic from current tile.
				newTile = Math.pow(( Math.pow((mosaicH - tileH), 2) + Math.pow((mosaicS - tileS), 2) + Math.pow((mosaicB - tileB), 2) ), 0.5);
				// Compare the new tile to the current best tile, if new tile is less, make it the current best and store the location in array.
				if (newTile < currentBestTile) {
					currentBestTile = newTile;
					bestTile = i;
				}
			}
			// return location of best tile in array.
			return bestTile; 
		}

}
