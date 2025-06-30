package com.chess.arena.models;

import com.chess.arena.utils.Color;

public class Pawn extends ChessPiece {

	public Pawn(Color color, Board board) {
		super(color, board);
	}

	@Override
	public boolean[][] possibleMoves(ChessPosition position) {
		boolean[][] mat = new boolean[board.getSize()][board.getSize()];

		if (getColor() == Color.WHITE) {
			
            ChessPosition oneStepForward = new ChessPosition(position.getColumn(), position.getRow() + 1);
            
            if (board.positionExists(oneStepForward) && !board.isThereAPiece(oneStepForward)) {
                mat[oneStepForward.getMatrixRow()][oneStepForward.getMatrixColumn()] = true;
            }

            if (position.getRow() == 2) {
                ChessPosition twoStepsForward = new ChessPosition(position.getColumn(), position.getRow() + 2);
                // **CORREÇÃO:** Aplicamos a mesma lógica para ambas as casas.
                if (board.positionExists(oneStepForward) && !board.isThereAPiece(oneStepForward) && board.positionExists(twoStepsForward) && !board.isThereAPiece(twoStepsForward)) {
                    mat[twoStepsForward.getMatrixRow()][twoStepsForward.getMatrixColumn()] = true;
                }
            }
            
            ChessPosition diagonalLeft = new ChessPosition((char)(position.getColumn() - 1), position.getRow() + 1);
            if (board.positionExists(diagonalLeft) && isThereOpponentPiece(diagonalLeft)) {
                mat[diagonalLeft.getMatrixRow()][diagonalLeft.getMatrixColumn()] = true;
            }

            ChessPosition diagonalRight = new ChessPosition((char)(position.getColumn() + 1), position.getRow() + 1);
            if (board.positionExists(diagonalRight) && isThereOpponentPiece(diagonalRight)) {
                mat[diagonalRight.getMatrixRow()][diagonalRight.getMatrixColumn()] = true;
            }

        } else {
        	ChessPosition oneStepForward = new ChessPosition(position.getColumn(), position.getRow() - 1);
        	
            if (board.positionExists(oneStepForward) && !board.isThereAPiece(oneStepForward)) {
                mat[oneStepForward.getMatrixRow()][oneStepForward.getMatrixColumn()] = true;
            }

            ChessPosition twoStepsForward = new ChessPosition(position.getColumn(), position.getRow() - 2);

            if (position.getRow() == 7 && !board.isThereAPiece(oneStepForward) && !board.isThereAPiece(twoStepsForward)) {
                mat[twoStepsForward.getMatrixRow()][twoStepsForward.getMatrixColumn()] = true;
            }

            ChessPosition diagonalLeft = new ChessPosition((char)(position.getColumn() - 1), position.getRow() - 1);
            if (board.positionExists(diagonalLeft) && isThereOpponentPiece(diagonalLeft)) {
                mat[diagonalLeft.getMatrixRow()][diagonalLeft.getMatrixColumn()] = true;
            }

            ChessPosition diagonalRight = new ChessPosition((char)(position.getColumn() + 1), position.getRow() - 1);
            if (board.positionExists(diagonalRight) && isThereOpponentPiece(diagonalRight)) {
                mat[diagonalRight.getMatrixRow()][diagonalRight.getMatrixColumn()] = true;
            }
        }
        return mat;
	}

}
