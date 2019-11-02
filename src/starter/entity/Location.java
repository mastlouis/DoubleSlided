package starter.entity;

public class Location {
	
	int row;
	int column;
	Tile tile;
	
	public Location(int row, int column, String front, String back, boolean faceDown) {
		this.row = row;
		this.column = column;
		this.tile = new Tile(front, back, faceDown);
	}
	
	public boolean isBlank() {
		return this.tile.isBlank();
	}
	
	public Tile getTile() {
		return this.tile;
	}
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	public String getSymbolShown() {
		return this.tile.getSymbolShown();
	}
	public boolean isFlipped() {
		return this.tile.isFlipped();
	}

}
