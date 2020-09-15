import java.util.*;

//
// An implementation of a binary search tree.
//
// This tree stores both keys and values associated with those keys.
//
// More information about binary search trees can be found here:
//
// http://en.wikipedia.org/wiki/Binary_search_tree
//
// Note: Wikipedia is using a different definition of
//       depth and height than we are using.  Be sure
//       to read the comments in this file for the
//	 	 height function.
//
class BinarySearchTree <K extends Comparable<K>, V>  {

	public static final int BST_PREORDER  = 1;
	public static final int BST_POSTORDER = 2;
	public static final int BST_INORDER   = 3;

	// These are package friendly for the TreeView class
	BSTNode<K,V>	root;
	int		count;


	public BinarySearchTree () {
		root = null;
		count = 0;
	}


	//
	// Purpose:
	//
	// Insert a new Key:Value Entry into the tree.  If the Key
	// already exists in the tree, update the value stored at
	// that node with the new value.
	//
	// Pre-Conditions:
	// 	the tree is a valid binary search tree
	//
	public void insert (K k, V v) {
        BSTNode<K,V> nn = new BSTNode<K,V>(k, v);
        if(root == null){
            root = nn;
            count++;
            return;
        }
        BSTNode<K,V> prev = null;
        BSTNode<K,V> cur = root;
        while(cur != null){
            prev = cur;
            if(nn.key.compareTo(cur.key) < 0){
                cur = cur.left;
                if(cur == null){
                    prev.left = nn;
                    count++;
                    return;
                }
            }else if(nn.key.compareTo(cur.key) > 0){
                cur = cur.right;
                if(cur == null){
                    prev.right = nn;
                    count++;
                    return;
                }
            }else if(nn.key.compareTo(cur.key) == 0){
                cur.value = nn.value;
                return;
            }
        }
	}

	//
	// Purpose:
	//
	// Return the value stored at key.  Throw a KeyNotFoundException
	// if the key isn't in the tree.
	//
	// Pre-conditions:
	//	the tree is a valid binary search tree
	//
	// Returns:
	//	the value stored at key
	//
	// Throws:
	//	KeyNotFoundException if key isn't in the tree
	//
	public V find (K key) throws KeyNotFoundException {
		if(root == null){
		throw new KeyNotFoundException();
		}
		BSTNode<K,V> cur = root;
		while(cur != null){

			if(key.compareTo(cur.key) < 0){
				cur = cur.left;
			}else if(key.compareTo(cur.key) > 0){
				cur = cur.right;
			}else if(key.compareTo(cur.key) == 0){
				return cur.value;
			}
		}
		throw new KeyNotFoundException();
	}

	//
	// Purpose:
	//
	// Return the number of nodes in the tree.
	//
	// Returns:
	//	the number of nodes in the tree.
	public int size() {
		return count;
	}

	//
	// Purpose:
	//	Remove all nodes from the tree.
	//
	public void clear() {
        root = null;
	}

	//
	// Purpose:
	//
	// Return the height of the tree.  We define height
	// as being the number of nodes on the path from the root
	// to the deepest node.
	//
	// This means that a tree with one node has height 1.
	//
	// Examples:
	//	See the assignment PDF and the test program for
	//	examples of height.
	//
	public int height() {
		return height(root, 0);
	}

	private int height(BSTNode<K,V> curNode, int curHeight){
		if(curNode == null){
			return curHeight;
		}
		BSTNode<K,V> LeftTree = curNode.left;
		BSTNode<K,V> RightTree = curNode.right;

		if(height(LeftTree, curHeight) >= height(RightTree, curHeight)){
			curHeight++;
			return height(LeftTree, curHeight);
		}else{
			curHeight++;
			return height(RightTree, curHeight);
		}
	}

	//
	// Purpose:
	//
	// Return a list of all the key/value Entrys stored in the tree
	// The list will be constructed by performing a level-order
	// traversal of the tree.
    //
    // A level order traversal of a tree cannot be done without the help
    //  of a secondary data structure
    //
    // It is commonly implemented using a queue of nodes as the secondary
    //  data structure.
    //  You will still be adding the "visited" elements to l as you do in the other
    //  traversal methods but you will create an additional q to hold nodes still to visit
    //
    //  From wikipedia (they call it breadth-first), the algorithm for level order is:
    //
    //    levelorder()
    //        q = empty queue
    //        q.enqueue(root)
    //        while not q.empty do
    //            node := q.dequeue()
    //            visit(node)
    //            if node.left != null then
    //                  q.enqueue(node.left)
    //            if node.right != null then
    //                  q.enqueue(node.right)
    //
    // Note that you can use the Java LinkedList as a Queue
    //  and then use only the removeFirst() and addLast() methods on q
    //
	public List<Entry<K,V> >	entryList() {
		List<Entry<K,V> > l = new LinkedList<Entry<K,V> >();
		LinkedList<BSTNode<K,V> > q = new LinkedList<BSTNode<K,V>>();
		q.add(root);
		while(!q.isEmpty()){
			BSTNode<K,V> nn = q.removeFirst();
			Entry<K,V> e = new Entry<K,V>(nn.key,nn.value);
			l.add(e);
			if(nn.left != null){
				q.add(nn.left);
			}
			if(nn.right != null){
				q.add(nn.right);
			}
		}
		return l;
	}

	//
	// Purpose:
	//
	// Return a list of all the key/value Entrys stored in the tree
	// The list will be constructed by performing a traversal
	// specified by the parameter which.
	//
	// If which is:
	//	BST_PREORDER	perform a pre-order traversal
	//	BST_POSTORDER	perform a post-order traversal
	//	BST_INORDER	perform an in-order traversal
	//
	public List<Entry<K,V> >	entryList (int which) {
		List<Entry<K,V> > l = new LinkedList<Entry<K,V> >();

		if(which == BST_PREORDER){
		doPreOrder(root, l);
		}else if(which == BST_POSTORDER){
		doPostOrder(root, l);
		}else if(which == BST_INORDER){
		doInOrder(root, l);
		}

		return l;
	}

	// Your instructor had the following private methods in their solution:
	// private void doInOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
	// private void doPreOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
	// private void doPostOrder (BSTNode<K,V> n, List <Entry<K,V> > l);
	// private int doHeight (BSTNode<K,V> t)

	private void doPreOrder(BSTNode<K,V> cur, List<Entry<K,V> > l){
		if(cur == null){
			return;
		}
		Entry<K,V> nn = new Entry<K,V>(cur.key, cur.value); 
		l.add(nn);

			doPreOrder(cur.left, l);

			doPreOrder(cur.right, l);

		
	}

	private void doInOrder(BSTNode<K,V> cur, List<Entry<K,V> > l){
		if(cur == null){
			return;
		}
			doInOrder(cur.left, l);
			Entry<K,V> nn = new Entry<K,V>(cur.key, cur.value); 
			l.add(nn);
			doInOrder(cur.right, l);
		
	}

	private void doPostOrder(BSTNode<K,V> cur, List<Entry<K,V> > l){
		if(cur == null){
			return;
		}
			doPostOrder(cur.left, l);

			doPostOrder(cur.right, l);
		
		Entry<K,V> nn = new Entry<K,V>(cur.key, cur.value); 
		l.add(nn);
	}

}
