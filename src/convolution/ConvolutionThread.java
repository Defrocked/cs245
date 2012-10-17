package convolution;

public class ConvolutionThread implements Runnable{

	private UWECImage in;
	private Mask m;
	private UWECImage out;
	private ImagePanel outPanel;
	private int threadNum;

	public ConvolutionThread(UWECImage in, Mask m, UWECImage out, ImagePanel outPanel, int threadNum){
		this.in = in;
		this.m = m;
		this.out = out;
		this.outPanel = outPanel;
		this.threadNum = threadNum;		
	}

	public void run() {

		int width = in.getWidth();
		int height = in.getHeight();
		int maskWidth = m.getWidth();
		int maskHeight = m.getHeight();
		
		int threadsSplit = 4;
		int startWidth = width/threadsSplit * threadNum;
		int endWidth = width/threadsSplit * (threadNum + 1);
		
		for (int x = startWidth; x < endWidth; x++) {			
			for (int y = 0; y < height; y++) {
				double redResult = 0, greenResult = 0, blueResult = 0;
				for (int u = 0; u < maskWidth; u++) {
					for (int v = 0; v < maskHeight; v++) {
						int xoffset = x + (u - (maskWidth / 2));
						int yoffset = y + (v - (maskHeight / 2));

						redResult += m.getValue(u, v) * in.getRed(xoffset, yoffset);
						greenResult += m.getValue(u, v) * in.getGreen(xoffset, yoffset);
						blueResult += m.getValue(u, v) * in.getBlue(xoffset, yoffset);
					}
				}
				helpful(x,y,redResult,greenResult,blueResult);
			}
		}
		
	}
	
	private void helpful(int x, int y, double redResult, double greenResult, double blueResult){
		// Add any bias required by the mask
		redResult += m.getBias();
		greenResult += m.getBias();
		blueResult += m.getBias();

		// Clamp the values
		if (redResult < 0) {
			redResult = 0;
		} else if (redResult > 255) {
			redResult = 255;
		}
		if (greenResult < 0) {
			greenResult = 0;
		} else if (greenResult > 255) {
			greenResult = 255;
		}
		if (blueResult < 0) {
			blueResult = 0;
		} else if (blueResult > 255) {
			blueResult = 255;
		}

		out.setRGB(x, y, (int) redResult, (int) greenResult, (int) blueResult);
		outPanel.repaint();
	}

}
