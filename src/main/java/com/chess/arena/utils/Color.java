package com.chess.arena.utils;

import lombok.Getter;

@Getter
public enum Color {
	WHITE("1"),
	BLACK("2");
	
	private final String value;
	
	Color(String value){
		this.value = value;
	}
}
