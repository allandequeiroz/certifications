package java4.fun.jsr344;

/**
 * Agora, alem de podemos usar as literais decimais, octais e hexadecimais,
 * podemos tambem criar literais binarias;
 * */
public class LiteraisBinarios {
	
	byte aByte = (byte)0b00100001;//8 bits
	
	short aShort = (short)0b1010000101000101;//16 bits
	
	int aInt1 = 0b10100001010001011010000101000101;//32 bits
	
	long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;//0b 64 bits
	long bLong = 0B1010000101000101101000010100010110100001010001011010000101000101L;//0B 64 bits
	
	byte idade = 29;
	
	private void iniciarShow() {
		
		switch (idade) {
			case 0b00100001:imp(0b00100001); break;
			case 0b00011101:imp(0b00011101); break;
			case 0b00000001:imp(0b11000000); break;
		}
	}
	
	private void imp(int anos){
		System.out.printf("Voce tem %s anos", anos);
	}

	public static void main(String[] args) {
		new LiteraisBinarios().iniciarShow();
	}
}
