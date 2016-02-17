package java4.fun.forkjoin;

import java.util.concurrent.ForkJoinPool;

import org.perf4j.StopWatch;

public class ForkJoinMain {

	public static void main(String[] args) {

		// Verificando a quantidade de processadores disponiveis
		int processadores = Runtime.getRuntime().availableProcessors();
		System.out.println("No de processadores: " + processadores);

		int n = 40;

		StopWatch stopWatch = new StopWatch();   
		Fibonacci bigProblem = new Fibonacci(n);

		FibonacciTask atividade = new FibonacciTask(bigProblem);
		ForkJoinPool pool = new ForkJoinPool(processadores);
		pool.invoke(atividade);

		long resultado = atividade.resultado;
		System.out.println("Resultado : " + resultado);

		stopWatch.stop();
		System.out.println("Tempo total : " + stopWatch.getElapsedTime());

	}
}
