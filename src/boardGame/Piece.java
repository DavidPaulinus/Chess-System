package boardGame;

public abstract class Piece {
	protected Position position;
	private Board board;

	public Piece(Board borad) {
		this.position = null;
		this.board = borad;
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	public Boolean possibleMove(Position position) {
		return possibleMoves()[position.getColumn()][position.getRow()];
	}

	public Boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
