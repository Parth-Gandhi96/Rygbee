
import java.util.*;

public class Parser {
    private DerivedConcepts _derived = new DerivedConcepts();
    private HashSet<String> _concepts = new HashSet< String>();
    private HashSet<String> _derivedconcepts;
    private PrimitiveConcepts primitive = new PrimitiveConcepts();
	
    public void parse( String line ){	
	Relation.makeRelation();                                                        // To Store all the Relation Accordingly in Relation class
	line = line.replaceAll("\\s","");                                               // Removing all the Space (without meaning)
	String lineDelimiter;
	if(line.contains("@")){
            Axiom._axioms.add(line.split("@")[1]);                                      //Removing @ From the Starting of the Axiom & Add that Axiom in the Set of AXIOMS in Axiom class
            lineDelimiter = Relation.getAxiomDelimiter();                               //Get all Axiom-Delimiter seperated by OR in lineDelimiter
            String[] parsedString = (line.split("@")[1]).split(lineDelimiter);          //Splittting Axiom using Axiom-Delimiter
            for(String s : parsedString){
		_concepts.add(s);                                                       //Adding all the Splitted String (May be Primitive Concepts OR Derived Concept) in to Concepts (HashSet)
            }
	}
	else if(line.contains("#")){
            Definition._definition.add(line.split("#")[1]);                             //Removing # From the Starting of the Definition & Add that Definition in the Set of Definition in Definition class
	}
	else{
            lineDelimiter = Relation.getderivedelimiter();                              //Get all Derived-Delimiter seperated by OR in lineDelimiter
            String[] parsedString = line.split(lineDelimiter);                          //Splittting the line using Derived-Delimiter
            String[] derived = new String[parsedString.length - 1];
            System.arraycopy(parsedString, 0, derived, 0, parsedString.length-1);
            _derived.addDerived(derived);                                               //Adding the Derived Concept - Which are in the left of Derived-Delimiter
		
            lineDelimiter =  Relation.getprimitivedelimiter();                          //Get all Primitive-Delimiter seperated by OR in lineDelimiter
            parsedString =  parsedString[parsedString.length - 1].split(lineDelimiter); // Splitting the Right part of line (After spltiing using Derived-Delimiter) using primitive-Delimiter
	
            for(String s : parsedString){
		_concepts.add(s);                                                       //Adding Those (May be Primitive Concepts OR Derived Concept) in to concept (HashSet)
            }
	}		
    }
    public void separateConcepts(){
	_derivedconcepts = _derived.getDerivedConcepts();                               
	for(String s : _concepts){                                                      //Checking that all Concepts From the concept(HashSet)
            if(!_derivedconcepts.contains(s)){                                          //NOT Derived Concepts are Primitive Concepts
		primitive.addPrimitive(s);                                              // Adding those primitive Concepts in to primitive concepts (Hashset) of class primitive concept
            }				
	}
	primitive.createGraph();                                                        
	primitive.print();
    }
}

