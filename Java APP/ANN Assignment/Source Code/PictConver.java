package numberrecognitionnn;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.Image.*;


public class PictConver extends JFrame {

    protected PictConver() {
        pixels = new boolean[8][8];
    }

    public static PictConver getInstance() {
        if (instance == null) {
            instance = new PictConver();
        }
        return instance;
    }

    protected void Max_Min(int x, int y) {
        this.y = y;
        this.x = x;
        Update_MaxMin();
    }

    private void Update_MaxMin() {
        if (Min_X > x) {
            Min_X = x;
        }
        if (Min_Y > y) {
            Min_Y = y;
        }

        if (Max_X < x) {
            Max_X = x;
        }

        if (Max_Y < y) {
            Max_Y = y;
        }
    }

    public void resetNums() {
        Min_X = 200;
        Max_X = 0;
        Min_Y = 200;
        Max_Y = 0;
    }

    private void cropimage() {
        Min_Y = Min_Y - 4;
        Min_X = Min_X - 4;
        Max_X = Max_X + 4;
        Max_Y = Max_Y + 4;
        int width = (Max_X - Min_X);
        int height = (Max_Y - Min_Y);

        try {

            BufferedImage bi = null;
            ImageFilter crop_filter = null;

            Toolkit myToolkit = Toolkit.getDefaultToolkit();

            BufferedImage input_image = Scribble.BuffImg;

            ImageProducer pd = input_image.getSource();

            if (width > height) {
                int diff = (width - height);
                diff = diff / 2;

                crop_filter = new CropImageFilter(Min_X, Min_Y - diff, width, width);
            } else {
                int diff = (height - width);
                diff = diff / 2;

                crop_filter = new CropImageFilter(Min_X - diff, Min_Y, height, height);
            }

            Image output_image = myToolkit.createImage(new FilteredImageSource(pd, crop_filter));

            if (width > height) {
                bi = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
            } else {
                bi = new BufferedImage(height, height, BufferedImage.TYPE_INT_ARGB);
            }

            Graphics2D biContext = bi.createGraphics();
            biContext.drawImage(output_image, 0, 0, null);


            height = bi.getHeight();

            bi = enlarge(bi, (180 / height));
            Image = bi;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private BufferedImage enlarge(BufferedImage image, double ratio) {

        int w = (int) Math.round(ratio * image.getWidth());
        int h = (int) Math.round(ratio * image.getHeight());

        int width = checkratio(w);

        int n = (int) Math.round(ratio);

        BufferedImage enlargedImage = new BufferedImage(width, width, image.getType());

        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                enlargedImage.setRGB(x, y, image.getRGB(x / n, y / n));
            }
        }

        return enlargedImage;
    }

    private int checkratio(int w) {
        int x = w;
        if ((w % 7) != 0) {
            w = (w / 7);
            w = (w * 7);
        }

        if (w < x) {
            w = w + 7;
        }

        return w;
    }

    private boolean[] extractPix() {

        BufferedImage input_image = null;
        try {
            input_image = EditImg.setTransparency(Image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int width = Image.getWidth();
        int height = Image.getHeight();
        Width = width;
        Height = height;
        int[] pixels = new int[width * height];
        boolean[] pxls = new boolean[width * height];
        PixelGrabber pg = new PixelGrabber(input_image, 0, 0, width, height, pixels, 0, width);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        for (int x = 0; x < (width * height); x++) {
            int c = pixels[x];
            int alpha = (c >> 24) & 0xff;
            int red = (c >> 16) & 0xff;

            if ((red == 255) || (red == 0)) {
                pxls[x] = false;
            } else {
                pxls[x] = true;
            }
        }
        return pxls;
    }

    private boolean[][] convert2d(boolean[] pixels) {
        int count = 0;
        boolean[][] pix = new boolean[Width][Height];
        for (int x = 0; x < Width; x++) {
            for (int y = 0; y < Height; y++) {
                pix[x][y] = pixels[count];
                count++;
            }
        }
        return pix;
    }

    private boolean[][] convert64(boolean[][] pixels) {
        int n = (Width / 7);
        boolean[][] pix = new boolean[8][8];
        int X = 0;
        int Y = 0;

        for (int x = 1; x < Width + 1; x++) {
            if (((X + 1) * n == x)) {
                X++;
            }

            for (int y = 1; y < Height + 1; y++) {
                if ((Y + 1) * n == y) {
                    Y++;
                }


                if (pixels[x - 1][y - 1] == true) {
                    if (pix[X][Y] == false) {
                        pix[X][Y] = true;
                    }
                }
                
            }
            Y = 0;
        }
        return pix;
    }

    protected void convertimg() {
        cropimage();
        boolean[] pix = extractPix();
        boolean[][] pixs = convert2d(pix);
        pixels = convert64(pixs);
    }

    protected boolean getPix(int x, int y) {
        return pixels[x][y];
    }

    protected void clearpix() {
        pixels = new boolean[8][25];
    }

    protected double[] get_Vector() {
        int i = 0;
        double[] Vector = new double[64];

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (pixels[x][y] == true) {
                    Vector[i] = 1;
                } else {
                    Vector[i] = 0;
                }
                i++;
            }
        }
        return Vector;
    }
    
    private BufferedImage Image = null;
    private static PictConver instance = null;
    private boolean[][] pixels;
    protected int Max_Y,  Max_X,  Width,  Height;
    protected int Min_Y = 200;
    protected int Min_X = 200;
    private int x,  y;
}
