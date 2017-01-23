package FibonacciHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;
import org.junit.Assert;

import FibonacciHeap.FibonacciHeap.HeapNode;

public class FibonacciHeapTester {
	private static Random rand = new Random();
    @Test
    public void TestInsertAndDeleteMin() throws IllegalArgumentException {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(9);
        heap.insert(2);
        heap.insert(47);
        heap.insert(13);
        heap.insert(7);
        heap.insert(5);
        heap.insert(22);
        heap.insert(1);
        heap.insert(83);
        Assert.assertEquals(1, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(2, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(5, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(7, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(9, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(13, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(22, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(47, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(83, heap.findMin().getKey());
        heap.deleteMin();
        Assert.assertEquals(null, heap.findMin());
    }

    @Test(expected=IllegalArgumentException.class)
    public void deleteNullEmptyHeap() throws IllegalArgumentException {
        FibonacciHeap heap = new FibonacciHeap();
        heap.delete(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void deleteNullNonEmptyHeap() throws IllegalArgumentException {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(1);
        heap.delete(null);
    }
    
    @Test
    public void meld() throws IllegalArgumentException {
        FibonacciHeap heap1 = new FibonacciHeap();
        heap1.insert(9);
        heap1.insert(2);
        heap1.insert(47);
        heap1.insert(13);
        heap1.insert(7);
        heap1.insert(5);
        heap1.insert(22);
        heap1.insert(1);
        heap1.insert(83);
        FibonacciHeap heap2 = new FibonacciHeap();
        heap2.insert(60);
        heap2.insert(18);
        heap2.insert(10);
        heap2.insert(4);
        heap2.insert(30);
        heap2.insert(90);
        heap2.insert(50);
        heap1.meld(heap2);
        Assert.assertEquals(1, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(2, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(4, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(7, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(9, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(10, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(13, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(18, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(22, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(30, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(47, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(50, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(60, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(83, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(90, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(null, heap1.findMin());
    }
    
    @Test
    public void meldWithEmptyHeap() throws IllegalArgumentException {
        FibonacciHeap heap1 = new FibonacciHeap();
        heap1.insert(9);
        heap1.insert(2);
        heap1.insert(47);
        heap1.insert(13);
        heap1.insert(7);
        heap1.insert(5);
        heap1.insert(22);
        heap1.insert(1);
        heap1.insert(83);
        FibonacciHeap heap2 = new FibonacciHeap();
        heap1.meld(heap2);
        Assert.assertEquals(1, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(2, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(7, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(9, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(13, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(22, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(47, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(83, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(null, heap1.findMin());

    }
    
    @Test
    public void EmptyHeapMeldWithFullHeap() throws IllegalArgumentException {
        FibonacciHeap heap1 = new FibonacciHeap();
        FibonacciHeap heap2 = new FibonacciHeap();
        heap2.insert(9);
        heap2.insert(2);
        heap2.insert(47);
        heap2.insert(13);
        heap2.insert(7);
        heap2.insert(5);
        heap2.insert(22);
        heap2.insert(1);
        heap2.insert(83);
        heap1.meld(heap2);
        Assert.assertEquals(1, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(2, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(7, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(9, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(13, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(22, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(47, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(83, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(null, heap1.findMin());
    }
    
    @Test
    public void EmptyHeapMeldWithEmptyHeap() throws IllegalArgumentException {
        FibonacciHeap heap1 = new FibonacciHeap();
        FibonacciHeap heap2 = new FibonacciHeap();
        heap1.meld(heap2);
        Assert.assertEquals(null, heap1.findMin());
    }
    
    @Test
    public void oneWithOneMeld() throws IllegalArgumentException {
        FibonacciHeap heap1 = new FibonacciHeap();
        FibonacciHeap heap2 = new FibonacciHeap();
        heap1.insert(9);
        heap2.insert(2);
        heap1.meld(heap2);
        Assert.assertEquals(2, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(9, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(null, heap1.findMin());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void meldWithNull() throws IllegalArgumentException {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(1);
        heap.meld(null);
    }
    
    @Test
    public void decreaseKeyChangeMinTester() throws IllegalArgumentException {
        FibonacciHeap heap1 = new FibonacciHeap();
        HeapNode nodeToDecreaseKey = heap1.insert(9);
        heap1.insert(2);
        heap1.insert(47);
        heap1.insert(13);
        heap1.insert(7);
        heap1.insert(5);
        heap1.insert(22);
        heap1.insert(83);
        heap1.decreaseKey(nodeToDecreaseKey, 8);
        Assert.assertEquals(1, heap1.findMin().getKey());

    }
    
    @Test
    public void decreaseKeyTester() throws IllegalArgumentException {
        FibonacciHeap heap1 = new FibonacciHeap();
        HeapNode nodeToDecreaseKey1 = heap1.insert(9);
        HeapNode nodeToDecreaseKey2 = heap1.insert(15);
        HeapNode nodeToDecreaseKey3 = heap1.insert(47);
        HeapNode nodeToDecreaseKey4 = heap1.insert(13);
        HeapNode nodeToDecreaseKey5 = heap1.insert(7);
        HeapNode nodeToDecreaseKey6 =  heap1.insert(5);
        HeapNode nodeToDecreaseKey7 = heap1.insert(22);
        HeapNode nodeToDecreaseKey8 = heap1.insert(83);
        heap1.decreaseKey(nodeToDecreaseKey1, 0);
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey2, 0);
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey3, 7);
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey4, 3);
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey5, 5);
        Assert.assertEquals(2, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey6, 0);
        Assert.assertEquals(2, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey7, 4);
        Assert.assertEquals(2, heap1.findMin().getKey());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void decreaseKeyNull() throws IllegalArgumentException {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(1);
        heap.decreaseKey(null, 8);
    }
    
    @Test
    public void decreaseKeyAndDelete() throws IllegalArgumentException {
        FibonacciHeap heap1 = new FibonacciHeap();
        HeapNode nodeToDecreaseKey1 = heap1.insert(9);
        HeapNode nodeToDecreaseKey2 = heap1.insert(15);
        HeapNode nodeToDecreaseKey3 = heap1.insert(47);
        HeapNode nodeToDecreaseKey4 = heap1.insert(13);
        HeapNode nodeToDecreaseKey5 = heap1.insert(7);
        HeapNode nodeToDecreaseKey6 =  heap1.insert(5);
        HeapNode nodeToDecreaseKey7 = heap1.insert(22);
        HeapNode nodeToDecreaseKey8 = heap1.insert(83);
        heap1.decreaseKey(nodeToDecreaseKey1, 0);
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey2, 0);
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey3, 7);
        Assert.assertEquals(5, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(7, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey4, 3);
        Assert.assertEquals(7, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey5, 5);
        Assert.assertEquals(2, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(9, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(10, heap1.findMin().getKey());
        heap1.deleteMin();
        Assert.assertEquals(15, heap1.findMin().getKey());
        heap1.decreaseKey(nodeToDecreaseKey7, 4);
        Assert.assertEquals(15, heap1.findMin().getKey());
    }
    
    @Test
    public void decreaseKeyAndDelete2() throws IllegalArgumentException {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(4);
        heap.insert(2);
        HeapNode nodeToDecrease1 = heap.insert(3);
        HeapNode nodeToDecrease2 = heap.insert(5);
        heap.insert(1);
        heap.deleteMin();
        heap.decreaseKey(nodeToDecrease1, 2);
        heap.decreaseKey(nodeToDecrease2, 5);
        heap.deleteMin();
        Assert.assertEquals(1, heap.findMin().getKey());
    }
    
    @Test
    public void cutBug() {
        FibonacciHeap heap = new FibonacciHeap();
        HeapNode nodeToDecrease1 = heap.insert(4);
        HeapNode nodeToDecrease2 = heap.insert(5);
        heap.insert(1);
        heap.deleteMin();
        heap.decreaseKey(nodeToDecrease2, 2);
        heap.deleteMin();
        heap.insert(100);
        heap.deleteMin();
        Assert.assertEquals(100, heap.findMin().getKey());
    }
    
    @Test
    public void delete() throws IllegalArgumentException {
        FibonacciHeap heap = new FibonacciHeap();
        HeapNode nodeToDelete3 = heap.insert(5);
        heap.insert(2);
        HeapNode nodeToDelete1 = heap.insert(3);
        HeapNode nodeToDelete2 = heap.insert(4);
        heap.insert(1);
        heap.deleteMin();
        heap.delete(nodeToDelete1);
        Assert.assertEquals(2, heap.findMin().getKey());
        heap.deleteMin();
        heap.delete(nodeToDelete2);
        Assert.assertEquals(5, heap.findMin().getKey());
        heap.delete(nodeToDelete3);
        Assert.assertEquals(null, heap.findMin());
    }
    
    @Test
    public void numberOfTreeTest() throws IllegalArgumentException {
        FibonacciHeap heap = new FibonacciHeap();
        HeapNode nodeToDecrease3 = heap.insert(4);
        heap.insert(2);
        HeapNode nodeToDecrease1 = heap.insert(3);
        HeapNode nodeToDecrease2 = heap.insert(5);
        heap.insert(1);
        heap.deleteMin();
        Assert.assertEquals(1, heap.potential());
        heap.decreaseKey(nodeToDecrease1, 2);
        Assert.assertEquals(2, heap.potential());
        heap.decreaseKey(nodeToDecrease2, 5);
        Assert.assertEquals(3, heap.potential());
        heap.decreaseKey(nodeToDecrease3, 4);
        Assert.assertEquals(4, heap.potential());

    }
    
    @Test
    public void potentialTest() throws IllegalArgumentException {
    	FibonacciHeap heap = new FibonacciHeap();
        HeapNode nodeToDecreaseKey9 = heap.insert(10);
        HeapNode nodeToDecreaseKey1 = heap.insert(9);
        HeapNode nodeToDecreaseKey2 = heap.insert(19);
        HeapNode nodeToDecreaseKey3 = heap.insert(47);
        HeapNode nodeToDecreaseKey4 = heap.insert(13);
        HeapNode nodeToDecreaseKey5 = heap.insert(7);
        HeapNode nodeToDecreaseKey6 =  heap.insert(5);
        HeapNode nodeToDecreaseKey7 = heap.insert(22);
        HeapNode nodeToDecreaseKey8 = heap.insert(83);
        heap.deleteMin();
        Assert.assertEquals(7, heap.findMin().getKey());
        heap.decreaseKey(nodeToDecreaseKey2, 11);
        Assert.assertEquals(4, heap.potential());
        Assert.assertEquals(7, heap.findMin().getKey());
        heap.decreaseKey(nodeToDecreaseKey8, 70);
        Assert.assertEquals(7, heap.potential());        
        heap.decreaseKey(nodeToDecreaseKey9, 10);
        Assert.assertEquals(0, heap.findMin().getKey());
        Assert.assertEquals(7, heap.potential());
    }
    
    @Test
    public void counterArrayTest() throws IllegalArgumentException {
    	FibonacciHeap heap = new FibonacciHeap();
        HeapNode nodeToDecreaseKey9 = heap.insert(10);
        HeapNode nodeToDecreaseKey1 = heap.insert(9);
        HeapNode nodeToDecreaseKey2 = heap.insert(19);
        HeapNode nodeToDecreaseKey3 = heap.insert(47);
        HeapNode nodeToDecreaseKey4 = heap.insert(13);
        HeapNode nodeToDecreaseKey5 = heap.insert(7);
        HeapNode nodeToDecreaseKey6 =  heap.insert(5);
        HeapNode nodeToDecreaseKey7 = heap.insert(22);
        HeapNode nodeToDecreaseKey8 = heap.insert(83);
        heap.deleteMin();
        Assert.assertEquals(1, heap.countersRep()[3]);
        heap.decreaseKey(nodeToDecreaseKey2, 11);
        Assert.assertEquals(1, heap.countersRep()[1]);
        Assert.assertEquals(1, heap.countersRep()[3]);
        heap.decreaseKey(nodeToDecreaseKey8, 70);
        Assert.assertEquals(1, heap.countersRep()[0]);
        Assert.assertEquals(1, heap.countersRep()[1]);
        Assert.assertEquals(1, heap.countersRep()[3]);        
        heap.decreaseKey(nodeToDecreaseKey9, 10);
        Assert.assertEquals(3, heap.countersRep()[0]);
        Assert.assertEquals(1, heap.countersRep()[1]);
        Assert.assertEquals(1, heap.countersRep()[2]);

    }
    
    @Test
    public void insertAllThenDeleteAllRandomTest() {
    	FibonacciHeap heap = new FibonacciHeap();
    	int heapSize = rand.nextInt(100) + 1;
    	ArrayList<Integer> dataList = new ArrayList<Integer>();
    	for (int i=0; i < heapSize; i++) {
    		int n = rand.nextInt(10000000);
    		heap.insert(n);
    		dataList.add(n);
    	}
    	Collections.sort(dataList);
    	for (int i=0; i < heapSize; i++) {
    		//System.out.println(i +" + " + dataList.get(0) + ", " + heap.findMin().getKey());
    		Assert.assertEquals((int)dataList.get(0), (int)heap.findMin().getKey());
    		heap.deleteMin();
    		dataList.remove(0);
    	}
    	
    }
    
    @Test
    public void insertDeleteRandomTest() {
    	FibonacciHeap heap = new FibonacciHeap();
    	int numOfSteps = 2 * (rand.nextInt(100) + 1);
    	int n=0;
    	for (int i=0; i < numOfSteps; i++) {
    		if (i%2 == 0) {
    			n = rand.nextInt(10000000);
    			heap.insert(n);
    		} else {
    			Assert.assertEquals(n, (int)heap.findMin().getKey());
    			heap.deleteMin();
    		}
    	}
    	Assert.assertEquals(0, heap.size());
    }
    
    
    @Test
    public void deleteMinBug() {
    	FibonacciHeap heap = new FibonacciHeap();
        heap.insert(6);
        heap.insert(60);
        heap.insert(38);
        heap.insert(64);
        heap.insert(71);
        heap.insert(20);
        heap.insert(46);
        heap.insert(99);
        heap.insert(63);
        heap.insert(32);
		Assert.assertEquals(6, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(20, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(32, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(38, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(46, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(60, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(63, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(64, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(71, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(99, heap.findMin().getKey());
		heap.deleteMin();
		Assert.assertEquals(null, heap.findMin());
    }
    
    @Test
    public void miniRandInsertDeletMin() {
    	FibonacciHeap heap = new FibonacciHeap();
    	int heapSize = 10;
    	ArrayList<Integer> dataList = new ArrayList<Integer>();
    	for (int i=0; i < heapSize; i++) {
    		int n = rand.nextInt(100);
        	System.out.println("insert " + i +" + " + "number" + n);
    		heap.insert(n);
    		dataList.add(n);
    	}
    	Collections.sort(dataList);
    	for (int i=0; i < dataList.size(); i++) {
            if ((int)dataList.get(0) != (int)heap.findMin().getKey()) {
            	System.out.println("problem " + i +" + " + dataList.get(0) + ", " + heap.findMin().getKey());
            }
    		Assert.assertEquals((int)dataList.get(0), (int)heap.findMin().getKey()); //TODO I believe this bug is the same as the former.
    		heap.deleteMin();
    		dataList.remove(0);
    	}
    }
    
    
    @Test
    public void randMeldTest() {
    	FibonacciHeap firstHeap = new FibonacciHeap();
    	int firstHeapSize = rand.nextInt(100) + 1;
    	FibonacciHeap secondHeap = new FibonacciHeap();
    	int secondHeapSize = rand.nextInt(100) + 1;
    	ArrayList<Integer> dataList = new ArrayList<Integer>();
    	for (int i=0; i < firstHeapSize; i++) {
    		int n = rand.nextInt(10000000);
    		firstHeap.insert(n);
    		dataList.add(n);
    	}
    	for (int i=0; i < secondHeapSize; i++) {
    		int n = rand.nextInt(10000000);
    		secondHeap.insert(n);
    		dataList.add(n);
    	}
    	Collections.sort(dataList);
    	firstHeap.meld(secondHeap);
    	Assert.assertEquals(firstHeapSize + secondHeapSize, firstHeap.size());
    	for (int i=0; i < dataList.size(); i++) {
    		//System.out.println(i +" + " + dataList.get(0) + ", " + firstHeap.findMin().getKey());
            if ((int)dataList.get(0) != (int)firstHeap.findMin().getKey()) {
            	//System.out.println("problem!!! " + i +" + " + dataList.get(0) + ", " + firstHeap.findMin().getKey());
            }
    		Assert.assertEquals((int)dataList.get(0), (int)firstHeap.findMin().getKey()); //TODO I believe this bug is the same as the former.
    		firstHeap.deleteMin();
    		dataList.remove(0);
    	}
    }
    
    @Test
    public void removeHalfAddHaldTest() {
    	FibonacciHeap heap = new FibonacciHeap();
    	int heapSize = rand.nextInt(100) + 1;
    	ArrayList<Integer> dataList = new ArrayList<Integer>();
    	for (int i=0; i < heapSize; i++) {
    		int n = rand.nextInt(10000000);
    		heap.insert(n);
    		dataList.add(n);
    	}
    	Collections.sort(dataList);
    	for (int i=0; i < heapSize / 2; i++) {
    		Assert.assertEquals((int)dataList.get(0), (int)heap.findMin().getKey());
    		heap.deleteMin();
    		dataList.remove(0);
    	}
    	
    	for (int i=0; i < heapSize / 2; i++) {
    		int n = rand.nextInt(10000000);
    		heap.insert(n);
    		dataList.add(n);
    	}
    	Collections.sort(dataList);
    	for (int i=0; i < dataList.size(); i++) {
    		Assert.assertEquals((int)dataList.get(0), (int)heap.findMin().getKey());
    		heap.deleteMin();
    		dataList.remove(0);
    	}
    }
    
}
