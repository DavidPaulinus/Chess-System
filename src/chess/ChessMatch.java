package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] matriz = new ChessPiece[board.getColumns()][board.getRows()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				matriz[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return matriz;
	}
	
	public boolean[][] possibleMoves(ChessPosition chessposition){
		Position position=chessposition.toPosition();
		validateSourcePosition(position);
		
		return board.piece(position).possibleMoves();
		
	}

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source,target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece) capturedPiece;
	}

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);

		return capturedPiece;
	}

	private void validateSourcePosition(Position source) {
		if (!board.thereIsAPiece(source)) {
			throw new ChessException("There is no piece on source position.");
		}
		if (!board.piece(source).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece.");
		}
	}
	
	private void validateTargetPosition(Position source,Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to the target position.");
		}
	}

	private void placeNewPiece(Character column, Integer row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {
		placeNewPiece('e', 1, new King(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('h', 1, new Rook(board, Color.WHITE));

		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('a', 8, new Rook(board, Color.BLACK));
		placeNewPiece('h', 8, new Rook(board, Color.BLACK));

	}
}
