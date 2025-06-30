package com.chess.arena.models;

import com.chess.arena.utils.Color;

public class Queen extends ChessPiece {

	public Queen(Color color, Board board) {
		super(color, board);
	}

	@Override
	public boolean[][] possibleMoves(ChessPosition position) {
		boolean[][] mat = new boolean[board.getSize()][board.getSize()];
		
		checkDirection(mat, position, -1, 0);
		checkDirection(mat, position, -1, -1);
		checkDirection(mat, position, -1, 1);
		
		checkDirection(mat, position, 1, 0);
		checkDirection(mat, position, 1, -1);
		checkDirection(mat, position, 1, 1);
		
		checkDirection(mat, position, 0, -1);
		checkDirection(mat, position, 0, 1);
		return mat;
	}

	public void checkDirection(boolean[][] mat, ChessPosition startPosition, int rowDirection, int colDirection) {
		int p_row = startPosition.getMatrixRow() + rowDirection;
		int p_col = startPosition.getMatrixColumn() + colDirection;
		
		while(p_row >= 0 && p_row < board.getSize() && p_col >= 0 && p_col < board.getSize()){
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
