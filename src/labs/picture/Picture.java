package labs.picture;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width  the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /* Main method for testing - each class in Java can have a main
     * method
     */
    public static void main(String[] args)
    {
        Picture isaac = new Picture("src/labs/picture/res/640x480Isaac_Wide.JPG");
        Picture mars = new Picture("src/labs/picture/res/Curiosity.jpg");

        mars.explore();
        isaac.explore();
        mars.overlayImage(isaac);
        mars.explore();
        mars.greyscale();
        mars.explore();
    }

    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() +
                " height " + getHeight()
                + " width " + getWidth();
        return output;

    }

    /**
     * Method to set the blue to 0
     */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * Method to remove Red and Green values
     */
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixel : rowArray)
            {
                pixel.setGreen(0);
                pixel.setRed(0);
            }
        }
    }

    /**
     * Makes a negative of the picture
     */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixel : rowArray)
            {
                pixel.setRed(255 - pixel.getRed());
                pixel.setGreen(255 - pixel.getGreen());
                pixel.setBlue(255 - pixel.getBlue());
            }
        }
    }

    /**
     * Makes the picture a greyscale
     */
    public void greyscale()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixel : rowArray)
            {
                int avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                pixel.setRed(avg);
                pixel.setGreen(avg);
                pixel.setBlue(avg);
            }
        }
    }

    public void removeGreenScreen()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixel : rowArray)
            {
                if (pixel.getGreen() > pixel.getRed() + pixel.getBlue())
                {
                    pixel.setGreen(0);
                    pixel.setRed(0);
                    pixel.setBlue(0);
                }
            }
        }
    }

    public void overlayImage(Picture image)
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] imagePix = image.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                if (!imagePix[row][col].isGreen())
                {
                    pixels[row][col].setColor(imagePix[row][col].getColor());
                }
            }
        }
    }

    public void fixUnderwater(int redMultiplier)
    {
        int totalBlue = 0;
        int totalGreen = 0;
        int totalRed = 0;

        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixel : rowArray)
            {
                totalBlue += pixel.getBlue();
                totalGreen += pixel.getGreen();
                totalRed += pixel.getRed();
            }
        }

        int avgBlue = totalBlue / (pixels.length * pixels[0].length);
        int avgGreen = totalGreen / (pixels.length * pixels[0].length);
        int avgRed = totalRed / (pixels.length * pixels[0].length);

        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixel : rowArray)
            {
                pixel.setRed(pixel.getRed() - avgRed);
                pixel.setBlue(pixel.getBlue() - avgBlue);
                pixel.setGreen(pixel.getGreen() - avgGreen);
            }
        }
    }

    /**
     * Mirrors the image by copying the LEFT side TO the RIGHT side.
     */
    public void mirrorVerticalLeftToRight()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[row].length; col++)
            {
                pixels[row][pixels[row].length - 1 - col].setColor(pixels[row][col].getColor());
            }
        }
    }


    /**
     * Mirrors the image by copying the RIGHT side TO the LEFT side.
     */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[row].length; col++)
            {
                pixels[row][col].setColor(pixels[row][pixels[row].length - 1 - col].getColor());
            }
        }
    }

    public void mirrorHorizontalTopToBottom()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[row].length; col++)
            {
                pixels[pixels.length - 1 - row][col].setColor(pixels[row][col].getColor());
            }
        }
    }

    public void mirrorHorizontalBottomToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[row].length; col++)
            {
                pixels[row][col].setColor(pixels[pixels.length - 1 - row][col].getColor());
            }
        }
    }

    public void radialMirrorTopRight()
    {
        mirrorVerticalLeftToRight();
        mirrorHorizontalTopToBottom();
    }

    public void mirrorDiagonalSquare()
    {
        Pixel[][] pixels = this.getPixels2D();
        int squareSize;
        if (pixels.length > pixels[0].length)
        {
            squareSize = pixels[0].length;
        } else
        {
            squareSize = pixels.length;
        }

        for (int row = 0; row < squareSize; row++)
        {
            for (int col = 0; col < row; col++)
            {
                pixels[row][col].setColor(pixels[col][row].getColor());
            }
        }
    }


    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }

        System.out.println(count);
    }

    public void mirrorSnowman()
    {
        //155, 100 : 195, 170
        //165, 300 : 200, 235
        int mirrorPoint = 200;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 155; row < mirrorPoint; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 100; col < 170; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }

        for (int row = 165; row < mirrorPoint; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 235; col < 300; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }

    }

    public void mirrorGull()
    {
        int mirrorPoint = 347;
        Pixel leftPixel;
        Pixel rightPixel;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 227; row < 335; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 233; col < mirrorPoint; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     *
     * @param fromPic  the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic,
                     int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
             fromRow < fromPixels.length &&
                     toRow < toPixels.length;
             fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol;
                 fromCol < fromPixels[0].length &&
                         toCol < toPixels[0].length;
                 fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * Method to create a collage of several pictures
     */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVerticalLeftToRight();
        this.write("collage.jpg");
    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0;
                 col < pixels[0].length - 1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) >
                        edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

} // this } is the end of class Picture, put all new methods before this
