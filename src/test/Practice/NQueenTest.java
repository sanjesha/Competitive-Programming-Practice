package Practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueenTest {
    @Test
    void testNQueen() {
        NQueen nq = new NQueen();
        System.out.println(nq.solveNQueens(4));
    }
}