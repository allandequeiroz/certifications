package java4.fun.jsr344;

/**
 * Até a versão 6 do Java quando utilizado um teste no bloco Switch/Case, 
 * era apenas possível utilizar tipos como byte, char, short, int ou enum. 
 * A partir da versão 7, podemos tambem utilizar o tipo String
 * */
public class SwitchComString {

	private void iniciarShow(String chaveSwitch) {
		
		switch (chaveSwitch) {
			case "legal":
				System.out.println("Java 7 eh legal!");
				break;
			case "muito legal":
			case "MUITO LEGAL":
				System.out.println("Java 7 eh muito legal!");
				break;
			default:
				break;
			}
		
	}
	
	public static void main(String[] args) {
		new SwitchComString().iniciarShow("muito legal");
	}

}
