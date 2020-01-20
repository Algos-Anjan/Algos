package twoeggproblem;

import java.util.Arrays;

public class EggDroppingProblem {

    private int[][] dpTable = new int[Constants.NUM_OF_EGGS+1][Constants.NUM_OF_FLOORS+1];

    public int solve(){
        dpTable[0][0] = 0;
        dpTable[1][0] = 0;

        for ( int j=1; j<=Constants.NUM_OF_FLOORS ; j++){
            dpTable[1][j] =j;
        }
        //System.out.println(Arrays.deepToString(dpTable));

        for (int n=2 ; n <= Constants.NUM_OF_EGGS ; n++){
            for( int m=1 ; m <= Constants.NUM_OF_FLOORS ; m++){

                dpTable[n][m] = Integer.MAX_VALUE;
                for ( int x = 1; x <= m ; x++){

                    int maxDrops = 1 + Math.max(dpTable[n-1][x-1], dpTable[n][m-x]);

                    if (maxDrops < dpTable[n][m]){
                        dpTable[n][m] = maxDrops;
                    }
                }


            }
        }


        System.out.println(Arrays.toString(dpTable[2]));

       return dpTable[Constants.NUM_OF_EGGS][Constants.NUM_OF_FLOORS]; 
    }

}
