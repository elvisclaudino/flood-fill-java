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


        FloodFiller<Integer> floodFiller = new FloodFiller<>(image);
        floodFiller.paint(14,0,2);


    }
}