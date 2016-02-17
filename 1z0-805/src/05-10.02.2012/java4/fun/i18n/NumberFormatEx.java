package java4.fun.i18n;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberFormatEx {
	
	private Locale locale;
	
	static public void main(String[] args) {
		new NumberFormatEx().iniciarShow();
	}
	
	private void iniciarShow(){
		exemploPtBR();
		exemploFrFR();
		exemploDeDE();
		exemploEnUS();
	}
	
	private void exemploPtBR(){
		locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
		mostrar();
	}
	
	private void exemploFrFR(){
		locale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
		mostrar();
	}
	
	private void exemploDeDE(){
		locale = new Locale.Builder().setLanguage("de").setRegion("DE").build();
		mostrar();
	}
	
	private void exemploEnUS(){
		locale = new Locale.Builder().setLanguage("en").setRegion("US").build();
		mostrar();
	}
	
	private void mostrar(){
		mostrarNumero();
		mostrarMoeda();
		mostrarPorcentagem();
		System.out.println();
	}

	public void mostrarNumero() {
		Integer quantidade = new Integer(123456);
		Double montante = new Double(345987.246);
		
		NumberFormat format = NumberFormat.getNumberInstance(locale);
		
		String quantidadeOut = format.format(quantidade);
		String montanteOut = format.format(montante);

		System.out.println(quantidadeOut + "\t\t\t" + locale.toString());
		System.out.println(montanteOut + "\t\t" + locale.toString());
	}

	public void mostrarMoeda() {
		
		Currency currency = Currency.getInstance(locale);
		NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
		
		Double montanteDinheiro = new Double(9876543.21);

		String mensagem = 
			locale.getDisplayName() + "\t" +
			currency.getDisplayName() + ": " +
			formatter.format(montanteDinheiro);
		
		System.out.println(mensagem);
	}

	public void mostrarPorcentagem() {
		
		NumberFormat formatter = NumberFormat.getPercentInstance(locale);
		
		Double porcentagem = new Double(0.75);
		
		String percentOut = formatter.format(porcentagem);

		System.out.println(percentOut + "\t\t\t" + locale.toString());
	}

	
}
