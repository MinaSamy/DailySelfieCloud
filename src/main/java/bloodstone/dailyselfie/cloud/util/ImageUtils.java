package bloodstone.dailyselfie.cloud.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static File applyTint(File file, int adjustmentValue) throws IOException {
		BufferedImage image = ImageIO.read(file);
		BufferedImage tint = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

		int r, g, b;
		Color c;
		Color tintColor;
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				c = new Color(image.getRGB(i, j));
				r = c.getRed();
				g = c.getGreen() + adjustmentValue;
				b = c.getBlue()-adjustmentValue;
				if (g > 255)
					g = 255;
				if(b<0)
					b=0;
				tintColor = new Color(r, g, b);
				tint.setRGB(i, j, tintColor.getRGB());
			}
		}
		File imageFile = new File(file.getName() + "mod.jpg");
		ImageIO.write(tint, "JPEG", imageFile);
		return imageFile;
	}

	public static File applyEffect(File file,int threshold) throws IOException {
		BufferedImage image = ImageIO.read(file);
		BufferedImage effectImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TRANSLUCENT);

		int r, g, b,gray;
		Color c,grayColor;
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				c = new Color(image.getRGB(i, j));
				r = c.getRed();
				g = c.getGreen();
				b = c.getBlue();
                gray=(int) (0.2989 * r + 0.5870 * g + 0.1140 * b);
                if (gray > threshold) 
                    gray = 255;
                else
                    gray = 0;
                grayColor = new Color(gray, gray, gray);
                effectImage.setRGB(i, j, grayColor.getRGB());
			}

		}
		
		File imageFile = new File(file.getName() + "mod.PNG");
		ImageIO.write(effectImage, "JPEG", imageFile);
		return imageFile;
	}
	
	public static File applyBlackWhiteEffect(File file,int threshold) throws IOException {
		BufferedImage image = ImageIO.read(file);
		BufferedImage effectImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

		int r, g, b,gray;
		Color c,grayColor;
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				c = new Color(image.getRGB(i, j));
				r = c.getRed();
				g = c.getGreen();
				b = c.getBlue();
                gray=(r+g+b)/3;
                
                grayColor = new Color(gray, gray, gray);
                effectImage.setRGB(i, j, grayColor.getRGB());
			}

		}
		
		File imageFile = new File(file.getName() + "mod.jpg");
		ImageIO.write(effectImage, "JPEG", imageFile);
		return imageFile;
	}
}
