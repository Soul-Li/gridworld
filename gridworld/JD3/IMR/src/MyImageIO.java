import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.*;

import javax.imageio.ImageIO;

import imagereader.IImageIO;


public class MyImageIO implements IImageIO {
	private static final int WS = 18;
	private static final int HS = 22;
	private static final int BS = 28;
	private static final int IS = 34;
	private static final int THREE = 3;
	private static final int EIGHT = 8;
	private static final int TWENTYFOUR = 24;
	private static final int PS = 54;
	private static final int FF = 0xff;
	@Override
	public Image myRead(String filePath) throws IOException {
		// TODO Auto-generated method stub
		
		//get the byte array from the stream
		File file = new File(filePath);
		FileInputStream in = new FileInputStream(file);
		byte[] bt = new byte[in.available()];
		in.read(bt);
		
		/**read the bitmap to obtain the width, height, bitCount
		 * and imageSize of this image. 
		 */
		int width = byte2int(bt, WS, WS+THREE);
		int height = byte2int(bt, HS, HS+THREE);
		int bitCount = byte2int(bt, BS, BS+1);
		int imageSize = byte2int(bt, IS, IS+THREE);
		
		/**get the fill bit of image.
		 * default three bytes for one pixel(bitCount = 24)
		 * other situation:  bitCount
		 *                      1        8 pixels 1 byte
		 *                      4        2 pixels 1 byte
		 *                      8        1 pixel  1 byte
		 *                      24       1 pixel  3 bytes
		 */
		int fill = 0;
		if (bitCount == 1) {
			fill = ((imageSize / height) - width / EIGHT);
		}
		if (bitCount == 4) {
			fill = ((imageSize / height) - width * 2 / EIGHT);
		}
		if (bitCount == EIGHT) {
			fill = ((imageSize / height) - width);
		}
		if (bitCount == TWENTYFOUR) {
			fill = ((imageSize / height) - width * THREE);
		}
		
		int[] pix = new int[height* width];
		int pos = PS;
		for (int row = height-1; row >= 0; row--) {
			for (int col = 0; col < width; col++) {
				//three bytes for one pixel
				pix[row*width + col] = (int)( FF << (EIGHT * THREE) |((bt[pos+2] & FF) << (2*EIGHT)) | 
						((bt[pos+1] & FF) << EIGHT) |( bt[pos] & FF));
				pos += THREE;
			}
			//fill the empty if needed
			pos += fill;
		}
		//use ImageProducer to create image
		Image image = Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(width, height, pix, 0 , width));
		return image;
	}

	@Override
	public Image myWrite(Image image, String filePath) {
		// TODO Auto-generated method stub
		try {
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			File imageFile = new File(filePath);
			BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
			Graphics bg = bufImage.getGraphics();
			bg.drawImage(image, 0, 0, null);
			ImageIO.write(bufImage, "bmp", imageFile);
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
    private int byte2int(byte[] t, int start, int end) {
    	int num = 0;
    	for (int i = end ; i >= start; i--) {
    		num += ((int)t[i] & FF) << (EIGHT*(i-start));
    	}
    	return num;
    }
}
