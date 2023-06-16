package Practice;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> solutions = new ArrayList<>();
        placeQueen(board,n,n, solutions );
        return  solutions;

    }

    private void placeQueen(boolean[][] board, int n, int queens, List<List<String>> solutions) {
        if(queens == 0){
            addBoardToSolution(board,n, solutions);
            return;
        }
        int row = n - queens;
        for(int col=0; col<n; col++){
            if(!isValid(board, n, row, col))
                continue;
            board[row][col]=true;
            placeQueen(board,n, queens-1, solutions);
            board[row][col]=false;
        }

    }

    private void addBoardToSolution(boolean[][] board, int n, List<List<String>> solutions) {
        List<String> sol = new ArrayList<>();
        for(int row=0; row<n; row++){
            StringBuilder sb = new StringBuilder();
            for(int col=0; col<n; col++){
                if(board[row][col] == false)
                   sb.append('.');
                else
                    sb.append('Q');
            }
            sol.add(sb.toString());
        }
        solutions.add(sol);
    }

    private boolean isValid(boolean[][] board, int n, int row, int col) {
        for(int i=0; i<row; i++){
            if(board[i][col] == true )
                return false;
            int diff = row -i;
            if(col - diff >=0 && board[i][col-diff] == true){
                return false;
            }
            if(col + diff < n && board[i][col+diff] == true){
                return false;
            }

        }

        return true;
    }


}
