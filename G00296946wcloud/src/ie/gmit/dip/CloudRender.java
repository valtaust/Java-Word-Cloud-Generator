package ie.gmit.dip;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

/**
 * @author Valery Taustsiakou
 * @Class CloudRender implements PaintInterface
 */

public class CloudRender implements PaintInterface {

	/**
	 * @method paint()
	 * @return void
	 * @throws IOException
	 * 
	 * paint() method returns a png image from a try-catch block after String is graphed.
	 * Hashmap is converted to a string.
	 */
	public static void paint() throws IOException {
		
		//PaintInterface cf = new CloudRenderFile();
		String cldSpk = FileParser.hmap.toString();
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62); // 62 is size of brush

		BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_4BYTE_ABGR);

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
			ImageIO.write(image, "png", new File(".\\paintFileTest.png")); //write in filename to overwrite or create
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


