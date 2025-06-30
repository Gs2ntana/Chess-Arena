package com.chess.arena.models;

import com.chess.arena.utils.Color;

public class Knight extends ChessPiece {

	public Knight(Color color, Board board) {
		super(color, board);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves(ChessPosition position) {
		boolean[][] mat = new boolean[board.getSize()][board.getSize()];
		
		checkJump(mat, position, -2, -1);
        checkJump(mat, position, -2, 1);
        checkJump(mat, position, -1, -2);
        checkJump(mat, position, -1, 2);
        checkJump(mat, position, 1, -2);
        checkJump(mat, position, 1, 2);
        checkJump(mat, position, 2, -1);
        checkJump(mat, position, 2, 1);
        
		return mat;
	}
	
	private void checkJump(boolean[][] mat, ChessPosition startPosition, int rowOffset, int colOffset){
		int p_row = startPosition.getMatrixRow() + rowOffset;
		int p_col = startPosition.getMatrixColumn() + colOffset;
		
		if(p_row >= 0 && p_row < board.getSize() && p_col >= 0 && p_col < board.getSize()) {
			ChessPosition targetPosition = ChessPosition.fromMatrixPosition(p_row, p_col);
			
			if (canMove(targetPosition)) {
                mat[p_row][p_col] = true;
            }
		}
	}

}
