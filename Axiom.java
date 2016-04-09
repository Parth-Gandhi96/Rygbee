import java.util.HashSet;

public class Axiom {

	public static HashSet<String> _axioms = new HashSet<String>();
		
	public Axiom(){
		
	}
	
	public static String[] makeGraph(String s){
		String[] ar = new String[2];
		if(s.contains(">=")  || s.contains(">.") ){
				ar[1] = s.split(Relation.getAxiomDelimiter())[0];
				ar[0] = s.split(Relation.getAxiomDelimiter())[1];
			}					
		else{
				ar = s.split(Relation.getAxiomDelimiter());
			}
		return ar;
	}
		
}
