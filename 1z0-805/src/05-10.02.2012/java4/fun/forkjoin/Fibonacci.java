package java4.fun.forkjoin;

public class Fibonacci {

	public int n;

	public Fibonacci(int n) {
		this.n = n;
	}

	public long calcular() {
		return fibonacci(n);
	}

	private long fibonacci(int n) {
//		System.out.println("Thread: " +
//				Thread.currentThread().getName() + " calculando " + n);
		if (n <= 1)
			return n;
		else 
			return fibonacci(n-1) + fibonacci(n-2);
	}
}
