package BackTracking;

import java.util.Arrays;

public class WordSearch {
    /*
11:05
pause: 11:11
resume: 11:13
dfs update character grid at each index value
may need to use visited matrix to keep track of characters we've already seen
as we traverse update our word
after the dfs calls backtrack

loop through matrix
if we find the starting character run a dfs call on that i,j
if the dfs call goes out of bounds or hits an incorrect character return
otherwise keep going until we find it or exhaust our options

return false at the end if you dont find any words
Notes:
- you can backtrack by setting a temp variable in the middle
and using it to return the variable at the end of the dfs statements
- instead of using a visited matrix you can update the visited columns to *
and change them back when you backtrack
- extremely slow solution you can speed it up by returning a boolean instead
- remember backtracking is nothing but setting a temporary variable or placeholder in
one iteration of recursion and removing that when you're done with it
- using an index is extremely important here and increases the speed dramatically
*/
        boolean flag = false;
        public boolean exist(char[][] board, String word) {
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == word.charAt(0)){
                        //System.out.println("hit");
                        dfs(board,word,"",i,j,0);
                    }
                    if(flag){
                        return flag;
                    }
                }
            }

            return false;
        }

        public void printM(char [] [] m){
            for(int i = 0; i < m.length; i++){
                System.out.println(Arrays.toString(m[i]));
            }
        }

        public void dfs(char [] [] board, String word, String currWord, int r, int c, int idx){
            if(r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || currWord.length() > word.length() || board[r][c] == '*'){
                return;
            }

            if(idx >= word.length() || word.charAt(idx) != board[r][c]){
                return;
            }

            currWord += board[r][c];
            Character temp = board[r][c];
            board[r][c] = '*';

            if(currWord.equals(word)){
                flag = true;
            }

            dfs(board,word,currWord,r,c + 1, idx + 1);
            dfs(board,word,currWord,r,c - 1, idx + 1);
            dfs(board,word,currWord,r + 1,c, idx + 1);
            dfs(board,word,currWord,r - 1,c, idx + 1);


            board[r][c] = temp;

        }
    // faster solution*
    class Solution {
        public boolean exist(char[][] board, String word) {
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    Character curr = board[i][j];
                    if(word.charAt(0) == curr){
                        if(dfs(board,i,j,0,word)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean dfs(char [] [] board, int r, int c, int idx, String word){
            if(word.length() == idx){
                return true;
            }
            if(r >= board.length || r < 0 || c >= board[0].length || c < 0 || board[r][c] != word.charAt(idx)){
                return false;
            }

            Character temp = board[r][c];
            board[r][c] = '*';

            boolean b = (dfs(board, r + 1, c, idx+1, word) || dfs(board, r - 1, c, idx+1, word) || dfs(board, r, c + 1, idx+1, word) || dfs(board, r, c - 1, idx+1, word));

            board[r][c] = temp;
            return b;
        }
    }
}
