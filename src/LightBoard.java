import java.util.Random;

public class LightBoard {
    private boolean[][] lights;

    public boolean[][] getLights() {
        return lights;
    }

    public void setLights(boolean[][] lights) {
        this.lights = lights;
    }

    public LightBoard(int numRows, int numCols) {
        Random rand = new Random();
        lights = new boolean[numRows][numCols];
        for (int y = 0;y<numRows; y++) {

            for (int x = 0; x < numCols; x++) {
                int rand_int = rand.nextInt(10);
                if(rand_int<=3){
                    lights [y][x] = true;
                }
            }
        }
    }

    /*
    {true, true, false, true, true},
    {true, false, false, true, false},
    {true, false, false, true, true},
    {true, false, false, false, true},
    {true, false, false, false, true},
    {true, true, false, true, true},
    {false, false, false, false, false}
     */
    public boolean evaluateLight(int row, int col) {
        if(lights.length == 0){
            return false;
        }
        if(lights[row][col] == true){
            int count = 0;
            for (int y = 0; y<lights.length; y++){
                if(lights[y][col] == true){
                    count ++;
                }
            }
            if(count%2==0){
                return false;
            }

        }
        else{
            int count = 0;
            for (int y = 0; y<lights.length; y++){
                if(lights[y][col] == true) {
                    count++;
                }
            }
            if(count%3==0){
                return true;
            }
        }
        return lights[row][col];
    }
}
