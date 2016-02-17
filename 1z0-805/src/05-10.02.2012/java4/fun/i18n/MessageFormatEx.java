package java4.fun.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatEx {
	
	private Locale locale;
	private ResourceBundle messages;

	static public void main(String[] args) {
		new MessageFormatEx().iniciarShow();
	}
	
	private void iniciarShow(){
		defaultLocation();
		exemploFrFR();
		exemploDeDE();
		exemploEnUS();
	}
	
	private void defaultLocation(){
		locale = Locale.getDefault();
		exibeMensagens();
	}
	
	private void exemploFrFR(){
		locale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
		exibeMensagens();
	}
	
	private void exemploDeDE(){
		locale = new Locale.Builder().setLanguage("de").setRegion("DE").build();
		exibeMensagens();
	}
	
	private void exemploEnUS(){
		locale = new Locale.Builder().setLanguage("en").setRegion("US").build();
		exibeMensagens();
	}

	private void exibeMensagens() {

		System.out.println("currentLocale = " + locale.toString());

		messages = ResourceBundle.getBundle("MessagesBundle", locale);

		Object[] argumentos = {
				messages.getString("planet"),
				new Integer(7),
				new Date()
		};

		MessageFormat formatter = new MessageFormat("");
		formatter.setLocale(locale);

		formatter.applyPattern(messages.getString("template"));
		String output = formatter.format(argumentos);

		System.out.println(output);
		
		System.out.println();

	}

}
