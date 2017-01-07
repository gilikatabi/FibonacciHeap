package FibonacciHeap;

/**
 * FibonacciHeap
 *
 * An implementation of fibonacci heap over non-negative integers.
 */
public class FibonacciHeap {
    
    private int size;
    private HeapNode start;
    private HeapNode minimum;
    
    public FibonacciHeap(){
        this.size = 0;
        this.start = null;
        this.minimum = null;
    }
    
    /**
    * public boolean empty()
    *
    * precondition: none
    * 
    * The method returns true if and only if the heap
    * is empty.
    *   
    */
    public boolean empty()
    {
        return (this.size == 0);
    }

   /**
    * public HeapNode insert(int key)
    *
    * Creates a node (of type HeapNode) which contains the given key, and inserts it into the heap. 
    */
    public HeapNode insert(int key)
    {    
        this.size++;
        
        HeapNode newNode = new HeapNode(key);
        if (this.start == null){
            newNode.next = newNode;
            newNode.prev = newNode;
            this.minimum = newNode;
        } else {
            newNode.next = this.start;
            newNode.prev = this.start.prev;
            newNode.next.prev = newNode;
            newNode.prev.next = newNode;
            if (key < this.minimum.key) {
                this.minimum = newNode;
            }
        }

        this.start = newNode;
        return newNode;
    }

   /**
    * public void deleteMin()
    *
    * Delete the node containing the minimum key.
    *
    */
    public void deleteMin() throws IllegalArgumentException
    {
        if (this.minimum == null) {
            throw new IllegalArgumentException();
        }
        
        this.size--;
        
        if (this.size == 0) {
            this.start = null;
            this.minimum = null;
        } else {
            if (this.start == this.minimum){
                this.start = this.minimum.next;
            }
            
            if (this.start == this.minimum) {
                this.start = this.minimum.child;
            } else {
                this.minimum.prev.next = this.minimum.next;
                this.minimum.next.prev = this.minimum.prev;
                this.meldHeapToLinkedList(this.minimum.child);
            }

            this.minimum = null;
            this.consolidate();
        }
    }

   /**
    * public HeapNode findMin()
    *
    * Return the node of the heap whose key is minimal. 
    *
    */
    public HeapNode findMin()
    {
        return this.minimum;
    } 
    
   /**
    * public void meld (FibonacciHeap heap2)
    *
    * Meld the heap with heap2
    *
    */
    public void meld(FibonacciHeap heap2) throws IllegalArgumentException
    {
        if (heap2 == null) {
            throw new IllegalArgumentException();
        }
        
        if (heap2.size == 0) {
            return;
        }
        
        if (this.size == 0 || heap2.minimum.getKey() < this.minimum.getKey()) {
            this.minimum = heap2.minimum;
        }
        
        this.meldHeapToLinkedList(heap2.start);
        this.size += heap2.size;
    }
    
    
    public void meldHeapToLinkedList(HeapNode firstNode) {
        
        if (firstNode == null) {
            return;
        }
        if (this.start != null) {
            HeapNode lastChild = firstNode.prev;
            HeapNode lastNodeOfHeap = this.start.prev;
            
            this.start.prev = lastChild;
            lastNodeOfHeap.next = firstNode;
            firstNode.prev = lastNodeOfHeap;
            lastChild.next = this.start;
        } else {
            this.start = firstNode;
        }
    }

   /**
    * public int size()
    *
    * Return the number of elements in the heap
    *   
    */
    public int size()
    {
        return this.size;
    }
        
    /**
    * public int[] countersRep()
    *
    * Return a counters array, where the value of the i-th entry is the number of trees of order i in the heap. 
    * 
    */
    public int[] countersRep()
    {
        int[] arr = new int[42];
        return arr; //     to be replaced by student code
    }

   /**
    * public void arrayToHeap()
    *
    * Insert the array to the heap. Delete previous elemnts in the heap.
    * 
    */
    public void arrayToHeap(int[] array)
    {
        return; //     to be replaced by student code
    }
    
   /**
    * public void delete(HeapNode x)
    *
    * Deletes the node x from the heap. 
    *
    */
    public void delete(HeapNode nodeToDelete) throws IllegalArgumentException
    {
        if (nodeToDelete == null) {
            throw new IllegalArgumentException();
        }
        int delta = nodeToDelete.key - this.minimum.key - 1;
        decreaseKey(nodeToDelete, delta);
        
        this.deleteMin();
    }
    
    
    /**
     * public HeapNode linkTrees(HeapNode node1, HeapNode node2) {
     *
     * The function gets two HeapNode, find the one with minimal key
     * and make him the parent of the bigger one.
     */
    public HeapNode linkTrees(HeapNode node1, HeapNode node2) {

        if (node2.key < node1.key) {
            HeapNode tmp;
            tmp = node1;
            node1 = node2;
            node2 = tmp;
        }
        
        if (this.start == node2) {
            this.start = node2.next;
        }
        
        node2.prev.next = node2.next;
        node2.next.prev = node2.prev;
        
        
        node2.parent = node1;
        if (node1.child == null) {
            node1.child = node2;
            node2.next = node2;
            node2.prev = node2;
        } else {
            node2.next = node1.child;
            node1.child = node2;
            node2.prev = node2.next.prev;
            node2.next.prev = node2;
            node2.prev.next = node2;    
        }
        
        node1.rank += 1;
        return node1;
    }
    
    public void consolidate() {
        HeapNode[] linkArray = new HeapNode[100];//TODO - not 100, but logn
        HeapNode currentNode = this.start;
        do {
            HeapNode linkTree = currentNode;
            currentNode = currentNode.next;

            while (linkArray[linkTree.rank] != null) {
                HeapNode prevNode = linkArray[linkTree.rank];
                linkArray[linkTree.rank] = null;
                linkTree = linkTrees(linkTree, prevNode);
            }
            linkArray[linkTree.rank] = linkTree;
            if (this.minimum == null || linkTree.key < this.minimum.key) {
            	this.minimum = linkTree;
            }
        } while (currentNode != this.start && currentNode.parent != this.start);
    }

   /**
    * public void decreaseKey(HeapNode x, int delta)
    *
    * The function decreases the key of the node x by delta. The structure of the heap should be updated
    * to reflect this chage (for example, the cascading cuts procedure should be applied if needed).
    */
    public void decreaseKey(HeapNode nodeToDecrease, int delta) throws IllegalArgumentException
    {
        if (nodeToDecrease == null || delta < 0) {
            throw new IllegalArgumentException();
        }
        nodeToDecrease.key -= delta;
        
        if (this.minimum.key > nodeToDecrease.key) {
            this.minimum = nodeToDecrease;
        }
    }

   /**
    * public int potential() 
    *
    * This function returns the current potential of the heap, which is:
    * Potential = #trees + 2*#marked
    * The potential equals to the number of trees in the heap plus twice the number of marked nodes in the heap. 
    */
    public int potential() 
    {    
        return 0; // should be replaced by student code
    }

   /**
    * public static int totalLinks() 
    *
    * This static function returns the total number of link operations made during the run-time of the program.
    * A link operation is the operation which gets as input two trees of the same rank, and generates a tree of 
    * rank bigger by one, by hanging the tree which has larger value in its root on the tree which has smaller value 
    * in its root.
    */
    public static int totalLinks()
    {    
        return 0; // should be replaced by student code
    }

   /**
    * public static int totalCuts() 
    *
    * This static function returns the total number of cut operations made during the run-time of the program.
    * A cut operation is the operation which diconnects a subtree from its parent (during decreaseKey/delete methods). 
    */
    public static int totalCuts()
    {    
        return 0; // should be replaced by student code
    }

   /**
    * public class HeapNode
    * 
    * If you wish to implement classes other than FibonacciHeap
    * (for example HeapNode), do it in this file, not in 
    * another file 
    *  
    */
    public class HeapNode{
        private HeapNode next;
        private HeapNode prev;
        private int key;
        private HeapNode parent;
        private HeapNode child;
        private int rank;

        public HeapNode(int key) {
            this.key = key;
            this.next = null;
            this.prev = null;
            this.parent = null;
            this.child = null;
            this.rank = 0;
        }
        
        public int getKey(){
            return this.key;
        }
    }
}
