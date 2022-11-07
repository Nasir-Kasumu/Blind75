package MathGeometry;

public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int i = 0; i < matrix.length; i++){
            reverse(matrix[i]);
        }
    }

    public void reverse(int [] arr){
        int s = 0;
        int e = arr.length - 1;
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    public void transpose(int [][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
