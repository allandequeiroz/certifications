package java4.fun.forkjoin;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long>{

	private static final long serialVersionUID = 1L;

	private static final int LIMITE_TRABALHO_TRIVIAL = 5;

	private Fibonacci problema;
	public long resultado;

	public FibonacciTask(Fibonacci problem) {
		this.problema = problem;
	}

	@Override
	public Long compute() {
		if (problema.n < LIMITE_TRABALHO_TRIVIAL) { 
			resultado = problema.calcular();
		}
		else {
			FibonacciTask worker1 = new FibonacciTask(new Fibonacci(problema.n-1));
			FibonacciTask worker2 = new FibonacciTask(new Fibonacci(problema.n-2));
			worker1.fork();
			resultado = worker2.compute() + worker1.join();

		}
		return resultado;
	}

}
