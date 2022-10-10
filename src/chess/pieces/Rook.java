package chess.pieces;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board borad, Color color) {
		super(borad, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean mat[][] = new boolean[getBoard().getColumns()][getBoard().getRows()];
		return mat;
	}
}
