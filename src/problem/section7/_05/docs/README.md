# Problem - 이진트리 순회 DFS (개념잡기용)

- 해당 섹션은 개념잡기용 강의이기에 Model Solution을 빠르게 학습하고 넘어간다.

## KeyWord

- 이진트리
- DFS 순회 방식 (전위, 중위, 후위)

## Problem Requirements

- 주어진 트리를 DFS 순회 방법(전위, 중위, 후위)을 각각 출력 

## Problem Approach Strategy

- 스택 프레임의 구조를 이해하면, 데이터를 출력하는 시점을 조정하여 전위, 중위, 후위 순회 방식으로 출력할 수 있다.

## Model Solution

```java
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
```

## What I Learned

![Image](https://github.com/user-attachments/assets/4e5099b9-58ab-4d2a-b89b-f7251ac0d256)
- 전위 순회 (Pre-order): 부모 노드를 출력한 후 왼쪽과 오른쪽 자식 노드를 탐색한다.
- 중위 순회 (In-order): 왼쪽 자식 노드를 탐색한 후 부모 노드를 출력하고, 오른쪽 자식 노드를 탐색한다.
- 후위 순회 (Post-order): 왼쪽과 오른쪽 자식 노드를 탐색한 후 부모 노드를 출력한다.
