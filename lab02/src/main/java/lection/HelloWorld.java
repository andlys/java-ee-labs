package lection;

public class HelloWorld {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("lection.StandartOutMessageRenderer");
		MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
		MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
		mr.setMessageProvider(mp);
		mr.render();
	}
}
