/**
 * Challenge 2 Pascal's Pyramid
 * Generates Pascal's Pyramid and displays a requested layer.
 *
 * @author Anathi Mudunuri, CS 18000 
 *
 * @version October 2, 2026
 *
 */

void main() {
    int layers = Integer.parseInt(IO.readln("Enter the number of layers:\n"));
    int[][][] pyramid = new int[layers][][];

    for (int layer = 0; layer < layers; layer++) {
        int rows = layer + 1;
        pyramid[layer] = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int cols = layer + 1 - row;
            pyramid[layer][row] = new int[cols];

            for (int col = 0; col < cols; col++) {
                if (layer == 0) {
                    pyramid[layer][row][col] = 1;
                } else {
                    int sum = 0;
                    if (row < layer && col < layer - row) {
                        sum += pyramid[layer - 1][row][col];
                    }
                    if (row > 0) {
                        sum += pyramid[layer - 1][row - 1][col];
                    }
                    if (col > 0) {
                        sum += pyramid[layer - 1][row][col - 1];
                    }
                    pyramid[layer][row][col] = sum;
                }
            }
        }
    }

    int display = Integer.parseInt(IO.readln("Enter the layer to display:\n"));
    IO.println("Layer " + display);

    for (int row = 0; row < pyramid[display].length; row++) {
        for (int col = 0; col < pyramid[display][row].length; col++) {
            IO.print(pyramid[display][row][col]);
            if (col < pyramid[display][row].length - 1) {
                IO.print(" ");
            }
        }
        IO.println();
    }

}
