package ArraysHashing;
// pramp practice problem
// traverse first row and first column doing a diagonal check on each
public class isToeplitz {
    static boolean isToeplitz(int[][] arr) {
        int firstCol = 0;
        int firstRow = 0;

        while(firstCol < arr[0].length){
            System.out.println(firstCol + ": 0 colVal");
            if(diagonalCheck(arr,0,firstCol) == false){
                return false;
            }
            firstCol++;
        }

        while(firstRow < arr.length){
            System.out.println(firstRow + ": 0 rowVal");
            if(diagonalCheck(arr,firstRow,0) == false){
                return false;
            }
            firstRow++;
        }

        return true;
    }
    public static boolean diagonalCheck(int [] [] arr, int r, int c){
        int val = arr[r][c];
        while(r < arr.length && c < arr[0].length){
            if(arr[r][c] != val){
                return false;
            }
            r++;
            c++;
        }
        return true;
    }
}
