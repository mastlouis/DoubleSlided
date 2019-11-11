package starter.entity;

public class Tile {
	
	String front;
	String back;
	boolean faceDown;
	String type;
	
	public Tile(String front, String back, boolean faceDown) {
		this.front = front;
		this.back = back;
		this.faceDown = faceDown;
		
		if(front.equals("") && back.equals("")) {
			this.type = "blank";
		}
		else {
			this.type = "number";
		}
	}
	
	public void setFlip(boolean flip) {
		this.faceDown = flip;
	}
	
	public boolean isBlank() {
		if(type.equals("blank")) {
			return true;
		}
		return false;
	}
	
	public String getSymbolShown() {
		if(faceDown) {return back;}
		return front;
	}
	
	public boolean isFlipped() {
		return this.faceDown;
	}
	
	public String getType() {
		return this.type;
	}
	
	public boolean toggleFlip() {
		this.faceDown = !this.faceDown;
		return this.faceDown;
	}
}
