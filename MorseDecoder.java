public class MorseDecoder {
	//The coding of the alphabet letters.
	BTree<String> morseTree ;
	//Add a blank constructor to the class. 
	//The builder will fill the tree according to the drawing in the exercise. 
	//That is, it will add nodes with letters to the tree 
	//according to the way the letters are coded in Morse.
	public MorseDecoder () throws InvalidPathException {
			morseTree=new BTree<String>();
		   this.morseTree.addByPath("Start", "");
		   this.morseTree.addByPath("T","R");
		   this.morseTree.addByPath("M","RR");
		   this.morseTree.addByPath("N","RL");
		   this.morseTree.addByPath("O","RRR");
		   this.morseTree.addByPath("G","RRL");
		   this.morseTree.addByPath("Q","RRLR");
		   this.morseTree.addByPath("Z","RRLL");
		   this.morseTree.addByPath("K","RLR");
		   this.morseTree.addByPath("D","RLL");
		   this.morseTree.addByPath("Y","RLRR");
		   this.morseTree.addByPath("C","RLRL");
		   this.morseTree.addByPath("X","RLLR");
		   this.morseTree.addByPath("B","RLLL");
		   this.morseTree.addByPath("E","L");
		   this.morseTree.addByPath("A","LR");
		   this.morseTree.addByPath("I","LL");
		   this.morseTree.addByPath("W","LRR");
		   this.morseTree.addByPath("R","LRL");
		   this.morseTree.addByPath("J","LRRR");
		   this.morseTree.addByPath("P","LRRL");
		   this.morseTree.addByPath("L","LRLL");
		   this.morseTree.addByPath("U","LLR");
		   this.morseTree.addByPath("S","LLL");
		   this.morseTree.addByPath("F","LLRL");
		   this.morseTree.addByPath("V","LLLR");
		   this.morseTree.addByPath("H","LLLL");
		}
	//	The method returns a string that represents the Morse tree by pre-order printing.
	public String toString() {
		return morseTree.pre();
	}
	//The method will return the string of the signal represented by the string. 
	//If the string is invalid (contains invalid marks) or it does not represent any signal,
	//the method will throw an InvalidMorseCodeException exception.
	public String decode(String morseStr) throws InvalidMorseCodeException, InvalidPathException {
		MorseDecoder copy =new MorseDecoder();
		if(copy.morseTree==null||morseStr.length()==0) 
			return null;
		if(copy.morseTree.root==null) 
			throw new InvalidMorseCodeException();
		
		for(int i=0;i<morseStr.length();i++) {
			if (morseStr.charAt(i) == '-' && copy.morseTree.root.getRightson() != null)
				copy.morseTree.root=copy.morseTree.root.getRightson();
		else if(morseStr.charAt(i) == '.' && copy.morseTree.root.getLeftson() != null)
			copy.morseTree.root=copy.morseTree.root.getLeftson();
		else 
			throw new InvalidMorseCodeException();
	}
		return copy.morseTree.root.getData();
}
}