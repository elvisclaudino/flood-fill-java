import classes.*;

import java.awt.*;

public class Main {

    static int[][] image = {
            {0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,8,0,0,0},
            {1,0,0,0,0,0,0,0,0,0},
    };

    static final Color color = new Color(70,30,155);

    public static void main(String[] args) throws Exception {


        // FloodFiller floodFiller = new FloodFiller(image);
        // floodFiller.paint(8,4,2);

        FloodFiller floodFiller = new FloodFiller("src/resources/input-image.png", "src/resources/output-image.png");
        floodFiller.paint(21,181, color.getRGB(), true);
        // floodFiller.paint(5,49, color.getRGB(), true);


    }
}