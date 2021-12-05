import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Get All the numbers to be called
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = sc.nextInt();
        }
        // Get all of the boards
        ArrayList<int[][]> all = new ArrayList<>();
        for (int k = 0; k < 100; k++) {
            int[][] grid = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            all.add(grid);
            sc.nextLine();
        }
        // Call every number and check every board
        // If board is won then gives answer
        for (int i = 0; i < nums.length; i++) {
            int call = nums[i];
            for (int j = 0; j < all.size(); j++) {
                int[][] grid = all.get(i);
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (grid[k][l] == call) {
                            grid[k][l] = 0;
                        }
                    }
                }
                int ans = check(grid);
                if (ans != 0) {
                    System.out.println(ans);
                    break;
                }
                all.set(i, grid);
                //System.out.println(Arrays.deepToString(grid));
            }
        }
        System.out.println("None");
    }
    
    public static int check(int[][] grid) {
        for (int k = 0; k < 5; k++) {
            if (grid[k][0] == 0) {
                boolean fail = false;
                for (int i = 0; i < 5; i++) {
                    if (!fail) {
                        if (grid[k][i] == 0);
                        else {
                            fail = true;
                        }
                    }
                }
                if (!fail) {
                    int sum = 0;
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            sum += grid[i][j];
                        }
                    }
                    return sum;
                }
            }
            if (grid[0][k] == 0) {
                boolean fail = false;
                for (int i = 0; i < 5; i++) {
                    if (!fail) {
                        if (grid[i][k] == 0);
                        else {
                            fail = true;
                        }
                    }
                }
                if (!fail) {
                    int sum = 0;
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            sum += grid[i][j];
                        }
                    }
                    return sum;
                }
            }
        }
        return 0;
    }
}
