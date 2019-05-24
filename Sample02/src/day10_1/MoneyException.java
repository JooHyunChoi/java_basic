package day10_1;

public class MoneyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MoneyException() {
		// TODO Auto-generated constructor stub
		super("MoneyException  양수만 넣어줘");
	}
	public MoneyException(String msg) {
		super(msg);
	}
}
