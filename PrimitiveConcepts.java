
import java.util.HashMap;
import java.util.HashSet;

public class PrimitiveConcepts {
	public static HashSet<String> _primitives = new HashSet<String>();
	public static HashMap<String , Node> map = new HashMap<String , Node>();
	
	public PrimitiveConcepts(){
		
	}
	
	public void addPrimitive(String s){
		_primitives.add(s);
		Node node = new Node(s);
		map.put(s, node);
	}
	
	public void createGraph(){
		for(String s : Axiom._axioms ){
			addToGraph(s);
		}
	}
	
	public void addToGraph(String s){
		String[] a;
		a = Axiom.makeGraph(s);
	//	System.out.println(a[0] + a[1]);
		map.get(a[1]).list.add(map.get(a[0]));
	}
	public void print(){
		for(String s : _primitives){
			map.get(s).printList();
		}
	}
}
