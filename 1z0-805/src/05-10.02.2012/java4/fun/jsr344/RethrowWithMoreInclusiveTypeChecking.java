package java4.fun.jsr344;

public class RethrowWithMoreInclusiveTypeChecking {
	
	private void iniciarShow() throws PedidoException, CarrinhoException{
		try{
			throw new CarrinhoException();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) throws PedidoException, CarrinhoException {
		new RethrowWithMoreInclusiveTypeChecking().iniciarShow();
	}

}

class PedidoException extends Exception{
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return  "Erro no Pedido";
	}
}

class CarrinhoException extends Exception{
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return  "Erro no Carrinho";
	}
}