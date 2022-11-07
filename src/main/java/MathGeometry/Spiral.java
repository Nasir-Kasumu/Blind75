package MathGeometry;

import java.util.ArrayList;
import java.util.List;
/*
2:17
finish 2:43 26 mins
     *
 *  [0,0][0,1][0,2] *
    [1,0][1,1][1,2]
    [2,0][2,1][2,2]
     *

lBound: 0
rBound: arr[0].len = 2
tBound: 0
bBound: arr.len = 2

count  = m.len*m[0].len
list
while i < rBound
list.add([tBound][i])
i++;
tBound++;

while i < bBound
list.add([i][rBound])
i++;
rBound--;?

while i > lBound
list.add([i][bBound])
i--;
bBound--;

while i > tBound
list.add([i][lBound])
i--;
lBound++

*/


public class Spiral {
    public List<Integer> spiralOrder(int[][] arr) {
        int count = arr.length * arr[0].length;
        int lBound = 0;
        int rBound = arr[0].length - 1;
        int tBound = 0;
        int bBound = arr.length - 1;
        System.out.println(count);
        List<Integer> list = new ArrayList<>();
        while(count > 0){
            System.out.println(count);
            for(int i = lBound; i <= rBound; i++){
                list.add(arr[tBound][i]);
                count--;
            }
            tBound++;

            for(int i = tBound; i <= bBound; i++){
                list.add(arr[i][rBound]);
                count--;
            }
            rBound--;

            for(int i = rBound; i >= lBound; i--){//
                if(count > 0){
                    list.add(arr[bBound][i]);
                }
                count--;
            }
            bBound--;

            for(int i = bBound; i >= tBound; i--){
                if(count > 0){
                    list.add(arr[i][lBound]);
                }
                count--;
            }
            lBound++;
        }


        return list;
    }
}
