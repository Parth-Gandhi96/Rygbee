
import java.util.*;
public class DerivedConcepts {
    private HashSet<String> _derivedconcepts = new HashSet< String>();
	
    public void addDerived(String[] derived){
	for (String s: derived){
            _derivedconcepts.add(s);
	}			
    }
		
    public HashSet<String> getDerivedConcepts(){
	return _derivedconcepts;
    }
	
}
