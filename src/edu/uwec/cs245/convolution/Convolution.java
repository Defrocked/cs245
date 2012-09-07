package edu.uwec.cs245.convolution;


public class Convolution{

	public static UWECImage convolve(UWECImage in, Mask m, UWECImage out, ImagePanel outPanel) {
		ConvolutionThread[] cts = new ConvolutionThread[4];
		Thread[] ts = new Thread[4];
		
		for (int i=0; i<4; i++) {
			cts[i] = new ConvolutionThread(in, m, out, outPanel, i);
			ts[i] = new Thread(cts[i]);
			ts[i].start();
		}
		
		for (int i=0; i<4; i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return out;
	}
}