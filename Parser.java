import java.util.*;

public class Parser {
	
	private DerivedConcepts _derived = new DerivedConcepts();
	private HashSet<String> _concepts = new HashSet< String>();
//	private HashSet<String> _primitiveconcepts = new HashSet< String>();
	private HashSet<String> _derivedconcepts;
	private PrimitiveConcepts primitive = new PrimitiveConcepts();
	
	public void parse( String line ){
		
		Relation.makeRelation();
		line = line.replaceAll("\\s","");
		//System.out.println(line);
		String lineDelimiter = Relation.getderivedelimiter();
		if(line.contains("@")){
			Axiom._axioms.add(line.split("@")[1]);
			lineDelimiter = Relation.getAxiomDelimiter();
			String[] parsedString = (line.split("@")[1]).split(lineDelimiter);
			for(String s : parsedString){
				_concepts.add(s);	
			//	System.out.println(s);
			}
		}
		else if(line.contains("#")){
			Definition._definition.add(line.split("#")[1]);
		}
		else{
		String[] parsedString = line.split(lineDelimiter);
		String[] derived = new String[parsedString.length - 1];
		System.arraycopy(parsedString, 0, derived, 0, parsedString.length-1);
		_derived.addDerived(derived);
		
		lineDelimiter =  Relation.getprimitivedelimiter();
		parsedString =  parsedString[parsedString.length - 1].split(lineDelimiter);
	
		for(String s : parsedString){
			_concepts.add(s);	
		}
		}
		
	}
	public void separateConcepts(){
		_derivedconcepts = _derived.getDerivedConcepts();
		for(String s : _concepts){
			System.out.println(s);
			if(!_derivedconcepts.contains(s)){
				System.out.println(s + "primitive");
				primitive.addPrimitive(s);
				
			}				
		}
		primitive.createGraph();
		primitive.print();
	}
}
