import java.util.ArrayList;

public class Node {

	String  conceptName;
	ArrayList<Node> list = new ArrayList<Node>();
	
	Node(String name){
		this.conceptName = name;
	}
	
	public void printList(){
		System.out.println(this.conceptName + " -> ");
		for(Node n: list){
			System.out.println(n.conceptName);
		}
	}
}
