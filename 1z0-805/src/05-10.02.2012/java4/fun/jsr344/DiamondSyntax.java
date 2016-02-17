package java4.fun.jsr344;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Quando declaramos genéricos precisamos especificar o tipo que queremos (a classe que vamos usar) 
 * no lado esquerdo (da atribuição) e também no lado direito (da atribuição). 
 * Isso não será mais preciso, colocando os sinais de generics <> do lado direito automaticamente o 
 * compilador irá saber quais as classes que deve usar, no caso as mesmas que foram declaradas no lado esquerdo.
 * */
public class DiamondSyntax{

	@SuppressWarnings("unused")
	private void iniciarShow() {
		
		List<DiamondSyntax> list = new ArrayList<>();
		
		Map<Integer, String> map = new HashMap<>();
		
		 
	}
	
	public static void main(String[] args) {
		new DiamondSyntax().iniciarShow();
	}

	

}
