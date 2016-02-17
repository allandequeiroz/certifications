package java4.fun.forkjoin;

import org.perf4j.StopWatch;

public class TradicionalMain {

	public static void main(String[] args) throws Exception {

		int n = 40;

		StopWatch stopWatch = new StopWatch();
		Fibonacci fibonacci = new Fibonacci(n); 

		long resultado = fibonacci.calcular();
		stopWatch.stop();

		System.out.println("Calculando Fibonacci com o n�mero : " + n);
		System.out.println("Resultado : " + resultado);
		System.out.println("Tempo total : " + stopWatch.getElapsedTime());

	}
}

/*
 * Calculando Fibonacci com o n�mero : 50
 * Resultado : 12586269025
 * Tempo total : 77535
 * 
 * */

