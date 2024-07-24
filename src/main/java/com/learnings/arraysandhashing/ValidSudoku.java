package com.learnings.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.print(validSudoku.isValidSudoku(new char[][]{{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}}));
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i <= 8; i++) {
            Set<Character> rowcharacters = new HashSet<>();
            Set<Character> colcharacters = new HashSet<>();
            for (int j = 0; j <= 8; j++) {
                if (board[i][j] != '.') {
                    boolean rcontainchar = rowcharacters.add(board[i][j]);

                    if (!rcontainchar) {
                        return false;
                    }

                }
                if(board[j][i] != '.'){
                    boolean ccontainchar = colcharacters.add(board[j][i]);
                    if (!ccontainchar) {
                        return false;
                    }
                }
            }
        }
        return (isValidSudoku(board,0,2,0,2)
                && isValidSudoku(board,0,2,3,5)
        && isValidSudoku(board,0,2,6,8)
                && isValidSudoku(board,3,5,0,2)
                && isValidSudoku(board,3,5,3,5)
                && isValidSudoku(board,3,5,6,8)
                && isValidSudoku(board,6,8,0,2)
                && isValidSudoku(board,6,8,3,5)
                && isValidSudoku(board,6,8,6,8)
        );
    }

        public boolean isValidSudoku(char[][] board,int rowstart,int rowEnd, int colStart, int colEnd) {
            Set<Character> characters = new HashSet<>();
            for (int i=rowstart ; i<=rowEnd;i++ ){

                for (int j=colStart ; j<=colEnd;j++ ){
                    if(board[i][j] != '.'){
                        boolean rcontainchar = characters.add(board[i][j]);
                        if (!rcontainchar ){
                            return false;
                        }
                    }
                }
            }

            return true;


    }
}
