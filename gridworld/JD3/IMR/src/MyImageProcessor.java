import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

import imagereader.IImageProcessor;


public class MyImageProcessor implements IImageProcessor {
	private static final int REDFL = 0xffff0000;
	private static final int GREENFL = 0xff00ff00;
	private static final int BLUEFL = 0xff0000ff;
	private static final int RED = 0x00ff0000;
	private static final int GREEN = 0x0000ff00;
	private static final int BLUE = 0x000000ff;
	private static final int FF = 0xff000000;
	private static final double REDPT = 0.299;
	private static final double GREENPT = 0.587;
	private static final double BLUEPT = 0.114;
	//RedFilter
	class RedFilter extends RGBImageFilter {
		public RedFilter() {
			canFilterIndexColorModel = true;
		}

		@Override
		public int filterRGB(int x, int y, int rgb) {
			// TODO Auto-generated method stub
			return (rgb & REDFL);
		}	
	}
	//GreenFilter
	class GreenFilter extends RGBImageFilter {
		public GreenFilter() {
			canFilterIndexColorModel = true;
		}

		@Override
		public int filterRGB(int x, int y, int rgb) {
			// TODO Auto-generated method stub
			return (rgb & GREENFL);
		}	
	}
	//BlueFilter
	class BlueFilter extends RGBImageFilter {
		public BlueFilter() {
			canFilterIndexColorModel = true;
		}

		@Override
		public int filterRGB(int x, int y, int rgb) {
			// TODO Auto-generated method stub
			return (rgb & BLUEFL);
		}	
	}
	//GrayFilter
	class GrayFilter extends RGBImageFilter {
		public GrayFilter() {
			canFilterIndexColorModel = true;
		}

		@Override
		public int filterRGB(int x, int y, int rgb) {
			// TODO Auto-generated method stub
			int red = (rgb & RED) >> 16;
			int green = (rgb & GREEN) >> 8;
			int blue = (rgb & BLUE);
			int gray = (int)(Math.floor((double)(REDPT*red) + (double)(GREENPT*green) + (double)(BLUEPT*blue)));
			return ((rgb & FF) + (gray << 16) + (gray << 8) + gray);
		}
	}
	
	public Image showChanelR(Image sourceImage) {
		RedFilter red = new RedFilter();
		return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), red));
	}
	public Image showChanelG(Image sourceImage) {
		GreenFilter green = new GreenFilter();
		return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), green));
	}
	public Image showChanelB(Image sourceImage) {
		BlueFilter blue = new BlueFilter();
		return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), blue));
	}
	public Image showGray(Image sourceImage) {
		GrayFilter gray = new GrayFilter();
		return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(), gray));
	}
}
