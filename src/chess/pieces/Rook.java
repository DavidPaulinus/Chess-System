package chess.pieces;

import boardGame.Board;
import boardGame.Position;
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

		Position p = new Position(0, 0);

		// above

		p.setValues(position.getColumn(), position.getRow() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getColumn()][p.getRow()] = true;

			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereAOpponetPiece(p)) {
			mat[p.getColumn()][p.getRow()] = true;
		}

		// below

		p.setValues(position.getColumn(), position.getRow() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getColumn()][p.getRow()] = true;

			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereAOpponetPiece(p)) {
			mat[p.getColumn()][p.getRow()] = true;
		}

		// left

		p.setValues(position.getColumn() - 1, position.getRow());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getColumn()][p.getRow()] = true;

			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereAOpponetPiece(p)) {
			mat[p.getColumn()][p.getRow()] = true;
		}

		// right

		p.setValues(position.getColumn() + 1, position.getRow());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getColumn()][p.getRow()] = true;

			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereAOpponetPiece(p)) {
			mat[p.getColumn()][p.getRow()] = true;
		}

		return mat;
	}
}
