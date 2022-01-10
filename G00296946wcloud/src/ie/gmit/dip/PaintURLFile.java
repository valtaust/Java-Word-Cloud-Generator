package ie.gmit.dip;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * @author valer
 *@class PaintURLFile implements PaintInterface
 *
 */
public class PaintURLFile implements PaintInterface {
	
	/**
	 * @method paintUrl()
	 * @throws IOException
	 * @trycatch output file .\\urlfilepaintTest.png
	 * 
	 */

	public static void paintUrl() throws IOException {
		String cldSpk = URLParser.hmap.toString();
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62); // 62 is size of brush

		BufferedImage image = new BufferedImage(3000, 3000, BufferedImage.TYPE_4BYTE_ABGR);

		Graphics graphics = image.getGraphics();
		font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
		graphics.setColor(Color.red);
		graphics.setFont(font);
		graphics.drawString(cldSpk, 0, 100);

		font = new Font(Font.SANS_SERIF, Font.ITALIC, 100);
		graphics.setFont(font);
		graphics.setColor(Color.yellow);
		graphics.drawString(cldSpk, 10, 150); // input as a parameter

		font = new Font(Font.MONOSPACED, Font.PLAIN, 100);
		graphics.setFont(font);
		graphics.setColor(Color.blue);
		graphics.drawString(cldSpk, 40, 180);

		graphics.dispose();
		try {
			ImageIO.write(image, "png", new File(".\\urlfilepaintTest.png")); // write in filename to overwrite or create
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
