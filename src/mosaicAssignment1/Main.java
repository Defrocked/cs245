package mosaicAssignment1;

public class Main {
	public static void main(String[] args) {
		// Define the names of the files/folders and the number of tiles to use
		// in the mosaic
		
		/*MIKEY
		 * DO UWECIMAGE SCALING
		 * AND MOSAICMAKER CONSTRUCTOR
		 *GAVIN
		 *DO UWECIMAGE AVERAGECOLOR
		 *AND OTHER PICTURE MUTATING THINGS 	
		 */
		String originalFilename = "NYCcentralPark.jpg";
		String mosaicFilename = "NYCmosaic.jpg";
		String tileFolder = "dvdReleases";
		int horzMosaicSize = 640;
		int vertMosaicSize = 480;
		int horzNumTiles = 64;
		int vertNumTiles = 48;
		// Load in the tiles, resize them, and compute their average colors
		MosaicMaker mm = new MosaicMaker(tileFolder, horzMosaicSize,
				vertMosaicSize, horzNumTiles, vertNumTiles);
		// Read the original file which we will turn into a mosaic
		UWECImage originalImage = new UWECImage(originalFilename);
		
//		//TESTS TO MAKE SURE THE ORIGINAL IMAGE IS IN THE RIGHT PLACE BY DISPLAYING IT
//		ImagePanel ima = new ImagePanel(originalImage);
	
		// Form a mosaic of the original image
		UWECImage mosaicImage = mm.createMosaic(originalImage);
		// Write out the mosaic version
		mosaicImage.write(mosaicFilename);
		// At this point we could mosaic another image to the same size as the
		// one above if we wished...
		System.out.println("Finished");
	}
}