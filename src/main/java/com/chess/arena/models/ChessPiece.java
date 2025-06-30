package com.chess.arena.models;

import com.chess.arena.utils.Color;

public abstract class ChessPiece {
	private final Color color;
	protected final Board board;
	public abstract boolean[][] possibleMoves(ChessPosition position);
	
	public ChessPiece(Color color, Board board) {
		this.board = board;
        this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	protected boolean canMove(ChessPosition position) {
		ChessPiece pieceAtPosition = board.piece(position);
		return pieceAtPosition == null || pieceAtPosition.getColor() != this.color;
	}
	
	protected boolean isThereOpponentPiece(ChessPosition position) {
        ChessPiece p = board.piece(position);
        return p != null && p.getColor() != this.getColor();
    }
}
