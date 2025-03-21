package problem.section7._05;

class Node {
	int data;
	Node lt;
	Node rt;

	public Node(int val) {
		data = val;
		lt = null;
		rt = null;
	}
}

public class Main {
	Node root;

	public void dfs(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " "); // 위치에 따라 전위, 중위, 후위 순회 결정
		dfs(root.lt);
		dfs(root.rt);
	}

	public static void main(String[] args) {
		Main tree = new Main();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		tree.dfs(tree.root);
	}
}
