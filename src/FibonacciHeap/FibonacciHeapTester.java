package FibonacciHeap;

import org.junit.Test;
import org.junit.Assert;

import FibonacciHeap.FibonacciHeap.HeapNode;

public class FibonacciHeapTester {
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
}
