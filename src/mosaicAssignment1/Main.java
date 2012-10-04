package mosaicAssignment1;

public class Main {
	public static void main(String[] args) {
		// Define the names of the files/folders and the number of tiles to use
		// in the mosaic
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
		// Form a mosaic of the original image
		UWECImage mosaicImage = mm.createMosaic(originalImage);
		// Write out the mosaic version
		ImagePanel ima = new ImagePanel(mosaicImage);
		ima.repaint();
		mosaicImage.write(mosaicFilename);
		// At this point we could mosaic another image to the same size as the
		// one above if we wished...
		
		System.out.println("Finished");
	}
}