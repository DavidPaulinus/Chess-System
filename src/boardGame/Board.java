package boardGame;

public class Board {
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;

	public Board(Integer rows, Integer columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[columns][rows];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public Piece piece(Integer row, Integer column) {
		if (!positionExists(column, row)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[column][row];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getColumn()][position.getRow()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getColumn()][position.getRow()] = piece;
		piece.position = position;
	}

	public Boolean positionExists(Integer row, Integer column) {
		return row < rows && row >= 0 && column >= 0 && column < columns;

	}

	public Boolean positionExists(Position position) {
		return positionExists(position.getColumn(), position.getRow());
	}

	public Boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;

	}

	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}

		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getColumn()][position.getRow()] = null;

		return aux;

	}
}
