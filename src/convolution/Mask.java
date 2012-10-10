package convolution;

public class Mask {

	private double[][] theMask;
	private double bias;

	@SuppressWarnings("unused")
	public Mask() {
		// Sharpening mask
		double[][] sharp = { { 0d, -1d, 0d },
							 { -1d, 5d, -1d },
							 { 0d, -1d, 0d } };
		double sharpBias = 0.0d;

		// Blur mask
		double[][] blur = { { 1d / 16d, 2d / 16d, 1d / 16d },
							{ 2d / 16d, 4d / 16d, 2d / 16d },
							{ 1d / 16d, 2d / 16d, 1d / 16d } };
		double blurBias = 0.0d;

		// Emboss mask -- needs to add 128 to all resulting values
		double[][] emboss = { { -1d, -1d,  0d },
							  { -1d,  0d,  1d },
							  {  0d,  1d,  1d } };
		double embossBias = 128.0d;


		// Pick the mask/bias we want to use
		theMask = emboss;
		bias = embossBias;
	}

	public int getWidth() {
		return theMask.length;
	}

	public int getHeight() {
		return theMask.length;
	}

	public double getBias() {
		return bias;
	}

	public double getValue(int x, int y) {
		return theMask[x][y];
	}
}