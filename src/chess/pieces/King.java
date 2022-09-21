package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board borad, Color color) {
		super(borad, color);
	}

	@Override
	public String toString() {
		return "K";
	}
	
	
	
}
