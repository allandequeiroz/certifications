package java4.fun.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatEx {
	
	private Locale locale;

	static public void main(String[] args) {
		new DateFormatEx().iniciarShow();
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
		mostrarEstiloDeDatas();
		mostrarEstiloDeHoras();
		mostrarEstiloDataHora();
		System.out.println();
	}

	public void mostrarEstiloDeDatas() {

		Date home = new Date();
		String resultado;
		DateFormat formatter;

		int[] estilos = {
				DateFormat.DEFAULT,
				DateFormat.SHORT, 
				DateFormat.MEDIUM,
				DateFormat.LONG,
				DateFormat.FULL
		};

		System.out.println();
		System.out.println("Locale: " + locale.toString());
		System.out.println();

		for (int k = 0; k < estilos.length; k++) {
			formatter = DateFormat.getDateInstance(estilos[k], locale);
			resultado = formatter.format(home);
			System.out.println(resultado);
		}
	}

	public void mostrarEstiloDeHoras() {

		Date hoje = new Date();
		String resultado;
		DateFormat formatter;

		int[] estilos = {
				DateFormat.DEFAULT,
				DateFormat.SHORT, 
				DateFormat.MEDIUM,
				DateFormat.LONG,
				DateFormat.FULL
		};

		System.out.println();
		System.out.println("Locale: " + locale.toString());
		System.out.println();

		for (int k = 0; k < estilos.length; k++) {
			formatter = DateFormat.getTimeInstance(estilos[k], locale);
			resultado = formatter.format(hoje);
			System.out.println(resultado);
		}
	}
	
	public void mostrarEstiloDataHora() {

		Date hoje;
		String resultado;
		DateFormat formatter;

		int[] estilos = {
				DateFormat.DEFAULT,
				DateFormat.SHORT, 
				DateFormat.MEDIUM,
				DateFormat.LONG,
				DateFormat.FULL
		};

		System.out.println();
		System.out.println("Locale: " + locale.toString());
		System.out.println();

		hoje = new Date();

		for (int k = 0; k < estilos.length; k++) {
			formatter = DateFormat.getDateTimeInstance(estilos[k], estilos[k], locale);
			resultado = formatter.format(hoje);
			System.out.println(resultado);
		}
	}

	public void displayDate() {

		DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		
		Date hoje = new Date();
		String data = formatter.format(hoje);
		
		System.out.println(data + "   " + locale.toString());
	}
}
