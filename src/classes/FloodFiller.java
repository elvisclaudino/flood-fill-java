package classes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@SuppressWarnings("ALL")
public class FloodFiller {

    private int[][] matrixOrigin;
    private int[][] currentMatrix;

    private Queue<Coordinate> queue = new Queue<>();
    private Stack<Coordinate> stack = new Stack<>();
    private List<String> frames = new List<>();

    private String outputPath;
    private BufferedImage inputImage;
    private BufferedImage outputImage;
    private boolean onlyResultImage;

    public FloodFiller(int[][] matrixOrigin) {
        this.matrixOrigin = matrixOrigin;
    }

    public FloodFiller(String inputPath, String outputPath) throws IOException {
        this.inputImage = ImageIO.read(new File(inputPath));
        this.outputImage = ImageIO.read(new File(inputPath));
        this.outputPath = outputPath;
    }

    private void createGIF() {
        // frames.forEach((frame, index) -> {
        //     String gifPath = outputPath.replace(".png", index + ".png");
        //     try {
        //         ImageIO.write(frame, "jpg", new File(gifPath));
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // });
    }

    private int[][] matrix() {
        return  currentMatrix == null ? matrixOrigin : currentMatrix;
    }

    protected void matrix(int x, int y, int value) {
        matrix()[x][y] = value;
    }

    public void printImage() {
        System.out.println("{");
        for (int x = 0; x < matrix().length; x++) {System.out.print(" { ");
            for (int y = 0; y < matrix()[x].length; y++) System.out.print(matrix()[x][y] + (y < matrix()[x].length - 1 ? ", " : ""));
            System.out.println(" }" + (x < matrix()[x].length - 1 ? ", " : ""));
        }
        System.out.println("}");
    }

    public void paint(int x, int y, int value) throws Exception { paint(x, y, value, false);}
    public void paint(int x, int y, int value, boolean onlyResultImage) throws Exception {
        Coordinate coord = new Coordinate(x, y);
        this.onlyResultImage = onlyResultImage;
        if (matrix() != null) {
            if (coord.getX() < matrix().length && coord.getY() < matrix()[coord.getX()].length) {
                printImage();
                int toFind = matrix()[coord.getX()][coord.getY()];
                stack.add(coord);
                fill(toFind, value);
                printImage();
            } else throw new Exception("Coordenada inválida!");
        } else {
            if (coord.getY() < inputImage.getHeight() && coord.getX() < inputImage.getWidth()) {
                int toFind = inputImage.getRGB(coord.getX(),coord.getY());
                stack.add(coord);
                

                fill(toFind, value);
                
            } else throw new Exception("Coordenada inválida!");

            if (inputImage != null && onlyResultImage) {
                createFile(outputImage);                
            }
        }
    }

    private void createFile(BufferedImage image) throws IOException  {
        String randName = "output-image_"+ new Random(LocalDateTime.now().getNano()).hashCode() + ".png";
        frames.add(randName);
        File outputFile = new File("src/resources/" + randName);
        ImageIO.write(image, "png", outputFile);
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    private int counter = 0;
    private void fill(int find, int replace) throws Exception {
        if (stack.isEmpty()) {
            return;
        }

        Coordinate coordinate = stack.remove();

        if (matrix() != null) {
            matrix()[coordinate.getX()][coordinate.getY()] = replace;
        } else if (outputImage != null) {
            outputImage.setRGB(coordinate.getX(), coordinate.getY(), replace);
            if (++counter % 10 == 0 && !this.onlyResultImage) {
                createFile(outputImage);
            }
        }


        if (!checkY(coordinate.clone(), find) && !checkX(coordinate.clone(), find) && stack.isEmpty()) {
            return;
        }

        fill(find, replace);
    }

    private boolean checkX(Coordinate coordinate, int find) {
        boolean found = true;

        coordinate = new Coordinate(coordinate.getX() + 1, coordinate.getY());
        if (checkRight(coordinate)) {
            if (matrix() != null && matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else if (outputImage != null && outputImage.getRGB(coordinate.getX(), coordinate.getY()) == find) {
                stack.add(coordinate);
            } else found = false;
        }

        coordinate = new Coordinate(coordinate.getX() - 2, coordinate.getY());
        if (checkLeft(coordinate)) {
            if (matrix() != null && matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else if (outputImage != null && outputImage.getRGB(coordinate.getX(), coordinate.getY()) == find) {
                stack.add(coordinate);
            } else found = false;
        }
        
        return found;
    }
    private boolean checkY(Coordinate coordinate, int find) {
        boolean found = true;

        coordinate = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
        if (checkTop(coordinate)) {
            if (matrix() != null && matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else if (outputImage != null && outputImage.getRGB(coordinate.getX(), coordinate.getY()) == find) {
                stack.add(coordinate);
            } else found = false;
        }
        
        coordinate = new Coordinate(coordinate.getX(), coordinate.getY() + 2);
        if (checkBottom(coordinate)) {
            if (matrix() != null && matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else if (outputImage != null && outputImage.getRGB(coordinate.getX(), coordinate.getY()) == find) {
                stack.add(coordinate);
            } else found = false;
        }
        
        
        return found;
    }

    private boolean checkTop(Coordinate coordinate) {
        return coordinate.getY() >= 0;
    }
    private boolean checkBottom(Coordinate coordinate) {
        return coordinate.getY() < (inputImage == null ? matrix().length : inputImage.getHeight());
    }
    private boolean checkRight(Coordinate coordinate) {
        return coordinate.getX() < (inputImage == null ? matrix()[coordinate.getX()].length : inputImage.getWidth());
    }
    private boolean checkLeft(Coordinate coordinate) {
        return coordinate.getX() >= 0;
    }

}