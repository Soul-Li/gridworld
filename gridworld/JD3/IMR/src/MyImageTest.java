import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import org.junit.Before;
import org.junit.Test;


public class MyImageTest {

	@Before
	public void setUp() throws Exception {
	}
    
	@Test
	public void testMyRead() throws IOException {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/1.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/1.bmp");
		BufferedImage test = new BufferedImage(image.getWidth(null),
				image.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
		
		assertEquals(right.getWidth(null), image.getWidth(null));
		assertEquals(right.getHeight(null), image.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
	}

	@Test
	public void testRed() throws Exception {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/goal/1_red_goal.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/1.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Image red = mip.showChanelR(image);
		BufferedImage test = new BufferedImage(red.getWidth(null),
				red.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(red, 0, 0, red.getWidth(null), red.getHeight(null), null);
		
		assertEquals(right.getWidth(null), red.getWidth(null));
		assertEquals(right.getHeight(null), red.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
		myImageIO.myWrite(red, "/home/Administrator/Desktop/bmptest/result/1_red_result.bmp");
	}
    
	@Test
	public void testGreen() throws Exception {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/goal/1_green_goal.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/1.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Image green = mip.showChanelG(image);
		BufferedImage test = new BufferedImage(green.getWidth(null),
				green.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(green, 0, 0, green.getWidth(null), green.getHeight(null), null);
		
		assertEquals(right.getWidth(null), green.getWidth(null));
		assertEquals(right.getHeight(null), green.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
		myImageIO.myWrite(green, "/home/Administrator/Desktop/bmptest/result/1_green_result.bmp");
	}
	
	@Test
	public void testBlue() throws Exception {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/goal/1_blue_goal.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/1.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Image blue = mip.showChanelB(image);
		BufferedImage test = new BufferedImage(blue.getWidth(null),
				blue.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(blue, 0, 0, blue.getWidth(null), blue.getHeight(null), null);
		
		assertEquals(right.getWidth(null), blue.getWidth(null));
		assertEquals(right.getHeight(null), blue.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
		myImageIO.myWrite(blue, "/home/Administrator/Desktop/bmptest/result/1_blue_result.bmp");
	}
	
	@Test
	public void testGray() throws Exception {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/goal/1_gray_goal.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/1.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Image gray = mip.showGray(image);
		BufferedImage test = new BufferedImage(gray.getWidth(null),
				gray.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(gray, 0, 0, gray.getWidth(null), gray.getHeight(null), null);
		
		assertEquals(right.getWidth(null), gray.getWidth(null));
		assertEquals(right.getHeight(null), gray.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
		myImageIO.myWrite(gray, "/home/Administrator/Desktop/bmptest/result/1_gray_result.bmp");
	}
	
	@Test
	public void testRed2() throws Exception {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/goal/2_red_goal.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/2.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Image red = mip.showChanelR(image);
		BufferedImage test = new BufferedImage(red.getWidth(null),
				red.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(red, 0, 0, red.getWidth(null), red.getHeight(null), null);
		
		assertEquals(right.getWidth(null), red.getWidth(null));
		assertEquals(right.getHeight(null), red.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
		myImageIO.myWrite(red, "/home/Administrator/Desktop/bmptest/result/2_red_result.bmp");
	}
    
	@Test
	public void testGreen2() throws Exception {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/goal/2_green_goal.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/2.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Image green = mip.showChanelG(image);
		BufferedImage test = new BufferedImage(green.getWidth(null),
				green.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(green, 0, 0, green.getWidth(null), green.getHeight(null), null);
		
		assertEquals(right.getWidth(null), green.getWidth(null));
		assertEquals(right.getHeight(null), green.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
		myImageIO.myWrite(green, "/home/Administrator/Desktop/bmptest/result/2_green_result.bmp");
	}
	
	@Test
	public void testBlue2() throws Exception {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/goal/2_blue_goal.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/2.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Image blue = mip.showChanelB(image);
		BufferedImage test = new BufferedImage(blue.getWidth(null),
				blue.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(blue, 0, 0, blue.getWidth(null), blue.getHeight(null), null);
		
		assertEquals(right.getWidth(null), blue.getWidth(null));
		assertEquals(right.getHeight(null), blue.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
		myImageIO.myWrite(blue, "/home/Administrator/Desktop/bmptest/result/2_blue_result.bmp");
	}
	
	@Test
	public void testGray2() throws Exception {
		FileInputStream fis = new FileInputStream("/home/Administrator/Desktop/bmptest/goal/2_gray_goal.bmp");
		BufferedImage right = ImageIO.read(fis);
		MyImageIO myImageIO = new MyImageIO();
		Image image = myImageIO.myRead("/home/Administrator/Desktop/bmptest/2.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Image gray = mip.showGray(image);
		BufferedImage test = new BufferedImage(gray.getWidth(null),
				gray.getHeight(null),BufferedImage.TYPE_INT_BGR);
		test.getGraphics().drawImage(gray, 0, 0, gray.getWidth(null), gray.getHeight(null), null);
		
		assertEquals(right.getWidth(null), gray.getWidth(null));
		assertEquals(right.getHeight(null), gray.getHeight(null));
		for (int i = 0; i < right.getWidth(null); i++) {
			for (int j = 0; j < right.getHeight(null); j++) {
				assertEquals(right.getRGB(i, j), test.getRGB(i, j));
			}
		}
		myImageIO.myWrite(gray, "/home/Administrator/Desktop/bmptest/result/2_gray_result.bmp");
	}
	
}
