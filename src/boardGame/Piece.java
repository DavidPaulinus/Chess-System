package boardGame;

public class Piece {
	protected Position position;
	private Board borad;

	public Piece(Board borad) {
		this.position = null;
		this.borad = borad;
	}

	protected Board getBorad() {
		return borad;
	}

}
