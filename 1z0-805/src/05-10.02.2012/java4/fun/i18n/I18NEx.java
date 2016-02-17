package java4.fun.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NEx {

	private Locale locale;
	private ResourceBundle messages;
	
	static public void main(String[] args) {
		new I18NEx().iniciarShow();
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
		locale = new Locale("fr", "FR");
		exibeMensagens();
	}
	
	private void exemploDeDE(){
		locale = new Locale("de", "DE");
		exibeMensagens();
	}
	
	private void exemploEnUS(){
		locale = new Locale("en", "US");
		exibeMensagens();
	}

	private void exibeMensagens() {
		messages = ResourceBundle.getBundle("MessagesBundle", locale);
		System.out.println(messages.getString("greetings"));
		System.out.println(messages.getString("inquiry"));
		System.out.println(messages.getString("farewell"));
		System.out.println();
	}
}
