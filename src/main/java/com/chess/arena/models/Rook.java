package com.chess.arena.models;

import com.chess.arena.utils.Color;

public class Rook extends ChessPiece {

	public Rook(Color color, Board board) {
		super(color, board);
	}

	@Override
	public boolean[][] possibleMoves(ChessPosition position) {
		boolean[][] mat = new boolean[board.getSize()][board.getSize()];
		
		checkRight(mat, position, 1, 0);
		checkRight(mat, position, -1, 0);
		checkRight(mat, position, 0, -1);
		checkRight(mat, position, 0, 1);		
		return mat;
	}

	private void checkRight(boolean[][] mat, ChessPosition startPosition, int rowDirection, int colDirection) {
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
