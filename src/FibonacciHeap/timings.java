package FibonacciHeap;
import java.util.Random;


public class timings {
	
	public static void medida_insert(int size)
	{
		System.out.println("------ only insert ------");
		System.out.println("*** Starting Medida for m = " + size + " ***");
		FibonacciHeap heap = new FibonacciHeap();
		long start_time = System.nanoTime();
		for (int i = size; i > 0; i--){
			heap.insert(i);
		}
		long end_time = System.nanoTime();
		double difference = (end_time - start_time) / 1e6;
		System.out.println("Time: " + difference);
		System.out.println("Total Links: " + FibonacciHeap.totalLinks());
		System.out.println("Total Cuts: " + FibonacciHeap.totalCuts());
		System.out.println("Potential: " + heap.potential());
		
		// measure time
//		double[] timings = new double[10000];
//		for (int i = 0; i < timings.length; i++){
//			heap = new FibonacciHeap();
//			long start_time = System.nanoTime();
//			heap.arrayToHeap(arr);
//			long end_time = System.nanoTime();
//			double difference = (end_time - start_time);
//			timings[i] = difference;
//		}
//		System.out.println(Arrays.toString(timings));
//		System.out.println("Time: " + average(timings)/1e6);
	}
	
	public static void medida_insert_delete(int size)
	{
		System.out.println("------ first insert then delete ------");
		System.out.println("*** Starting Medida for m = " + size + " ***");
		FibonacciHeap heap = new FibonacciHeap();
		long start_time = System.nanoTime();
		for (int i = size; i > 0; i--){
			heap.insert(i);
		}
		for (int i = 0; i < size / 2; i++){
			heap.deleteMin();
		}
//		deleteAll(heap, heap.size());
		long end_time = System.nanoTime();
		double difference = (end_time - start_time) / 1e6;
		System.out.println("Time: " + difference);
		System.out.println("Total Links: " + FibonacciHeap.totalLinks());
		System.out.println("Total Cuts: " + FibonacciHeap.totalCuts());
		System.out.println("Potential: " + heap.potential());
	}
	
	public static double average(double[] numbers){
		int sum = 0;
        for(int i = 0; i < numbers.length ; i++)
                sum += numbers[i];
        double average = sum / numbers.length;
        return average;
	}
	
	public static void deleteAll(FibonacciHeap heap, int amount){
		int[]arr = randomIntArr(amount);
		for(int i:arr){
			heap.insert(i);
		}
		heap.deleteMin();
		for(int i = 0; i<amount-2; i++){
			if(heap.start.next.next == heap.start){
				heap.delete(heap.minimum.child);
			}
			else{
				heap.delete(heap.minimum.next);
			}
			
		}
	}
	
	public static int[] randomIntArr (int size){
		Random rnd = new Random();
		int[] res = new int[size];
		int cnt = 0;
		while(cnt < size){
			int val = rnd.nextInt(100000);
			boolean contains = false;
			for(int j = 0; j<cnt;j++){
				if (val == 0 || res[j] == val){
					contains = true;
					break;
				}
			}
			if(contains){
				continue;
				}
			else{
				res[cnt] = val;
				cnt++;
			}
		}
		return res;
	}
	
	public static void view (FibonacciHeap heap){
		String res = "";
		int[] arr = heap.countersRep();
		for(int i:arr){
			res+="["+i+"]";
		}
		System.out.println(res);
	}
	
	
	public static void main(String[] args){
		FibonacciHeap heap = new FibonacciHeap();
		for(int i = 1; i<66; i++){
			heap.insert(i);
		}
		heap.deleteMin();
		view(heap);
		heap.delete(heap.minimum.child.child.next.next);
		view(heap);
		heap.delete(heap.minimum.child.child.child.next.next.next);
		view(heap);
		heap.delete(heap.minimum.child.child.child.child.next.next);
		view(heap);
		heap.delete(heap.minimum.child.child.child.child.child.next);
		view(heap);
		heap.delete(heap.minimum.child.child.child.child.child);
		view(heap);
		System.out.println(FibonacciHeap.numberOfCuts);
		medida_insert_delete(2000);
	}
}
