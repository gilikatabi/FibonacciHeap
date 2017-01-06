package FibonacciHeap;

import org.junit.Test;

import org.junit.Assert;

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
}
