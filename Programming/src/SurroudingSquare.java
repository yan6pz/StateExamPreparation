
public class SurroudingSquare {
	
	public SurroudingSquare(float biggestX, float smallestX, float biggestY, float smallestY) {
		float yDistance=Math.abs(biggestY-smallestY);
		float xDistance=Math.abs(biggestX-smallestX);
		if(yDistance>xDistance)
		{
			biggestX=smallestX+yDistance;
			side=yDistance;
		}
		else{
			biggestY=smallestY+xDistance;
			side=xDistance;
		}
		Ox=(biggestX+smallestX)/2;
		Oy=(biggestY+smallestY)/2;
		
	}
	 
	float side;
	float Ox;
	float Oy;
}
