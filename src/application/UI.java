package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			Character column = s.charAt(0);
			Integer row = Integer.parseInt(s.substring(1));

			return new ChessPosition(column, row);

		} catch (RuntimeException e) {
			throw new InputMismatchException("Error reading the ChessPosition. Valid values are from a1 to h8");

		}
	}

	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn: " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
	}

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");

			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();

		}
		System.out.println("  a  b  c  d  e  f  g  h");
	}

	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");

			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();

		}
		System.out.println("  a  b  c  d  e  f  g  h");
	}

	private static void printPiece(ChessPiece piece, boolean backGound) {
		if (piece == null && !backGound) {
			System.out.print("- ");
		} else {
			if (piece == null && backGound) {
				System.out.print("* ");
			} else {
				if (piece.getColor() == Color.WHITE) {
					System.out.print(piece + "w");

				} else {
					System.out.print(piece + "b");
				}

			}
		}
		System.out.print(" ");
	}

	public static void clearScreen() {
		System.out.flush();
	}
	
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println("Captured pieces: ");
		System.out.print("White: ");
		System.out.println(Arrays.toString(white.toArray()));
		
		System.out.print("Black: ");
		System.out.println(Arrays.toString(black.toArray()));

	}
	
}
