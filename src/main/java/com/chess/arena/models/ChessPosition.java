package com.chess.arena.models;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ChessPosition{
	
	@Getter final char column; 
	@Getter private final int row;
	
	public ChessPosition(char column, int row){
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new IllegalArgumentException("Posição inválida. A coluna deve ser de 'a' a 'h' e a linha de 1 a 8.");
        }
        this.column = column;
        this.row = row;
    }
	
	public int getMatrixRow() {
        return 8 - this.row;
    }
	
	public int getMatrixColumn() {
        return this.column - 'a';
    }
	
	public static ChessPosition fromMatrixPosition(int matrixRow, int matrixColumn) {
        char column = (char) ('a' + matrixColumn);
        int row = 8 - matrixRow;
        return new ChessPosition(column, row);
    }
}
