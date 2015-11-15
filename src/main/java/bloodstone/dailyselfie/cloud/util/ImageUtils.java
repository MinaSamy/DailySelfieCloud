package bloodstone.dailyselfie.cloud.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static File applyTint(File file,int adjustmentValue) throws IOException{
		BufferedImage image=ImageIO.read(file);
		BufferedImage tint=new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TRANSLUCENT);
		
		int r,g,b;
		Color c;
		Color tintColor;
		for(int i=0;i<image.getWidth();i++){
			for(int j=0;j<image.getHeight();j++){
				c=new Color(image.getRGB(i, j));
				r=c.getRed();
				g=c.getGreen()+adjustmentValue;
				b=c.getBlue();
				if(g>255)
					g=255;
				tintColor=new Color(r, g, b);
				tint.setRGB(i,j, tintColor.getRGB());
			}
		}
		File imageFile=new File(file.getName()+"mod.jpg");
		boolean result=ImageIO.write(tint, "JPEG",imageFile);
		return imageFile;
	}
}
