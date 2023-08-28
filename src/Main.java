import classes.*;

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
            {0,1,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0},
    };

    public static void main(String[] args) throws Exception {


        // FloodFiller floodFiller = new FloodFiller(image);
        // floodFiller.paint(5,0,2);

        FloodFiller floodFiller = new FloodFiller("src/resources/input-image.jpg", "src/resources/output-image.jpg");
        floodFiller.paint(0,0,255);



    }
}