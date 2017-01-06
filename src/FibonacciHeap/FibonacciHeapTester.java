package FibonacciHeap;

import org.junit.Test;

import FibonacciHeap.FibonacciHeap.DeleteNullException;

import org.junit.Assert;

public class FibonacciHeapTester {
    @Test
    public void TestInsertAndDeleteMin() throws DeleteNullException {
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

    @Test(expected=DeleteNullException.class)
    public void deleteNullEmptyHeap() throws DeleteNullException {
        FibonacciHeap heap = new FibonacciHeap();
        heap.delete(null);
    }
    
    @Test(expected=DeleteNullException.class)
    public void deleteNullNonEmptyHeap() throws DeleteNullException {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(1);
        heap.delete(null);
    }
}
