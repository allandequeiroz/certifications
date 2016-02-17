package java4.fun.jsr344;

/**
 * Números longos eram difíceis de ler e o Java 7 tornou isto mais fácil. 
 * Agora você pode separá-los usando um sublinhado (underline/underscore)
 * */
public class LiteraisNumericos {
	
	float pi = 3.14_15F;
	long hexBytes = 0xFF_EC_DE_5E;
	long hexWords = 0xCAFE_BABE;
	long maxLong = 0x7fff_ffff_ffff_ffffL;
	byte nybble = 0b00010_0101;//http://en.wikipedia.org/wiki/Nibble
	
	
	private void iniciarShow() {
		
		int telefone = 11_3171_3377;
		System.out.println("Telefone -> " + telefone);
		
	}

	public static void main(String[] args) {
		new LiteraisNumericos().iniciarShow();
	}

}
