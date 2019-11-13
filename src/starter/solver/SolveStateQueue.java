package starter.solver;

import java.util.ArrayList;

public class SolveStateQueue {
	ArrayList<SolveState> states;
	
	public SolveState next() {
		if(this.hasNext()) {
			return states.remove(0);
		}
		return null;
	}
	
	public boolean hasNext() {
		return states.size() > 0;
	}
	
	public boolean append(SolveState newState) {
		this.states.add(newState);
		return true;
	}
	
	public SolveStateQueue(){
		this.states = new ArrayList<SolveState>();
	}
}
