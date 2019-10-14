
package numberrecognitionnn;


import java.awt.*;
import java.awt.image.BufferedImage;


public class EditImg {

    public static BufferedImage setTransparency(BufferedImage src) {
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        BufferedImage dst = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dst.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));        
        g.drawRenderedImage(createBufferedImage(src), null);
        g.dispose();
       return dst;
    }

        private static BufferedImage createBufferedImage(Image image) {
        if(image instanceof BufferedImage)
            return (BufferedImage)image;
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bi;
    }

}


