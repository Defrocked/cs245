package convolution;

public class Main {

	public static void main(String args[]) {
		// Get the original image

		UWECImage in = null;
		try {
			in = new UWECImage("mandrill.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Display the original image in a Panel
		@SuppressWarnings("unused")
		ImagePanel inPanel = new ImagePanel(in);

		// Make a mask
		Mask m = new Mask();

		// Make a new blank image the same size as the input image
		// to place the convolved image into
		UWECImage out = new UWECImage(in.getWidth(), in.getHeight());

		// Display the resulting image as it is created in a second panel
		ImagePanel outPanel = new ImagePanel(out);	

		// Convolve the original image with the mask
		Convolution.convolve(in, m, out, outPanel);

		out.write("mandrillConvolve.png");
	}
}