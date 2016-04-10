
import java.util.HashMap;
import java.util.HashSet;

public class PrimitiveConcepts {
    public static HashSet<String> _primitives = new HashSet<String>();
    public static HashMap<String , Node> map = new HashMap<String , Node>();
    public PrimitiveConcepts(){
		
    }
    public void addPrimitive(String s){
	_primitives.add(s);                         //Add the given primitive concept in to primitives(HashSet)
	Node node = new Node(s);                    //Creating the node of that primitive concept
	map.put(s, node);                           //Adding that primitive in to map
    }
    public void createGraph(){
	for(String s : Axiom._axioms ){
            addToGraph(s);                          //Checks all the Axioms & Accordingly creat the graph
	}
    }
    public void addToGraph(String s){
	String[] a;
	a = Axiom.makeGraph(s);                     // s -> Axiom statement & a[1]->head a[0]->footer
	map.get(a[1]).list.add(map.get(a[0]));      // Adding node of a[0](From the HAshMap) into the arraylist of node of a[1] (From the HAshMap)
    }
    public void print(){
	for(String s : _primitives){
            map.get(s).printList();
	}
    }
}

