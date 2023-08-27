package classes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;

@SuppressWarnings("ALL")
public class FloodFiller {

    private int[][] currentMatrix;
    private int[][] matrixOrigin;
    private BufferedImage originImage;
    private BufferedImage resultImage;

    private Queue<Coordinate> queue = new Queue<>();
    private Stack<Coordinate> stack = new Stack<>();

    public FloodFiller(int[][] matrixOrigin) {
        this.matrixOrigin = matrixOrigin;
    }

    public FloodFiller(String imagePath) throws IOException {

        originImage = ImageIO.read(new File(imagePath));
        resultImage = new BufferedImage(originImage.getWidth(), originImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        initMatrix();

        File outputFile = new File("resources/result.jpg");
        ImageIO.write(resultImage, "jpg", outputFile);
    }

    private void initMatrix() {
          
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

    public void paint(int x, int y, int value) throws Exception {
        System.arraycopy(matrixOrigin, 0, currentMatrix, matrixOrigin.length - 1, matrixOrigin.length);
        Coordinate coord = new Coordinate(x, y);
        printImage();
        int toFind = matrix()[coord.getX()][coord.getY()];
        stack.add(coord);
        fill(toFind, value);
        printImage();
    }
    private void fill(int find, int replace) throws Exception {
        if (stack.isEmpty()) {
            return;
        }

        Coordinate coordinate = stack.remove();
        if (coordinate.getX() < matrix().length && coordinate.getY() < matrix()[coordinate.getX()].length) {
            matrix()[coordinate.getX()][coordinate.getY()] = replace;

            if (!checkY(coordinate.clone(), find) && !checkX(coordinate.clone(), find) && stack.isEmpty()) return;

            fill(find, replace);

        } else throw new Exception("Coordenada inválida!");
    }

    private boolean checkX(Coordinate coordinate, int find) {
        boolean found = true;

        coordinate.setX(coordinate.getX() + 1);
        if (checkBottom(coordinate)) {
            if (matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else found = false;
        }

        coordinate.setX(coordinate.getX() - 2);
        if (checkTop(coordinate)) {
            if (matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else found = false;
        }

        return found;
    }
    private boolean checkY(Coordinate coordinate, int find) {
        boolean found = true;

        coordinate.setY(coordinate.getY() - 1);
        if (checkLeft(coordinate)) {
            if (matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else found = false;
        }

        coordinate.setY(coordinate.getY() + 2);
        if (checkRight(coordinate)) {
            if (matrix()[coordinate.getX()][coordinate.getY()] == find) {
                stack.add(coordinate);
            } else found = false;
        }
        return found;
    }
    private boolean checkTop(Coordinate coordinate) {
        return coordinate.getX() >= 0;
    }
    private boolean checkBottom(Coordinate coordinate) {
        return coordinate.getX() < matrix().length;
    }
    private boolean checkRight(Coordinate coordinate) {
        return coordinate.getY() < matrix()[coordinate.getX()].length;
    }
    private boolean checkLeft(Coordinate coordinate) {
        return coordinate.getY() >= 0;
    }

}