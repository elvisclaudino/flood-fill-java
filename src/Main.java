import classes.*;

public class Main {

    static Integer[][] image = {
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


        FloodFiller floodFiller = new FloodFiller(image);
        floodFiller.paint(5,0,2);


    }
}