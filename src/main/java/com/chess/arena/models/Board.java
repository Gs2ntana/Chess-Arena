package com.chess.arena.models;


public class Board {

	private static final int size = 8;
	private final ChessPiece[][] pieces;
	
	public Board() {
		this.pieces = new ChessPiece[size][size];
	}
	
	public int getSize() {
		return size;
	}
	
	public ChessPiece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new IllegalArgumentException("Posição não existe no tabuleiro."); //Personalizar dps
        }
        return pieces[row][column];
    }
	
	public ChessPiece piece(ChessPosition position) {
        return piece(position.getMatrixRow(), position.getMatrixColumn());
    }
	
	public void placePiece(ChessPiece piece, ChessPosition position) {
        if (piece(position) != null) {
            throw new IllegalArgumentException("Já existe uma peça na posição " + position); //Personalizar dps
        }
        pieces[position.getMatrixRow()][position.getMatrixColumn()] = piece;
    }
	
	protected boolean positionExists(ChessPosition position) {
		return positionExists(position.getMatrixRow(), position.getMatrixColumn());
    }
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < size && column >= 0 && column < size;
	}
	
	public ChessPiece removePiece(ChessPosition position) {
        if (!positionExists(position)) {
            throw new IllegalArgumentException("Posição não existe no tabuleiro."); //Alterar
        }
        ChessPiece pieceAtPosition = piece(position);
        if (pieceAtPosition == null) {
            return null;
        }
        pieces[position.getMatrixRow()][position.getMatrixColumn()] = null;
        return pieceAtPosition;
    }
	
	public boolean isThereAPiece(ChessPosition position) {
        if (!positionExists(position)) {
            throw new IllegalArgumentException("Posição não existe no tabuleiro."); //Alterar
        }
        return piece(position) != null;
    }
}
