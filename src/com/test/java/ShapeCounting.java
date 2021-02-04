package com.test.java;
public class ShapeCounting {

    public static void main(String args[]) {
        int[][] input1 = {{1,1,1},
                {0,1,0},
                {0,1,0}
        };

        int[][] input2 = {{0,1,0}
        };

        int[][] input3 = {{0,0,0}
        };

        int[][] input4 = {{}
        };

        int[][] input5 = null;

        int[][] input6 = {{1,1,1,0},
                {0,1,0,1},
                {0,1,0,0},
                {1,1,0,0},
        };

        ShapeCounting sc = new ShapeCounting();

        System.out.println("Input 1 count:"+ sc.countShapes(input1));

        System.out.println("Input 2 count:"+sc.countShapes(input2));

        System.out.println("Input 3 count:"+sc.countShapes(input3));

        System.out.println("Input 4 count:"+sc.countShapes(input4));

        System.out.println("Input 5 count:"+sc.countShapes(input5));

        System.out.println("Input 6 count:"+sc.countShapes(input6));
    }

    /**
     * Count number of shapes
     * @param input input array
     * @return count
     */
    public int countShapes(int[][] input) {

        // check for corner cases
        if (input == null || input.length == 0) return 0;

        int count = 0;
        for(int row =0; row <input.length; row++) {
            for(int col=0; col<input[0].length; col++) {
                if(input[row][col]!=0){
                    count++;
                    checkNeighbors(input, row, col);
                }
            }
        }
        return count;
    }


    /**
     *
     * @param input array
     * @param row row index
     * @param col column index
     */
    private void checkNeighbors(int[][] input, int row, int col) {

        // exit condition
        if (row < 0 || row >= input.length || col < 0 || col >= input[0].length || input[row][col] == 0) return;

        // mark the node as visited
        input[row][col] = 0;

        checkNeighbors(input, row + 1, col); // right adjacent neighbor
        checkNeighbors(input, row - 1, col); // left adjacent neighbor
        checkNeighbors(input, row, col - 1); // top adjacent neighbor
        checkNeighbors(input, row, col + 1); // bottom adjacent neighbor
    }
}
