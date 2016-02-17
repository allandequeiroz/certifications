package java4.fun.jsr344;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Nada será alterado em relação ao código, mas sim em relação a interpretação do compilador 
 * em um caso especifico que em versões anteriores geravam mensagens de aviso (warning). 
 * 
 * Em Java arrays e tipos genéricos não se relacionam muito bem, códigos como:
 * List<Set<Integer>> listOfSets = Arrays.asList(aSet); 
 * 
 * Geravam um Warning parecido com este “Note: SimplificacaoVarargs.java uses unchecked or unsafe operations.”. 
 * Porém não existe nada de errado no código, ele compila e executa sem problemas, mas lança essa mensagem de aviso.
 * 
 * Na verdade, o que acontece é que antes de o compilador gerar o bytecode é feita uma conversão no 
 * programa que modifica a linha 7, que internamente passa a valer:
 * List<Set<Integer>> listOfSets = Arrays.asList(new Set[]{aSet});
 * 
 * Note que nessa conversão o Set usado para construir o array não contém mais a informação de tipo 
 * (em Java não é permitida a criação de um array usando generics) o que provoca o warning.
 * 
 * No Java 7 esse problema foi solucionado e códigos compilados na nova versão não terão mais a mensagem de warning exibida.
 * */
public class SimplificacaoVarargs {

	@SuppressWarnings("unused")
	private void iniciarShow() {
		
		Set<Integer> set = new HashSet<>();
		List<Set<Integer>> list = Arrays.asList(set);
		
	}

	public static void main(String[] args) {
		new SimplificacaoVarargs().iniciarShow();
	}


}
