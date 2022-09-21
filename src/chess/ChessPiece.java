package chess;

import boardGame.Board;
import boardGame.Piece;

public class ChessPiece extends Piece{
	private Color color;
	
	public ChessPiece(Board borad,Color color) {
		super(borad);
		this.color=color;
	}
	
	public Color getColor() {
		return color;
	}

}
