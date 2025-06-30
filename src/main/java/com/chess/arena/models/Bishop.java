package com.chess.arena.models;

import com.chess.arena.utils.Color;

public class Bishop extends ChessPiece {
	
	public Bishop(Color color, Board board) {
		super(color, board);
	}

	@Override
	public boolean[][] possibleMoves(ChessPosition position) {
		 boolean[][] mat = new boolean[board.getSize()][board.getSize()];
	        
	        // Noroeste (NW): linha -1, coluna -1
	        checkDiagonal(mat, position, -1, -1);
	        
	        // Nordeste (NE): linha -1, coluna +1
	        checkDiagonal(mat, position, -1, 1);
	        
	        // Sudoeste (SW): linha +1, coluna -1
	        checkDiagonal(mat, position, 1, -1);

	        // Sudeste (SE): linha +1, coluna +1
	        checkDiagonal(mat, position, 1, 1);

	        return mat;
	}
	
	private void checkDiagonal(boolean[][] mat, ChessPosition startPosition, int rowDirection, int colDirection) {
        int p_row = startPosition.getMatrixRow() + rowDirection;
        int p_col = startPosition.getMatrixColumn() + colDirection;

        while (p_row >= 0 && p_row < board.getSize() && p_col >= 0 && p_col < board.getSize()) {
            ChessPosition targetPosition = ChessPosition.fromMatrixPosition(p_row, p_col);

            if (board.piece(targetPosition) == null) {
                mat[p_row][p_col] = true;
            }
            else if (canMove(targetPosition)) {
                mat[p_row][p_col] = true;
                break; 
            }
            else {
                break; 
            }
            
            p_row += rowDirection;
            p_col += colDirection;
        }
    }

}
